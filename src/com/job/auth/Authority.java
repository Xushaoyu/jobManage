package com.job.auth;

import com.job.dao.StudentDao;
import com.job.dao.TeacherDao;
import com.job.model.Student;
import com.job.model.Teacher;
import com.job.util.Base64Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
    认证和权限
 */
public class Authority {
    private final StudentDao studentDao;

    private final TeacherDao teacherDao;

    /*
        认证使用cookie
     */
    private final String jobCookie = "jobCookie";

    /*
        学生权限数组：类名加方法名
     */
    private final List<String> student_power = Arrays.asList("StudentController/queryStudentById", "StudentController/addStudent");

    /*
        老师权限数组：类名加方法名
     */

    private final List<String> teacher_power = Arrays.asList("teacher/xxx", "teacher/xxx");

    public Authority() {
        this.studentDao = new StudentDao();
        this.teacherDao = new TeacherDao();
    }

    /*
        验证当前用户是否有权限访问接口
     */
    public Boolean verify(HttpServletRequest req, String className, String methodName){
        String url = className + "/" + methodName;
        System.out.println("current verify method:" +  url);

        // 从cookie中提取信息
        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            return false;
        }
        for (Cookie cookie: cookies){
            if(cookie.getName().equals(jobCookie)){
                String userInfo;
                try {
                    userInfo = Base64Util.decryBASE64(cookie.getValue());
                    System.out.println("解密后信息:\t" + userInfo);
                    String name = userInfo.split("==")[0];
                    String id = userInfo.split("==")[1];
                    String role = userInfo.split("==")[2];
                    // 根据当前角色判断是否有权限，如果有权限，检查数据库用户是否存在
                    if (Objects.equals(role, "student")){
                        if (!student_power.contains(url)){
                            return false;
                        }
                        Student student;
                        student = studentDao.verify(Integer.parseInt(id), name);
                        return student != null;
                    } else if (Objects.equals(role, "teacher")){
                        if (!teacher_power.contains(url)){
                            return false;
                        }
                        Teacher teacher;
                        teacher = teacherDao.verify(Integer.parseInt(id), name);
                        return teacher != null;
                    }
                } catch (Exception e) {
                    System.out.println("验证失败");
                }
            }
        }
        return false;
    }
}
