//package com.job.controller;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.job.model.Student;
//
//public class UserController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private static final String INSERT_OR_EDIT = "/user.jsp";
//    private static final String LIST_USER = "/listUser.jsp";
//    private final UserDao dao;
//
//    public UserController() {
//        super();
//        dao = new UserDao();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String forward="";
//        String action = request.getParameter("action");
//
//        if (action.equalsIgnoreCase("delete")){
//            int userId = Integer.parseInt(request.getParameter("userId"));
//            dao.deleteUser(userId);
//            forward = LIST_USER;
//            request.setAttribute("users", dao.getAllUsers());
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//            int userId = Integer.parseInt(request.getParameter("userId"));
//            Student student = dao.getUserById(userId);
//            request.setAttribute("user", student);
//        } else if (action.equalsIgnoreCase("listUser")){
//            forward = LIST_USER;
//            request.setAttribute("users", dao.getAllUsers());
//        } else {
//            forward = INSERT_OR_EDIT;
//        }
//
//        RequestDispatcher view = request.getRequestDispatcher(forward);
//        view.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Student student = new Student();
//        student.setFirstName(request.getParameter("firstName"));
//        student.setLastName(request.getParameter("lastName"));
//        try {
//            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
//            student.setDob(dob);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        student.setEmail(request.getParameter("email"));
//        String userid = request.getParameter("userid");
//        if(userid == null || userid.isEmpty())
//        {
//            dao.addUser(student);
//        }
//        else
//        {
//            student.setUserid(Integer.parseInt(userid));
//            dao.updateUser(student);
//        }
//        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
//        request.setAttribute("users", dao.getAllUsers());
//        view.forward(request, response);
//    }
//}