package com.job.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getRoutes")
public class ServletRoutes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();
        Collection<String> servletNames =  context.getServletRegistrations().keySet();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        Map<String, String> result = new HashMap<>();
        for (String servletName : servletNames) {
            result.put(servletName, context.getServletRegistrations().get(servletName).getMappings().toString());
        }
        writer.write(result.toString());
    }
}