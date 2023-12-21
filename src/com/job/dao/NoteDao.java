package com.job.dao;

import com.job.model.Course;
import com.job.model.Note;
import com.job.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {
    private final Connection connection;

    public NoteDao() {
        connection = DBUtil.getConnection();
    }
    public List<Note> queryNote(int studentId) throws SQLException {
        PreparedStatement psm = connection.prepareStatement("select * from note where student_id = ?");
        psm.setInt(1, studentId);
        ResultSet rs = psm.executeQuery();
        List<Note> notes = new ArrayList<Note>();
        while (rs.next()) {
            Note note = new Note();
            note.setNoteId(rs.getInt("note_id"));
            note.setStudentId(rs.getInt("student_id"));
            note.setContent(rs.getString("content"));
            note.setCreateTime(rs.getDate("create_time"));
            notes.add(note);
        }
        return notes;
    }
}
