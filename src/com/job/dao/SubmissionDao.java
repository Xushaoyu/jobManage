package com.job.dao;

import com.alibaba.fastjson.JSONObject;
import com.job.model.subDTO;
import com.job.util.DBUtil;

import java.sql.*;

public class SubmissionDao {
    private final Connection connection;

    public SubmissionDao() {
        connection = DBUtil.getConnection();
    }

    public String[] STATUS = {"未完成", "已提交", "已完成"};

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
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into submissions(student_id,assignment_id,submission_date,file_path,content,update_time,create_time,status)\n" +
                        "value(?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE\n" +
                        "submission_date = VALUES(submission_date)" +
                        ",file_path = VALUES(file_path)" +
                        ",content = VALUES(content)" +
                        ",update_time = VALUES(update_time)" +
                        ",create_time = VALUES(create_time)" +
                        ",status = VALUES(status);");

        preparedStatement.setInt(1, subdto.getStuId());
        preparedStatement.setInt(2, subdto.getAssignmentId());
        preparedStatement.setDate(3, date);
        preparedStatement.setString(4, subdto.getFilePath());
        preparedStatement.setString(5, subdto.getContent());
        preparedStatement.setDate(6, date);
        preparedStatement.setDate(7, date);
        preparedStatement.setInt(8, subdto.getStatus());
        preparedStatement.executeUpdate();
    }

    public JSONObject getSubmissionById(int submissionId) throws SQLException {
        JSONObject submission = new JSONObject();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from submissions where submissions_id=?");
        preparedStatement.setInt(1, submissionId);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            submission.put("submission_id", rs.getInt("submission_id"));
            submission.put("student_id", rs.getInt("student_id"));
            submission.put("assignment_id", rs.getInt("assignment_id"));
            submission.put("score", rs.getString("score"));
            submission.put("file_path", rs.getString("file_path"));
            submission.put("content", rs.getString("content"));
            submission.put("update_time", rs.getDate("update_time"));
            submission.put("create_time", rs.getDate("create_time"));
            submission.put("status", STATUS[rs.getInt("status")]);
        }
        return submission;
    }
}
