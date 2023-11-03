package com.job.dao;

import com.job.model.Student;
import com.job.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private final Connection connection;

    public StudentDao() {
        connection = DBUtil.getConnection();
    }

    public void addStudent(Student student) throws SQLException {
        Date date = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into students(student_number,student_password,student_name,student_class,update_time,create_time) values (?, ?, ?, ?, ?, ? )");
        // Parameters start with 1
        preparedStatement.setString(1, student.getStudentNumber());
        preparedStatement.setString(2, student.getStudentPassword());
        preparedStatement.setString(3, student.getStudentName());
        preparedStatement.setString(4, student.getStudentClass());
        preparedStatement.setDate(5, date);
        preparedStatement.setDate(6, date);
        preparedStatement.executeUpdate();
    }

    public void deleteStudent(int StudentId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("delete from students where student_id=?");
        // Parameters start with 1
        preparedStatement.setInt(1, StudentId);
        preparedStatement.executeUpdate();
    }

    public void updateStudent(Student student) throws SQLException {

        Date date = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement preparedStatement = connection
                .prepareStatement("update students set student_number=?, student_password=?, student_name=?, student_class=?, update_time=?" +
                        "where Studentid=?");
        // Parameters start with 1
        preparedStatement.setString(1, student.getStudentNumber());
        preparedStatement.setString(2, student.getStudentPassword());
        preparedStatement.setString(3, student.getStudentName());
        preparedStatement.setString(4, student.getStudentClass());
        preparedStatement.setDate(5, date);
        preparedStatement.setInt(6, student.getStudentId());
        preparedStatement.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<Student>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from students");
        while (rs.next()) {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentNumber(rs.getString("student_number"));
            student.setStudentName(rs.getString("student_name"));
            student.setStudentClass(rs.getString("student_class"));
            student.setUpdateTime(rs.getDate("update_time"));
            student.setCreateTime(rs.getDate("create_time"));
            students.add(student);
        }
        return students;
    }

    public Student getStudentById(int StudentId) throws SQLException {
        Student student = new Student();
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from students where student_id=?");
        preparedStatement.setInt(1, StudentId);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            student.setStudentNumber(rs.getString("student_number"));
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentName(rs.getString("student_name"));
            student.setStudentClass(rs.getString("student_class"));
            student.setUpdateTime(rs.getDate("update_time"));
            student.setCreateTime(rs.getDate("create_time"));
        }
        return student;
    }

    public Student login(String studentNumber, String studentPassword) throws SQLException {
        Student student = null;
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from students where student_number=? and student_password=?");
        preparedStatement.setString(1, studentNumber);
        preparedStatement.setString(2, studentPassword);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            student = new Student();
            student.setStudentNumber(rs.getString("student_number"));
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentName(rs.getString("student_name"));
            student.setStudentClass(rs.getString("student_class"));
            student.setUpdateTime(rs.getDate("update_time"));
            student.setCreateTime(rs.getDate("create_time"));
        }
        return student;
    }

    public Student verify(int studentId, String studentNumber) throws SQLException {
        Student student = null;
        PreparedStatement preparedStatement = connection.
                prepareStatement("select * from students where student_id=? and student_number=?");
        preparedStatement.setInt(1, studentId);
        preparedStatement.setString(2, studentNumber);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            student = new Student();
            student.setStudentNumber(rs.getString("student_number"));
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentName(rs.getString("student_name"));
            student.setStudentClass(rs.getString("student_class"));
            student.setUpdateTime(rs.getDate("update_time"));
            student.setCreateTime(rs.getDate("create_time"));
        }
        return student;
    }
}
