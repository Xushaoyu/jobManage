package com.job.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseData {

    public void writeResponseData(HttpServletResponse resp, int code, String message, String data) throws IOException {
        String ResponseData = "{" +
                              "code=" + code +
                              ", message='" + message + '\'' +
                              ", data='" + data + '\'' +
                              '}';
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.addHeader("Access-Control-Max-Age", "1728000");
        PrintWriter writer = resp.getWriter();
        writer.print(ResponseData);
        writer.flush();
        writer.close();
    }

    public void writeResponseData(HttpServletResponse resp, int code, String message, String data, Boolean isList) throws IOException {
        if (isList){
            String ResponseData = "{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    ", data=" + data +
                    '}';
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json; charset=utf-8");
            resp.addHeader("Access-Control-Allow-Origin", "*");
            resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
            resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
            resp.addHeader("Access-Control-Max-Age", "1728000");
            PrintWriter writer = resp.getWriter();
            writer.print(ResponseData);
            writer.flush();
            writer.close();
        }
    }

    public void writeResponseData(HttpServletResponse resp,String data, Boolean isList) throws IOException {
        if (isList){
            String ResponseData = "{" +
                    "code=" + "200" +
                    ", message='" + "success" + '\'' +
                    ", data=" + data +
                    '}';
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json; charset=utf-8");
            resp.addHeader("Access-Control-Allow-Origin", "*");
            resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
            resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
            resp.addHeader("Access-Control-Max-Age", "1728000");
            PrintWriter writer = resp.getWriter();
            writer.print(ResponseData);
            writer.flush();
            writer.close();
        }
    }

    public void writeResponseData(HttpServletResponse resp, String data) throws IOException {
        String ResponseData = "{" +
                              "code=" + "200" +
                              ", message='" + "success" + '\'' +
                              ", data='" + data + '\'' +
                              '}';
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.addHeader("Access-Control-Max-Age", "1728000");
        PrintWriter writer = resp.getWriter();
        writer.print(ResponseData);
        writer.flush();
        writer.close();
    }

}
