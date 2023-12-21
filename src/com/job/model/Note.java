package com.job.model;

import java.util.Date;

public class Note {
    int noteId;
    int studentId;
    String content;
    Date createTime;

    @Override
    public String toString() {
        return "{" +
                "noteId=" + noteId +
                ", studentId=" + studentId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
