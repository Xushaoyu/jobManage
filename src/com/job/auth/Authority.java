package com.job.auth;

import com.job.dao.StudentDao;
import com.job.dao.TeacherDao;
import com.job.model.Student;
import com.job.model.Teacher;
import com.job.util.Common;

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
        学生权限数组：类名加方法名
     */
    private final List<String> student_power = Arrays.asList("StudentController/queryStudentById", "StudentController/addStudent", "StudentController/queryStudentById");

    /*
        老师权限数组：类名加方法名
     */

    private final List<String> teacher_power = Arrays.asList("TeacherController/publishJob", "teacher/xxx");

    public Authority() {
        this.studentDao = new StudentDao();
        this.teacherDao = new TeacherDao();
    }

    /*
        验证当前用户是否有权限访问接口
     */
    public Boolean verify(HttpServletRequest req, String className, String methodName) {
        String url = className + "/" + methodName;
        System.out.println("current verify method:" +  url);

        String[] userInfo = Common.getUserInfoFromCookies(req);
        if (userInfo == null){
            return false;
        }
        String name = userInfo[0];
        String id = userInfo[1];
        String role = userInfo[2];
        System.out.println(userInfo);
        // 根据当前角色判断是否有权限，如果有权限，检查数据库用户是否存在
        try {
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
            System.out.println("verify fail");
        }

        return false;
    }
}
