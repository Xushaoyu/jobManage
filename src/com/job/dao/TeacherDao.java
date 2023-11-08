package com.job.dao;

import com.job.model.Teacher;
import com.job.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {
    private final Connection connection;

    public TeacherDao() {
        connection = DBUtil.getConnection();
    }
    public Teacher verify(int teacherId, String teacherName) throws SQLException {
        Teacher teacher = null;
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from Teachers where teacher_id=? and teacher_name=?");
        preparedStatement.setInt(1, teacherId);
        preparedStatement.setString(2, teacherName);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            teacher = new Teacher();
            teacher.setTeacherNumber(rs.getInt("teacher_number"));
            teacher.setTeacherId(rs.getInt("teacher_id"));
            teacher.setTeacherName(rs.getString("teacher_name"));
            teacher.setTeacherAssignmentId(rs.getInt("teacher_assignment_id"));
            teacher.setUpdateTime(rs.getDate("update_time"));
            teacher.setCreateTime(rs.getDate("create_time"));
        }
        return teacher;
    }
}
