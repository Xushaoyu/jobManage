package com.job.auth;

import com.alibaba.fastjson.JSONObject;
import com.job.dao.StudentDao;
import com.job.dao.TeacherDao;
import com.job.model.Student;
import com.job.model.Teacher;
import com.job.util.Common;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/*
    认证和权限
 */
public class Authority {
    private final StudentDao studentDao;

    private final TeacherDao teacherDao;

    public Authority() {
        this.studentDao = new StudentDao();
        this.teacherDao = new TeacherDao();
    }

    /*
        验证当前用户是否有权限访问接口
     */
    public Boolean verify(HttpServletRequest req, String className, String methodName) {
        String url = className + "/" + methodName;

        String[] userInfo = Common.getUserInfoFromCookies(req);
        if (userInfo == null){
            return false;
        }
        String number = userInfo[0];
        String id = userInfo[1];
        String role = userInfo[2];

        Properties prop = new Properties();
        InputStream inputStream = Authority.class.getClassLoader().getResourceAsStream("/servlet.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            return false;
        }

        // 根据当前角色判断是否有权限，如果有权限，检查数据库用户是否存在
        try {
            if (Objects.equals(role, "student")){
                List<String> student_power = Arrays.asList(prop.getProperty("student_power").split(", "));
                if (!student_power.contains(url)){
                    return false;
                }
                JSONObject student = studentDao.verify(Integer.parseInt(id), number);
                return student != null;
            } else if (Objects.equals(role, "teacher")){
                List<String> teacher_power = Arrays.asList(prop.getProperty("teacher_power").split(", "));
                if (!teacher_power.contains(url)){
                    return false;
                }
                JSONObject teacher = teacherDao.verify(Integer.parseInt(id), number);
                return teacher != null;
            }
        } catch (Exception e) {
            System.out.println("verify fail");
        }

        return false;
    }
}
