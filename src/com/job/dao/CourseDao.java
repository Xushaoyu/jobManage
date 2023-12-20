package com.job.dao;

import com.job.model.Assignment;
import com.job.model.Course;
import com.job.model.subDTO;
import com.job.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    private final Connection connection;

    public CourseDao() {
        connection = DBUtil.getConnection();
    }


    public List<Course> queryStuCourse(int studentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select co.course_name,co.course_img_url from course co join stu_course sc on co.course_id=sc.student_id where sc.student_id = ?");
        psm.setInt(1, studentId);
        ResultSet rs = psm.executeQuery();
        List<Course> courses = new ArrayList<Course>();
        if (rs.next()) {
            Course course = new Course();
            course.setCourseName(rs.getString("course_name"));
            course.setCourseImgUrl(rs.getString("course_img_url"));
            courses.add(course);
        }
        return courses;
    }

    public List<Course> queryTeaCourse(int teacherId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select co.course_name,co.course_img_url from course co join tea_course tc on co.course_id=tc.teacher_id where tc.teacher_id = ?");
        psm.setInt(1, teacherId);
        ResultSet rs = psm.executeQuery();
        List<Course> courses = new ArrayList<Course>();
        if (rs.next()) {
            Course course = new Course();
            course.setCourseName(rs.getString("course_name"));
            course.setCourseImgUrl(rs.getString("course_img_url"));
            courses.add(course);
        }
        return courses;
    }
}
