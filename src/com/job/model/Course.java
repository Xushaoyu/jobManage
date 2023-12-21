package com.job.model;

import java.util.Date;
public class Course {
    int courseId;
    String courseName;
    String courseImgUrl;
    String asIsDelete;
    Date  upDateTime;
    Date createTime;

    @Override
    public String toString() {
        return "{" +
                "courseId=" + courseId +
                ",courseName='" + courseName + '\'' +
                ", courseImgUrl='" + courseImgUrl + '\'' +
//                ", asIsDelete='" + asIsDelete + '\'' +
                ", upDateTime=" + upDateTime +
                ", createTime=" + createTime +
                '}';
    }

    public Course() {
    }

    public Course(int courseId, String courseName, String courseImgUrl, String asIsDelete, Date upDateTime, Date createTime) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseImgUrl = courseImgUrl;
        this.asIsDelete = asIsDelete;
        this.upDateTime = upDateTime;
        this.createTime = createTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public String getAsIsDelete() {
        return asIsDelete;
    }

    public void setAsIsDelete(String asIsDelete) {
        this.asIsDelete = asIsDelete;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
