package com.job.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.job.model.Assignment;
import com.job.model.subDTO;
import com.job.util.DBUtil;

import java.sql.*;

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
                        "assignment_class, tea_id, update_time, create_time, course_id) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        // Parameters start with 1
        preparedStatement.setString(1, assignment.getAssignmentTitle());
        preparedStatement.setString(2, assignment.getAssignmentDescription());
        //把java的date转成sql的date,会丢失时分秒
        java.sql.Date deadLineDate = new java.sql.Date(assignment.getAssignmentDeadLine().getTime());
        preparedStatement.setDate(3, deadLineDate);
        preparedStatement.setString(4, assignment.getAssignmentClass());
        preparedStatement.setInt(5, assignment.getTeaId());
        preparedStatement.setDate(6, date);
        preparedStatement.setDate(7, date);
        preparedStatement.setInt(8, assignment.getCourseID());
        preparedStatement.executeUpdate();
    }
    //老师查看已提交的作业
    public JSONArray querySubDTO(int teacherId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select stu.student_id,sub.assignment_id,sub.submission_id,stu.student_name,ass.assignment_title,sub.submission_date,sub.file_path from teachers tea join assignments ass on tea.teacher_id=ass.tea_id\n" +
                "join submissions sub on sub.assignment_id =ass.assignment_id\n" +
                "join students stu on stu.student_id = sub.student_id\n" +
                "where tea.teacher_id = ?");
        psm.setInt(1,teacherId);
        ResultSet rs = psm.executeQuery();
        JSONArray subDTOList = new JSONArray();
        while (rs.next()) {
            subDTO subDTO = new subDTO();
            subDTO.setSubId(rs.getInt("submission_id"));
            subDTO.setStuId(rs.getInt("student_id"));
            subDTO.setAssignmentId(rs.getInt("assignment_id"));
            subDTO.setStuName(rs.getString("student_name"));
            subDTO.setAssignTitle(rs.getString("assignment_title"));
            subDTO.setSubDate(rs.getDate("submission_date"));
            subDTO.setFilePath(rs.getString("file_path"));
            subDTOList.add(subDTO);
        }
        return subDTOList;
    }

    //学生查看作业
    public JSONArray queryWork(int studentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select ass.assignment_id,ass.assignment_title, ass.assignment_description, " +
                "ass.assignment_deadline, ass.assignment_subject " +
                "from assignments ass JOIN students stu on" +
                " ass.assignment_class = stu.student_class where stu.student_id = ?");
        psm.setInt(1,studentId);
        ResultSet rs = psm.executeQuery();
        JSONArray assignmentDTOS = new JSONArray();
        while (rs.next()) {
            JSONObject assignmentDTO = new JSONObject();
            assignmentDTO.put("assignment_id", rs.getInt("assignment_id"));
            assignmentDTO.put("assignment_title", rs.getString("assignment_title"));
            assignmentDTO.put("assignment_description", rs.getString("assignment_description"));
            assignmentDTO.put("assignment_deadline", rs.getDate("assignment_deadline"));
            assignmentDTOS.add(assignmentDTO);
        }
        return assignmentDTOS;
    }

    //老师修改截至时间
    public void modify(Assignment assignment) throws SQLException {

        java.sql.Date deadLineDate = new java.sql.Date(assignment.getAssignmentDeadLine().getTime());
        PreparedStatement preparedStatement = connection
                .prepareStatement("update assignments set assignment_deadline =? where assignment_id =?");

        preparedStatement.setDate(1, deadLineDate);
        preparedStatement.setInt(2,assignment.getAssignmentId());

        preparedStatement.executeUpdate();
    }

    //通过课程id和学生id查看作业
    public JSONArray queryWorkByCourseStuId(int courseId, int studentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select ass.*" +
                "from assignments ass JOIN students stu on" +
                " ass.assignment_class = stu.student_class where stu.student_id = ? and ass.course_id = ?");
        psm.setInt(1,studentId);
        psm.setInt(2,courseId);
        ResultSet rs = psm.executeQuery();
        JSONArray assignmentDTOS = new JSONArray();
        while (rs.next()) {
            Assignment assignmentDTO = new Assignment();
            assignmentDTO.setAssignmentId(rs.getInt("assignment_id"));
            assignmentDTO.setAssignmentTitle(rs.getString("assignment_title"));
            assignmentDTO.setAssignmentDescription(rs.getString("assignment_description"));
            assignmentDTO.setAssignmentDeadLine(rs.getDate("assignment_deadline"));
            assignmentDTO.setAssignmentClass(rs.getString("assignment_class"));
            assignmentDTO.setTeaId(rs.getInt("tea_id"));
            assignmentDTO.setCourseID(rs.getInt("course_id"));
            assignmentDTO.setCreateTime(rs.getDate("create_time"));
            assignmentDTO.setUpdateTime(rs.getDate("update_time"));
            assignmentDTOS.add(assignmentDTO);
        }
        return assignmentDTOS;
    }

    //通过作业id查看,提交表里的提交状态
    public int queryStatus(int assignmentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select status from submissions where assignment_id = ? LIMIT 1");
        psm.setInt(1,assignmentId);
        ResultSet rs = psm.executeQuery();
        int status = -1;
        while (rs.next()) {
            status = rs.getInt("status");
        }
        return status;
    }

    //通过课程id和老师id查看提交的作业
    public JSONArray querySubWorkByCourseTeaId(int courseId, int teacherId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select stu.student_id,sub.assignment_id,sub.submission_id,stu.student_name,ass.assignment_title,sub.submission_date,sub.file_path from teachers tea join assignments ass on tea.teacher_id=ass.tea_id\n" +
                "join submissions sub on sub.assignment_id =ass.assignment_id\n" +
                "join students stu on stu.student_id = sub.student_id\n" +
                "where tea.teacher_id = ? and ass.course_id = ?");
        psm.setInt(1, teacherId);
        psm.setInt(2, courseId);
        ResultSet rs = psm.executeQuery();
        JSONArray subDTOList = new JSONArray();
        while (rs.next()) {
            subDTO subDTO = new subDTO();
            subDTO.setSubId(rs.getInt("submission_id"));
            subDTO.setStuId(rs.getInt("student_id"));
            subDTO.setAssignmentId(rs.getInt("assignment_id"));
            subDTO.setStuName(rs.getString("student_name"));
            subDTO.setAssignTitle(rs.getString("assignment_title"));
            subDTO.setSubDate(rs.getDate("submission_date"));
            subDTO.setFilePath(rs.getString("file_path"));
            subDTOList.add(subDTO);
        }
        return subDTOList;
    }
}
