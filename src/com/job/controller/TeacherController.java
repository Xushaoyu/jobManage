package com.job.controller;


import com.alibaba.fastjson.JSONObject;
import com.job.dao.TeacherDao;
import com.job.model.Teacher;
import com.job.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/teacher/*")
public class TeacherController extends BaseController {
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
    private final TeacherDao teacherDao;


    public TeacherController() {
        super();
        this.teacherDao = new TeacherDao();
        this.urlMethodMap.put("queryTeacherById", "GET");
        this.urlMethodMap.put("login", "GET");
        this.urlMethodMap.put("register", "POST");
        super.urlMethodMap = urlMethodMap;
    }

    //通过id查找老师
    public void queryTeacherById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ResponseData responseData = new ResponseData();
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        try {
            int teacherId = Integer.parseInt(userInfo[1]);
            JSONObject teacher = teacherDao.getTeacherById(teacherId);
            if (teacher.isEmpty()){
                responseData.writeResponseData(resp, 400, "teacher not found", null);
            } else {
                responseData.writeResponseData(resp, teacher);
            }
        } catch (Exception e) {
            responseData.writeResponseData(resp, 400, "error", e.getMessage());
        }
    }

    //通过教师号和密码登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ResponseData responseData = new ResponseData();
        MD5Generate md5 = new MD5Generate();
        try {
            String password = md5.encode(req.getParameter("teacherPassword"));
            JSONObject teacher = teacherDao.login(req.getParameter("teacherNumber"), password);
            if (teacher.isEmpty()) {
                responseData.writeResponseData(resp, 400,"fail","username or password is invalid");
            } else {
                String teacherInfo= teacher.getString("teacher_number") + "==" + teacher.getInteger("teacher_id") + "==teacher";
                Cookie cookie = new Cookie("jobCookie", Base64Util.encryptBASE64(teacherInfo));
                cookie.setMaxAge(60 * 60 * 24);
                cookie.setPath("/");  // 设置路径
                resp.addCookie(cookie);
                responseData.writeResponseData(resp, teacher);

            }
        } catch (SQLException e) {
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
        } catch (Exception e) {
            responseData.writeResponseData(resp, 400, "login fail", e.getMessage());
        }
    }

    //新增老师(注册)
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        MD5Generate md5 = new MD5Generate();
        Teacher teacher = new Teacher();
        ResponseData responseData = new ResponseData();
        try {
            //校验参数是否正确
            String password = md5.encode(req.getParameter("teacherPassword"));
            teacher.setTeacherPassword(password);
            teacher.setTeacherName(req.getParameter("teacherName"));
            teacher.setTeacherNumber(req.getParameter("teacherNumber"));
        } catch (Exception e) {
            responseData.writeResponseData(resp, 400, "params is invalid", e.getMessage());
            return;
        }
        try {
            teacherDao.addTeacher(teacher);
        } catch (SQLException e) {
            // 新增失败时返回失败
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
            return;
        }
        responseData.writeResponseData(resp, "新增成功");
    }
}
