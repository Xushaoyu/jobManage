package com.job.controller;

import com.job.dao.StudentDao;
import com.job.model.Student;
import com.job.util.Base64Util;
import com.job.util.MD5Generate;
import com.job.util.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Logger;


@WebServlet("/student/*")
public class StudentController extends HttpServlet {
    /*
        生成接口唯一标识符
     */
    private static final long serialVersionUID = 1L;

    /*
        日志输出对象
     */
    private static final Logger logger = Logger.getLogger(StudentController.class.getName());

    /*
        设置每个接口对应方法
     */
    private static final HashMap<String, String> urlMethodMap = new HashMap<>();

    static {
        urlMethodMap.put("queryStudentById", "GET");
        urlMethodMap.put("login", "GET");
        urlMethodMap.put("addStudent", "POST");
    }

    /*
        引入接口使用的ORM操作对象
     */
    private final StudentDao studentDao;

    public StudentController() {
        super();
        this.studentDao = new StudentDao();
    }

    /*
        方法映射
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        Method func = null;
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
    private Boolean verify(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            return false;
        }
        for (Cookie cookie: cookies){
            if(cookie.getName().equals("jobCookie")){
                String studentInfo = null;
                try {
                    studentInfo = Base64Util.decryBASE64(cookie.getValue());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("解密后信息:\t" + studentInfo);
                String studentName = studentInfo.split("==")[0];
                String studentId = studentInfo.split("==")[1];
                Student student = null;
                try {
                    student = studentDao.verify(Integer.parseInt(studentId), studentName);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                return student != null;
            }
        }
        return false;
    }

    /*
        通过id查找用户
     */
    private void queryStudentById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseData responseData = new ResponseData();
        if (!verify(req, resp)){
            responseData.writeResponseData(resp, 403, "verify fail", "");
        }

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
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseData responseData = new ResponseData();
        MD5Generate md5 = new MD5Generate();
        String password = md5.encode(req.getParameter("password"));
        try {
            Student student = studentDao.login(req.getParameter("studentNumber"), password);
            if (student == null) {
                responseData.writeResponseData(resp, "username or password is invalid");
            } else {
                String studentInfo= student.getStudentName() + "==" + student.getStudentId();
                Cookie cookie = new Cookie("jobCookie", Base64Util.encryptBASE64(studentInfo));
                System.out.println(Base64Util.encryptBASE64(studentInfo));
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
        新增学生(注册)
     */
    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MD5Generate md5 = new MD5Generate();
        Student student = new Student();
        ResponseData responseData = new ResponseData();
        if (!verify(req, resp)){
            responseData.writeResponseData(resp, 403, "verify fail", "");
        }
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
