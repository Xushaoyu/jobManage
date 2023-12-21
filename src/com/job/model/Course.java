package com.job.model;

import java.util.Date;
public class Course {
    int courseId;
    String courseName;
    String courseImgUrl;
    String asIsDelete;
    Date  upDateTime;
    Date createTime;
    String teacher;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseImgUrl='" + courseImgUrl + '\'' +
                ", asIsDelete='" + asIsDelete + '\'' +
                ", upDateTime=" + upDateTime +
                ", createTime=" + createTime +
                ", teacher='" + teacher + '\'' +
                '}';
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
