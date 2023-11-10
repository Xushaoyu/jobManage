package com.job.dao;

import com.job.model.Student;
import com.job.model.Teacher;
import com.job.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Teacher> getAllTeachers() throws SQLException {
        List<Teacher> teachers = new ArrayList<Teacher>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from teachers");
        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(rs.getInt("teacher_id"));
            teacher.setTeacherNumber(rs.getString("teacher_number"));
            teacher.setTeacherName(rs.getString("teacher_name"));
            teacher.setUpdateTime(rs.getDate("update_time"));
            teacher.setCreateTime(rs.getDate("create_time"));
            teachers.add(teacher);
        }
        return teachers;
    }

    public Teacher getTeacherById(int TeacherId) throws SQLException {
        Teacher teacher = new Teacher();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from teachers where teacher_id=?");
        preparedStatement.setInt(1, TeacherId);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            teacher.setTeacherId(rs.getInt("teacher_id"));
            teacher.setTeacherNumber(rs.getString("teacher_number"));
            teacher.setTeacherName(rs.getString("teacher_name"));
            teacher.setUpdateTime(rs.getDate("update_time"));
            teacher.setCreateTime(rs.getDate("create_time"));
        }
        return teacher;
    }

    public Teacher login(String teacherNumber, String teacherPassword) throws SQLException {
        Teacher teacher = new Teacher();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from teachers where teacher_number=? and teacher_password=?");
        preparedStatement.setString(1, teacherNumber);
        preparedStatement.setString(2, teacherPassword);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            teacher.setTeacherId(rs.getInt("teacher_id"));
            teacher.setTeacherNumber(rs.getString("teacher_number"));
            teacher.setTeacherName(rs.getString("teacher_name"));
            teacher.setUpdateTime(rs.getDate("update_time"));
            teacher.setCreateTime(rs.getDate("create_time"));
        }
        return teacher;
    }

    public Teacher verify(int teacherId, String teacherName) throws SQLException {
        Teacher teacher = new Teacher();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from teachers where teacher_id=? and teacher_name=?");
        preparedStatement.setInt(1, teacherId);
        preparedStatement.setString(2, teacherName);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            teacher.setTeacherNumber(rs.getString("teacher_number"));
            teacher.setTeacherId(rs.getInt("teacher_id"));
            teacher.setTeacherName(rs.getString("teacher_name"));
            teacher.setUpdateTime(rs.getDate("update_time"));
            teacher.setCreateTime(rs.getDate("create_time"));
        }
        return teacher;
    }
}
