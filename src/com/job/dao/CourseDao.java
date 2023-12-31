package com.job.dao;

import com.alibaba.fastjson.JSONArray;
import com.job.model.Course;
import com.job.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    private final Connection connection;

    public CourseDao() {
        connection = DBUtil.getConnection();
    }


    public JSONArray queryStuCourse(int studentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select co.* from course co join stu_course sc on co.course_id=sc.course_id where sc.student_id = ?");
        psm.setInt(1, studentId);
        ResultSet rs = psm.executeQuery();
        JSONArray courses = new JSONArray();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setCourseName(rs.getString("course_name"));
            course.setCourseImgUrl(rs.getString("course_img_url"));
            course.setUpDateTime(rs.getDate("update_time"));
            course.setCreateTime(rs.getDate("create_time"));
            course.setTeacher(rs.getString("teacher"));
            courses.add(course);
        }
        return courses;
    }

    public JSONArray queryTeaCourse(int teacherId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select co.* from course co join tea_course tc on co.course_id=tc.course_id where tc.teacher_id = ?");
        psm.setInt(1, teacherId);
        ResultSet rs = psm.executeQuery();
        JSONArray courses = new JSONArray();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setCourseName(rs.getString("course_name"));
            course.setCourseImgUrl(rs.getString("course_img_url"));
            course.setUpDateTime(rs.getDate("update_time"));
            course.setCreateTime(rs.getDate("create_time"));
            courses.add(course);
        }
        return courses;
    }

    public int addCourse(String courseName, String fileUrl) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("insert into course (course_name,course_img_url,update_time,create_time) values (?,?,?,?)");
        Date date = new java.sql.Date(System.currentTimeMillis());
        psm.setString(1, courseName);
        psm.setString(2, fileUrl);
        psm.setDate(3, date);
        psm.setDate(4, date);
        int count = psm.executeUpdate();
        return count;
    }
}
