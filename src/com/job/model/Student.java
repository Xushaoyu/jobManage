package com.job.model;

import java.util.Date;


public class Student {

	private int studentId;
	private String studentNumber;
	private String studentPassword;
	private String studentName;
	private String studentClass;
	private Date updateTime;
	private Date createTime;
	private String picture;

	public int getStudentId() {
		return studentId;
	}

	public Student setStudentId(int studentId) {
		this.studentId = studentId;
		return this;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public Student setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
		return this;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public Student setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
		return this;
	}

	public String getStudentName() {
		return studentName;
	}

	public Student setStudentName(String studentName) {
		this.studentName = studentName;
		return this;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public Student setStudentClass(String studentClass) {
		this.studentClass = studentClass;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Student setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Student setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getPicture() {
		return picture;
	}

	public Student setPicture(String picture) {
		this.picture = picture;
		return this;
	}

	@Override
	public String toString() {
		return "{" +
				"studentId=" + studentId +
				", studentNumber=" + studentNumber +
				", studentName='" + studentName + '\'' +
				", studentClass=" + studentClass +
				", updateTime=" + updateTime +
				", createTime=" + createTime +
				'}';
	}
}
