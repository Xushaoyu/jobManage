package com.job.controller;

import com.alibaba.fastjson.JSONObject;
import com.job.dao.StudentDao;
import com.job.model.Student;
import com.job.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;


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


    public StudentController() {
        super();
        this.studentDao = new StudentDao();
        this.urlMethodMap.put("queryStudentById", "GET");
        this.urlMethodMap.put("login", "GET");
        this.urlMethodMap.put("register", "POST");
        super.urlMethodMap = urlMethodMap;
    }

    /*
        通过id查找用户
     */
    public void queryStudentById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ResponseData responseData = new ResponseData();
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        try {
            int studentId = Integer.parseInt(userInfo[1]);
            JSONObject student = studentDao.getStudentById(studentId);
            if (student.isEmpty()){
                responseData.writeResponseData(resp, 400, "student not found", null);
            } else {
                responseData.writeResponseData(resp, student);
            }
        } catch (Exception e) {
            responseData.writeResponseData(resp, 400, "error", e.getMessage());
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
            JSONObject student = studentDao.login(req.getParameter("studentNumber"), password);
            if (student.isEmpty()) {
                responseData.writeResponseData(resp,400,"fail", "username or password is invalid");
            } else {
                String studentInfo = student.getString("student_number") + "==" + student.getInteger("student_id") + "==student";
                Cookie cookie = new Cookie("jobCookie", Base64Util.encryptBASE64(studentInfo));
                cookie.setMaxAge(60 * 60 * 24);
                cookie.setPath("/"); // 设置Cookie的路径为根路径
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
}
