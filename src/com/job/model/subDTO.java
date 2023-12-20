package com.job.model;

import java.util.Date;

public class subDTO {
    int subId;
    int stuId;
    int assignmentId;
    String stuName;
    String assignTitle;
    Date subDate;
    String filePath;


    @Override
    public String toString() {
        return "subDTO{" +
                "subId=" + subId +
                ", stuId=" + stuId +
                ", assignmentId=" + assignmentId +
                ", stuName='" + stuName + '\'' +
                ", assignTitle='" + assignTitle + '\'' +
                ", subDate=" + subDate +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getAssignTitle() {
        return assignTitle;
    }

    public void setAssignTitle(String assignTitle) {
        this.assignTitle = assignTitle;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
