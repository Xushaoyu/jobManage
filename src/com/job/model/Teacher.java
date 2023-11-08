package com.job.model;

import java.util.Date;

public class Teacher {
    private int teacherId;
    private String teacherNumber;
    private String teacherPassword;
    private String teacherName;
    private int teacherAssignmentId;
    private Date updateTime;
    private Date createTime;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherAssignmentId() {
        return teacherAssignmentId;
    }

    public void setTeacherAssignmentId(int teacherAssignmentId) {
        this.teacherAssignmentId = teacherAssignmentId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherNumber=" + teacherNumber +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAssignmentId=" + teacherAssignmentId +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
