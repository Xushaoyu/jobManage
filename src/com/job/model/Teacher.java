package com.job.model;

import java.util.Date;

public class Teacher {
    private int teacherId;
    private int teacherNumber;
    private String teacherPassword;
    private String teacherName;
    private int teacherAssignmentId;
    private Date updateTime;
    private Date createTime;

    public int getTeacherId() {
        return teacherId;
    }

    public Teacher setTeacherId(int teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public int getTeacherNumber() {
        return teacherNumber;
    }

    public Teacher setTeacherNumber(int teacherNumber) {
        this.teacherNumber = teacherNumber;
        return this;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public Teacher setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public int getTeacherAssignmentId() {
        return teacherAssignmentId;
    }

    public Teacher setTeacherAssignmentId(int teacherAssignmentId) {
        this.teacherAssignmentId = teacherAssignmentId;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Teacher setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Teacher setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
