package controller;

import common.ConnectMysql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addAssignment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String assignmentTitle = req.getParameter("assignment_title");
        ConnectMysql connectMysql = new ConnectMysql();
        connectMysql.executeUpdate("insert into (assignments) " +
                "values("+"\'"+assignmentTitle+"\'"+")");
        System.out.println(666);
    }
}
