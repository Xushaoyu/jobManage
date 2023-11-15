package com.job.dao;

import com.job.util.DBUtil;

import java.sql.Connection;
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
}
