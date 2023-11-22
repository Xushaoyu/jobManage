package com.job.controller;

import com.job.dao.AssignmentDao;
import com.job.dao.StudentDao;
import com.job.dao.SubmissionDao;
import com.job.model.Assignment;
import com.job.model.AssignmentDTO;
import com.job.model.Student;
import com.job.model.subDTO;
import com.job.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


@WebServlet("/student/*")
public class StudentController extends BaseController {
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
    private final StudentDao studentDao;
    private final AssignmentDao assignmentDao;
    private final SubmissionDao submissionDao;


    public StudentController() {
        super();
        this.studentDao = new StudentDao();
        this.assignmentDao = new AssignmentDao();
        this.submissionDao=new SubmissionDao();
        this.urlMethodMap.put("queryStudentById", "GET");
        this.urlMethodMap.put("login", "GET");
        this.urlMethodMap.put("register", "POST");
        this.urlMethodMap.put("queryWork", "GET");
        this.urlMethodMap.put("commitWork", "POST");
        super.urlMethodMap = urlMethodMap;
    }

    /*
        通过id查找用户
     */
    public void queryStudentById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ResponseData responseData = new ResponseData();
        try {
            Student student = studentDao.getStudentById(Integer.parseInt(req.getParameter("studentId")));
            responseData.writeResponseData(resp, student.toString());
        } catch (SQLException e) {
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
        }
    }

    /*
        通过学号和密码登录
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ResponseData responseData = new ResponseData();
        MD5Generate md5 = new MD5Generate();
        try {
            String password = md5.encode(req.getParameter("password"));
            Student student = studentDao.login(req.getParameter("studentNumber"), password);//请求带进来的参数
            if (student == null) {
                responseData.writeResponseData(resp, "username or password is invalid");
            } else {
                String studentInfo = student.getStudentNumber() + "==" + student.getStudentId() + "==student";
                Cookie cookie = new Cookie("jobCookie", Base64Util.encryptBASE64(studentInfo));
                System.out.println(Base64Util.encryptBASE64(studentInfo));
                cookie.setMaxAge(60 * 60 * 24);
                resp.addCookie(cookie);
                responseData.writeResponseData(resp, "登录成功");
            }
        } catch (SQLException e) {
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
        } catch (Exception e) {
            responseData.writeResponseData(resp, 400, "login fail", e.getMessage());
        }
    }

    /*
        新增学生(注册)
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        MD5Generate md5 = new MD5Generate();
        Student student = new Student();
        ResponseData responseData = new ResponseData();
        try {
            //校验参数是否正确
            String password = md5.encode(req.getParameter("password"));
            student.setStudentPassword(password);
            student.setStudentName(req.getParameter("studentName"));
            student.setStudentNumber(req.getParameter("studentNumber"));
            student.setStudentClass(req.getParameter("studentClass"));
        } catch (Exception e) {
            responseData.writeResponseData(resp, 400, "params is invalid", e.getMessage());
            return;
        }
        try {
            studentDao.addStudent(student);
        } catch (SQLException e) {
            // 新增失败时返回失败
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
            return;
        }
        responseData.writeResponseData(resp, "新增成功");
    }

    //学生查看作业
    public void queryWork(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        //拿到学生id
        String[] userInfo = Common.getUserInfoFromCookies(req);
        int studentId = Integer.parseInt(userInfo[1]);
        //调用DAO层拿结果
        List<AssignmentDTO> assignmentDTOS = assignmentDao.queryWork(studentId);
        //输出到浏览器
        ResponseData responseData = new ResponseData();
        responseData.writeResponseData(resp,assignmentDTOS.toString());
    }



    /*****学生提交作业*****/
    public void commitWork(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        //拿到请求传来的参数
        //通过传一个subDTO对象将参数传入
        ResponseData responseData = new ResponseData();
        subDTO subdto = new subDTO();
        //拿到学生id
        String[] userInfo = Common.getUserInfoFromCookies(req);
        int studentId = Integer.parseInt(userInfo[1]);
        // 获取作业ID作为字符串
        String assignmentIdStr = req.getParameter("assignmentId");
        // 将作业ID字符串转换为整数
        int assignmentId = Integer.parseInt(assignmentIdStr);
        // 然后使用该整数值设置DTO的作业ID

        try {
            subdto.setSubId(studentId);
            subdto.setAssignmentId(assignmentId);
            subdto.setStuName(req.getParameter("stuName"));
            subdto.setAssignTitle(req.getParameter("assignTitle"));
            subdto.setFilePath(req.getParameter("filePath"));
        }catch (Exception e) {
            responseData.writeResponseData(resp, 400, "params is invalid", e.getMessage());
            return;
        }
        try {
            submissionDao.commit(subdto);

        } catch (SQLException e) {
            // 新增失败时返回失败
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
            return;
        }
        responseData.writeResponseData(resp, "新增成功");

        //使用传来的参数执行插入语句

        //根据返回结果显示成功与否
    }




}
