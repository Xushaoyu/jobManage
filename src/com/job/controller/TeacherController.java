package com.job.controller;

import com.job.dao.TeacherDao;
import com.job.model.Teacher;
import com.job.util.Base64Util;
import com.job.util.MD5Generate;
import com.job.util.ResponseData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

@WebServlet("/teacher/*")
public class TeacherController extends HttpServlet {
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
    private static final HashMap<String, String> urlMethodMap = new HashMap<>();

    static {
        urlMethodMap.put("queryTeacherById", "GET");
        urlMethodMap.put("login", "GET");
        urlMethodMap.put("addTeacher", "POST");
    }

    /*
        引入接口使用的ORM操作对象
     */
    private final TeacherDao teacherDao;

    public TeacherController() {
        super();
        this.teacherDao = new TeacherDao();
    }

    /*
        方法映射
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String method = req.getMethod();
        // 获取请求的URI地址信息
        String url = req.getRequestURI();
        // 截取其中的方法名
        String methodName = url.substring(url.lastIndexOf("/") + 1);
        System.out.printf("current url: %s, method: %s\n", methodName, urlMethodMap.get(methodName));
        if (!Objects.equals(urlMethodMap.get(methodName), method)) {
            resp.getWriter().println("404");
            return;
        }
        Method func;
        try {
            // 使用反射机制获取在本类中声明了的方法
            func = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            func.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            resp.getWriter().println("404");
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    /*
        验证cookie身份
     */
    private Boolean verify(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            return false;
        }
        for (Cookie cookie: cookies){
            if(cookie.getName().equals("jobCookie")){
                String teacherInfo;
                try {
                    teacherInfo = Base64Util.decryBASE64(cookie.getValue());
                    System.out.println("解密后信息:\t" + teacherInfo);
                    String teacherName = teacherInfo.split("==")[0];
                    String teacherId = teacherInfo.split("==")[1];
                    Teacher teacher;
                    teacher = teacherDao.verify(Integer.parseInt(teacherId), teacherName);
                    return teacher != null;
                } catch (Exception e) {
                    System.out.println("验证失败");
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /*
        通过id查找用户
     */
    private void queryTeacherById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ResponseData responseData = new ResponseData();
        if (!verify(req)){
            responseData.writeResponseData(resp, 403, "verify fail", "");
        }

        try {
            Teacher teacher = teacherDao.getTeacherById(Integer.parseInt(req.getParameter("teacherId")));
            responseData.writeResponseData(resp, teacher.toString());
        } catch (SQLException e) {
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
        }
    }

    /*
        通过学号和密码登录
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, NoSuchAlgorithmException {
        ResponseData responseData = new ResponseData();
        MD5Generate md5 = new MD5Generate();
        String password = md5.encode(req.getParameter("teacher_password"));
        try {
            Teacher teacher = teacherDao.login(req.getParameter("teacherNumber"), password);
            if (teacher == null) {
                responseData.writeResponseData(resp, "username or password is invalid");
            } else {
                String teacherInfo= teacher.getTeacherName() + "==" + teacher.getTeacherName();
                Cookie cookie = new Cookie("jobCookie", Base64Util.encryptBASE64(teacherInfo));
                System.out.println(Base64Util.encryptBASE64(teacherInfo));
                cookie.setMaxAge(60 * 60 * 24);
                resp.addCookie(cookie);
                responseData.writeResponseData(resp, "登录成功");
            }
        } catch (SQLException e) {
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
        新增老师(注册)
     */
    private void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        }
        try {
            teacherDao.addTeacher(teacher);
        } catch (SQLException e) {
            // 新增失败时返回失败
            responseData.writeResponseData(resp, 400, "sql error", e.getMessage());
        }
        responseData.writeResponseData(resp, "新增成功");
    }
}
