package com.job.controller;

import com.alibaba.fastjson.JSONArray;
import com.job.dao.CourseDao;
import com.job.util.Common;
import com.job.util.ResponseData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/course/*")
public class CourseController extends BaseController{
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
    private final CourseDao courseDao;


    public CourseController() {
        super();
        this.courseDao = new CourseDao();
        this.urlMethodMap.put("queryCourse", "GET");
        super.urlMethodMap = urlMethodMap;
    }

    //学生/老师查看课程
    public void queryCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        //拿到id
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        if (userInfo[2].equals("student")){
            int studentId = Integer.parseInt(userInfo[1]);
            //调用DAO层拿结果
            JSONArray courses = courseDao.queryStuCourse(studentId);
            //输出到浏览器
            ResponseData responseData = new ResponseData();
            responseData.writeResponseData(resp,courses);
        } else if (userInfo[2].equals("teacher")) {
            int teacherId = Integer.parseInt(userInfo[1]);
            //调用DAO层拿结果
            JSONArray courses = courseDao.queryTeaCourse(teacherId);
            //输出到浏览器
            ResponseData responseData = new ResponseData();
            responseData.writeResponseData(resp,courses);
        }
    }
}
