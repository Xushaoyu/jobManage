package com.job.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.job.model.Teacher;
import com.job.util.DBUtil;

import java.sql.*;

public class TeacherDao {
    private final Connection connection;

    public TeacherDao() {
        connection = DBUtil.getConnection();
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        Date date = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into teachers(teacher_name, teacher_number, teacher_password, update_time, create_time) values (?, ?, ?, ?, ?)");
        // Parameters start with 1
        preparedStatement.setString(1, teacher.getTeacherName());
        preparedStatement.setString(2, teacher.getTeacherNumber());
        preparedStatement.setString(3, teacher.getTeacherPassword());
        preparedStatement.setDate(4, date);
        preparedStatement.setDate(5, date);
        preparedStatement.executeUpdate();
    }

    public void deleteTeacher(int TeacherId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("delete from teachers where teacher_id=?");
        // Parameters start with 1
        preparedStatement.setInt(1, TeacherId);
        preparedStatement.executeUpdate();
    }

    public void updateStudent(Teacher teacher) throws SQLException {

        Date date = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement preparedStatement = connection
                .prepareStatement("update teachers set teacher_name=?, teacher_number=?, teacher_password=?, update_time=?" +
                        "where teacher_id=?");
        // Parameters start with 1
        preparedStatement.setString(1, teacher.getTeacherName());
        preparedStatement.setString(2, teacher.getTeacherNumber());
        preparedStatement.setString(3, teacher.getTeacherPassword());
        preparedStatement.setDate(4, date);
        preparedStatement.executeUpdate();
    }

    public JSONArray getAllTeachers() throws SQLException {
        JSONArray teachers = new JSONArray();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from teachers");
        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(rs.getInt("teacher_id"));
            teacher.setTeacherNumber(rs.getString("teacher_number"));
            teacher.setTeacherName(rs.getString("teacher_name"));
            teacher.setUpdateTime(rs.getDate("update_time"));
            teacher.setCreateTime(rs.getDate("create_time"));
//            JSONObject teacher = new JSONObject();
//            teacher.put("teacher_id", rs.getInt("teacher_id"));
//            teacher.put("teacher_number", rs.getString("teacher_number"));
//            teacher.put("teacher_name", rs.getString("teacher_name"));
//            teacher.put("update_time", rs.getDate("update_time"));
//            teacher.put("create_time", rs.getDate("create_time"));
            teachers.add(teacher);
        }
        return teachers;
    }

    public JSONObject getTeacherById(int TeacherId) throws SQLException {
        JSONObject teacher = new JSONObject();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from teachers where teacher_id=?");
        preparedStatement.setInt(1, TeacherId);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            teacher.put("teacher_id", rs.getInt("teacher_id"));
            teacher.put("teacher_number", rs.getString("teacher_number"));
            teacher.put("update_time", rs.getDate("update_time"));
            teacher.put("create_time", rs.getDate("create_time"));
        }
        return teacher;
    }

    public JSONObject login(String teacherNumber, String teacherPassword) throws SQLException {
        JSONObject teacher = new JSONObject();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from teachers where teacher_number=? and teacher_password=?");
        preparedStatement.setString(1, teacherNumber);
        preparedStatement.setString(2, teacherPassword);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            teacher.put("teacher_id", rs.getInt("teacher_id"));
            teacher.put("teacher_number", rs.getString("teacher_number"));
            teacher.put("teacher_name", rs.getString("teacher_name"));
            teacher.put("update_time", rs.getDate("update_time"));
            teacher.put("create_time", rs.getDate("create_time"));
            teacher.put("picture", rs.getString("picture"));
        }
        return teacher;
    }

    public JSONObject verify(int teacherId, String teacherNumber) throws SQLException {
        JSONObject teacher = new JSONObject();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from teachers where teacher_id=? and teacher_number=?");
        preparedStatement.setInt(1, teacherId);
        preparedStatement.setString(2, teacherNumber);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            teacher.put("teacher_id", rs.getInt("teacher_id"));
            teacher.put("teacher_number", rs.getString("teacher_number"));
            teacher.put("teacher_name", rs.getString("teacher_name"));
        }
        return teacher;
    }
}
