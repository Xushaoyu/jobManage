package com.job.model;

import java.util.Date;

public class AssignmentDTO {
    private String assignmentId;
    private String assignmentTitle;
    private String assignmentDescription;
    private Date assignmentDeadLine;
    private String assignmentSubject;

    @Override
    public String toString() {
        return "AssignmentDTO{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentTitle='" + assignmentTitle + '\'' +
                ", assignmentDescription='" + assignmentDescription + '\'' +
                ", assignmentDeadLine=" + assignmentDeadLine +
                ", assignmentSubject='" + assignmentSubject + '\'' +
                '}';
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
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

    public String getAssignmentSubject() {
        return assignmentSubject;
    }

    public void setAssignmentSubject(String assignmentSubject) {
        this.assignmentSubject = assignmentSubject;
    }
}
