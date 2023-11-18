package com.job.dao;

import com.job.model.Assignment;
import com.job.model.AssignmentDTO;
import com.job.model.subDTO;
import com.job.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDao {
    private final Connection connection;

    public AssignmentDao() {
        connection = DBUtil.getConnection();
    }

    //老师发布作业
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
    //老师查看作业
    public List<subDTO> querySubDTO(int teacherId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select sub.submission_id,stu.student_name,ass.assignment_title,sub.submission_date,sub.file_path from teachers tea join assignments ass on tea.teacher_id=ass.tea_id\n" +
                "join submissions sub on sub.assignment_id =ass.assignment_id\n" +
                "join students stu on stu.student_id = sub.student_id\n" +
                "where tea.teacher_id = ?");
        psm.setInt(1,teacherId);
        ResultSet rs = psm.executeQuery();
        List<subDTO> subDTOList = new ArrayList<subDTO>();
        if (rs.next()) {
            subDTO subDTO = new subDTO();
            subDTO.setSubId(rs.getInt("submission_id"));
            subDTO.setStuName(rs.getString("student_name"));
            subDTO.setAssignTitle(rs.getString("assignment_title"));
            subDTO.setSubDate(rs.getDate("submission_date"));
            subDTO.setFilePath(rs.getString("file_path"));
            subDTOList.add(subDTO);
        }
        return subDTOList;
    }

    //学生查看作业
    public List<AssignmentDTO> queryWork(int studentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select ass.assignment_title, ass.assignment_description, " +
                "ass.assignment_deadline, ass.assignment_subject " +
                "from assignments ass JOIN students stu on" +
                " ass.assignment_class = stu.student_class where stu.student_id = ?");
        psm.setInt(1,studentId);
        ResultSet rs = psm.executeQuery();
        List<AssignmentDTO> assignmentDTOS = new ArrayList<AssignmentDTO>();
        if (rs.next()) {
            AssignmentDTO assignmentDTO = new AssignmentDTO();
            assignmentDTO.setAssignmentTitle(rs.getString("assignmentTitle"));
            assignmentDTO.setAssignmentDescription(rs.getString("assignmentDescription"));
            assignmentDTO.setAssignmentDeadLine(rs.getDate("assignmentDeadline"));
            assignmentDTO.setAssignmentSubject(rs.getString("assignmentSubject"));
            assignmentDTOS.add(assignmentDTO);
        }
        return assignmentDTOS;
    }
}
