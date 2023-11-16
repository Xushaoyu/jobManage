package com.job.dao;

import com.job.model.Assignment;
import com.job.util.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssignmentDao {
    private final Connection connection;

    public AssignmentDao() {
        connection = DBUtil.getConnection();
    }

    public void publish(Assignment assignment) throws SQLException {
        Date date = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into assignments(assignment_title, assignment_description, assignment_deadline, " +
                        "assignment_subject, assignment_class, tea_id, update_time, create_time) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)");
        // Parameters start with 1
        preparedStatement.setString(1, assignment.getAssignmentTitle());
        preparedStatement.setString(2, assignment.getAssignmentDescription());
        //把java的date转成sql的date,会丢失时分秒
        java.sql.Date deadLineDate = new java.sql.Date(assignment.getAssignmentDeadLine().getTime());
        preparedStatement.setDate(3, deadLineDate);
        preparedStatement.setString(4, assignment.getAssignmentSubject());
        preparedStatement.setString(5, assignment.getAssignmentClass());
        preparedStatement.setInt(6, assignment.getTeaId());
        preparedStatement.setDate(7, date);
        preparedStatement.setDate(8, date);
        preparedStatement.executeUpdate();
    }
}
