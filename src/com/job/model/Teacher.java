package com.job.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Teacher {
    private int teacherId;
    private String teacherNumber;
    private String teacherPassword;
    private String teacherName;
    private int teacherAssignmentId;
    private Date updateTime;
    private Date createTime;
    private String picture;

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

    public String getPicture() {
        return picture;
    }

    public Teacher setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "teacherId=" + teacherId +
                ", teacherNumber=" + teacherNumber +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAssignmentId=" + teacherAssignmentId +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }

    public HashMap<String, String> getResult() {
        HashMap<String, String> result = new HashMap<>();
        result.put("teacherId", String.valueOf(teacherId));
        result.put("teacherNumber", teacherNumber);
        result.put("teacherName", teacherName);
        return result;
    }

}
