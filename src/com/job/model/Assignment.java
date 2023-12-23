package com.job.model;

import java.util.Date;

public class Assignment {
    private int assignmentId;
    private String assignmentTitle;
    private String assignmentDescription;
    private Date assignmentDeadLine;
    private String assignmentClass;
    private int teaId;

    private int courseID;
    private Date updateTime;
    private Date createTime;

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", assignmentTitle='" + assignmentTitle + '\'' +
                ", assignmentDescription='" + assignmentDescription + '\'' +
                ", assignmentDeadLine=" + assignmentDeadLine +
                ", assignmentClass='" + assignmentClass + '\'' +
                ", teaId=" + teaId +
                ", courseID=" + courseID +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public Date getAssignmentDeadLine() {
        return assignmentDeadLine;
    }

    public void setAssignmentDeadLine(Date assignmentDeadLine) {
        this.assignmentDeadLine = assignmentDeadLine;
    }


    public String getAssignmentClass() {
        return assignmentClass;
    }

    public void setAssignmentClass(String assignmentClass) {
        this.assignmentClass = assignmentClass;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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
}
