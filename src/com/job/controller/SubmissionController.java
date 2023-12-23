package com.job.controller;


import com.alibaba.fastjson.JSONObject;

import com.job.dao.SubmissionDao;
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
import java.util.HashMap;

@WebServlet("/submission/*")
@MultipartConfig
public class SubmissionController extends BaseController {
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
    private final SubmissionDao submissionDao;


    public SubmissionController() {
        super();
        this.submissionDao = new SubmissionDao();
        this.urlMethodMap.put("commitWork", "POST");
        this.urlMethodMap.put("mark", "POST");
        super.urlMethodMap = urlMethodMap;
    }

    /*****学生提交答案*****/
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
        String fileUrl = "";
        String content = "";
        if (req.getParameter("content") != null) {
            content = req.getParameter("content");
        }
        Part filePart = req.getPart("file");
        if (filePart != null) {
            String staticFilePath = new File(getServletContext().getRealPath("")).getParentFile().getParentFile().getParentFile() + File.separator + "statics";
            String uploadDirectory = staticFilePath + File.separator + pathDir;
            FileProcessor fileProcessor = new FileProcessor(uploadDirectory);
            // 在需要的地方调用 FileProcessor 的方法
            String fileName = fileProcessor.processFile(filePart);
            if (fileName.equals("")) {
                responseData.writeResponseData(resp, 400, "文件流处理失败", "upload fail");
            }
            fileUrl = this.nginxUrl + pathDir + "/" + fileName;
        }

        subdto.setStuId(studentId);
        subdto.setAssignmentId(Integer.parseInt(req.getParameter("assignmentId")));
        subdto.setContent(content);
        subdto.setFilePath(fileUrl);
        //修改作业,1为已提交
        subdto.setStatus(1);

        submissionDao.commit(subdto);

        responseData.writeResponseData(resp, "新增成功");
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


    public void getSubmission(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int submissionId = Integer.parseInt(req.getParameter("submission_id"));
        ResponseData responseData = new ResponseData();
        try {
            JSONObject sub = submissionDao.getSubmissionById(submissionId);
            responseData.writeResponseData(resp, sub);
        } catch (Exception e) {
            responseData.writeResponseData(resp, 400, "fail", e.getMessage());
        }
    }
}
