package com.job.controller;


import com.job.dao.AssignmentDao;

import com.job.dao.SubmissionDao;
import com.job.model.Assignment;
import com.job.model.subDTO;
import com.job.util.Common;
import com.job.util.FileProcessor;
import com.job.util.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@WebServlet("/assignment/*")
@MultipartConfig
public class AssignmentController  extends BaseController{
    /*
    生成接口唯一标识符
 */
    private static final long serialVersionUID = 1L;

    /*
        日志输出对象
     */
//    private static final Logger logger = Logger.getLogger(StudentController.class.getName());

    /*
        设置每个接口对应方法
     */
    protected HashMap<String, String> urlMethodMap = new HashMap<>();

    /*
        引入接口使用的ORM操作对象
     */
    private final AssignmentDao assignmentDao;
    private final SubmissionDao submissionDao;


    public AssignmentController() {
        super();
        this.submissionDao = new SubmissionDao();
        this.assignmentDao = new AssignmentDao();
        this.urlMethodMap.put("queryWork", "GET");
        this.urlMethodMap.put("commitWork", "POST");
        this.urlMethodMap.put("publishJob", "POST");
        this.urlMethodMap.put("querySubDTO", "GET");
        this.urlMethodMap.put("mark", "POST");
        this.urlMethodMap.put("modify", "POST");
        this.urlMethodMap.put("queryWorkByCourseStuId", "GET");
        this.urlMethodMap.put("queryStatus", "GET");
        this.urlMethodMap.put("querySubWorkByCourseTeaId", "GET");
        super.urlMethodMap = urlMethodMap;
    }

    //学生查看作业
    public void queryWork(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        //拿到学生id
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        int studentId = Integer.parseInt(userInfo[1]);
        //调用DAO层拿结果
        List<Assignment> assignments = assignmentDao.queryWork(studentId);
        //输出到浏览器
        ResponseData responseData = new ResponseData();
        responseData.writeResponseData(resp,assignments.toString(),true);
    }

    /*****学生提交作业*****/
    public void commitWork(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        //拿到请求传来的参数
        //通过传一个subDTO对象将参数传入
        ResponseData responseData = new ResponseData();
        subDTO subdto = new subDTO();
        //拿到学生id
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        int studentId = Integer.parseInt(userInfo[1]);

        // 获取上传文件文件的输入流
        String pathDir = "assignment";
        Part filePart = req.getPart("file");
        String staticFilePath = new File(getServletContext().getRealPath("")).getParentFile().getParentFile().getParentFile()+ File.separator + "statics";
        String uploadDirectory = staticFilePath +  File.separator + pathDir;
        FileProcessor fileProcessor = new FileProcessor(uploadDirectory);
        // 在需要的地方调用 FileProcessor 的方法
        String fileName = fileProcessor.processFile(filePart);
        if (fileName.equals("")) {
            responseData.writeResponseData(resp, 400, "文件流处理失败", "upload fail");
        }
        String fileUrl = this.nginxUrl + pathDir + "/" + fileName;


        subdto.setStuId(studentId);
        subdto.setAssignmentId(Integer.parseInt(req.getParameter("assignmentId")));
        subdto.setFilePath(fileUrl);
        //修改作业,1为已提交
        subdto.setStatus(1);

        submissionDao.commit(subdto);

        responseData.writeResponseData(resp, "新增成功");
    }


    //发布作业
    public void publishJob(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException, IOException {
        Assignment assignment = new Assignment();
        //yyyy-MM-dd HH:mm:ss
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assignment.setAssignmentTitle(req.getParameter("assignmentTitle"));
        assignment.setAssignmentDescription(req.getParameter("assignmentDescription"));
        assignment.setAssignmentDeadLine(dateFormat.parse(req.getParameter("assignmentDeadLine")));
        assignment.setAssignmentSubject(req.getParameter("assignmentSubject"));
        assignment.setAssignmentClass(req.getParameter("assignmentClass"));
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        assignment.setTeaId(Integer.parseInt(userInfo[1]));
        assignmentDao.publish(assignment);
        ResponseData responseData = new ResponseData();
        responseData.writeResponseData(resp, "发布成功");
    }

    //老师查看已提交作业
    public void querySubDTO(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        //拿到老师Id
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        int teacherId = Integer.parseInt(userInfo[1]);
        //调用DAO层拿结果
        List<subDTO> subDTOS = assignmentDao.querySubDTO(teacherId);
        //输出到浏览器
        ResponseData responseData = new ResponseData();
        responseData.writeResponseData(resp,subDTOS.toString());
    }

    //老师批改提交(评分)
    public void mark(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        //1、接收浏览器传来的submissionId和score
        int submissionId = Integer.parseInt(req.getParameter("submissionId"));
        int score = Integer.parseInt(req.getParameter("score"));
        //2、调用DAO层
        submissionDao.mark(submissionId, score);
        //3、将修改结果返回浏览器
        ResponseData responseData = new ResponseData();
        responseData.writeResponseData(resp, "批改成功");
    }

    //修改截至时间
    public void modify(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
        Assignment assignment = new Assignment();
        ResponseData responseData = new ResponseData();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date assignmentDeadline = dateFormat.parse(req.getParameter("assignmentDeadline")) ;
        String[] userInfo = Common.getUserInfoFromCookies(req);
        int assignmentId = Integer.parseInt(req.getParameter("assignmentId"));


        assignment.setAssignmentDeadLine(assignmentDeadline);
        assert userInfo != null;
        assignment.setTeaId(Integer.parseInt(userInfo[1]));
        assignment.setAssignmentId(assignmentId);

        try {
            assignmentDao.modify(assignment);
        }catch (Exception e){
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
            return;
        }
        responseData.writeResponseData(resp, "修改成功");
    }

    //通过课程id和学生id查看作业
    public void queryWorkByCourseStuId(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        String[] userInfo = Common.getUserInfoFromCookies(req);
        ResponseData responseData = new ResponseData();
        int studentId = Integer.parseInt(userInfo[1]);
        try {
            List<Assignment> assignments = assignmentDao.queryWorkByCourseStuId(courseId, studentId);
            responseData.writeResponseData(resp, assignments.toString(),true);
        }catch (Exception e){
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
            return;
        }
    }

    public void queryStatus(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
        int assignmentId = Integer.parseInt(req.getParameter("assignmentId"));
        ResponseData responseData = new ResponseData();
        try {
            int status = assignmentDao.queryStatus(assignmentId);
            responseData.writeResponseData(resp, String.valueOf(status) ,true);
        }catch (Exception e){
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
            return;
        }
    }

    //通过课程id和老师id查看提交的作业
    public void querySubWorkByCourseTeaId(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        String[] userInfo = Common.getUserInfoFromCookies(req);
        ResponseData responseData = new ResponseData();
        int teacherId = Integer.parseInt(userInfo[1]);
        try {
            List<subDTO> subDTOS = assignmentDao.querySubWorkByCourseTeaId(courseId, teacherId);
            responseData.writeResponseData(resp, subDTOS.toString(),true);
        }catch (Exception e){
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
            return;
        }
    }
}
