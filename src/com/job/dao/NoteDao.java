package com.job.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.job.util.DBUtil;

import java.sql.*;

public class NoteDao {
    private final Connection connection;

    public NoteDao() {
        connection = DBUtil.getConnection();
    }
    public JSONArray queryNote(int studentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select * from note where student_id = ?");
        psm.setInt(1, studentId);
        StudentDao studentDao = new StudentDao();
        JSONObject studentInfo = studentDao.getStudentById(studentId);
        System.out.println(studentInfo);
        ResultSet rs = psm.executeQuery();
        JSONArray notes = new JSONArray();
        while (rs.next()) {
            JSONObject note = new JSONObject();
            note.put("noteId", rs.getInt("note_id"));
            note.put("studentId", rs.getInt("student_id"));
            note.put("content", rs.getString("content"));
            note.put("createTime", rs.getDate("create_time"));
            note.put("studentName", studentInfo.getString("student_name"));
            note.put("picture", studentInfo.getString("picture"));
            notes.add(note);
        }
        return notes;
    }

    public int deleteNote(int noteId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("delete from note where note_id = ?");
        psm.setInt(1, noteId);
        int count = psm.executeUpdate();
        return count;
    }

    public int saveNote(int studentId, String noteContent) throws SQLException {
        Date date = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement psm = connection.prepareStatement("insert into note (student_id, content, create_time)" +
                " values (?,?,?)");
        psm.setInt(1, studentId);
        psm.setString(2, noteContent);
        psm.setDate(3, date);
        int count = psm.executeUpdate();
        return count;
    }
}
