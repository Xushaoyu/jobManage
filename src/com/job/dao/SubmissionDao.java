package com.job.dao;

import com.job.model.subDTO;
import com.job.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubmissionDao {
    private final Connection connection;

    public SubmissionDao() {
        connection = DBUtil.getConnection();
    }

    public void mark(int submissionId, int score) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update submissions set score=? where submission_id=?");
        preparedStatement.setInt(1, score);
        preparedStatement.setInt(2, submissionId);
        preparedStatement.execute();
    }

    //学生提交作业
    public void commit(subDTO subdto) throws SQLException {
        //将传来的参数执行sql
        Date date = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement preparedStatement=connection
                .prepareStatement("insert into submissions(student_id,assignment_id,submission_date,file_path,update_time,create_time)\n" +
                        "value(?,?,?,?,?,?)");

        preparedStatement.setInt(1,subdto.getSubId());
        preparedStatement.setInt(2,subdto.getAssignmentId());
        preparedStatement.setDate(3,date);
        preparedStatement.setString(4,subdto.getFilePath());
        preparedStatement.setDate(5,date);
        preparedStatement.setDate(6,date);
        preparedStatement.executeUpdate();



    }
}
