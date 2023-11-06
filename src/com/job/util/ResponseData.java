package com.job.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseData {

    public void writeResponseData(HttpServletResponse resp, int code, String message, String data) throws IOException {
        String ResponseData = "ResponseData{" +
                              "code=" + code +
                              ", message='" + message + '\'' +
                              ", data='" + data + '\'' +
                              '}';
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(ResponseData);
        writer.flush();
        writer.close();
    }

    public void writeResponseData(HttpServletResponse resp, String data) throws IOException {
        String ResponseData = "ResponseData{" +
                              "code=" + "200" +
                              ", message='" + "success" + '\'' +
                              ", data='" + data + '\'' +
                              '}';
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(ResponseData);
        writer.flush();
        writer.close();
    }

}
