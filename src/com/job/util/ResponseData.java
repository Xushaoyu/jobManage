package com.job.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ResponseData {

    public void writeResponseData(HttpServletResponse resp, int code, String message, String data) throws IOException {
        String ResponseData = "{" +
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

    public void writeResponseData(HttpServletResponse resp, int code, String message, String data, Boolean isList) throws IOException {
        if (isList){
            String ResponseData = "{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    ", data=" + data +
                    '}';
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json; charset=utf-8");
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
        PrintWriter writer = resp.getWriter();
        writer.print(ResponseData);
        writer.flush();
        writer.close();
    }

    public void writeResponseData(HttpServletResponse resp, HashMap<String, String> data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // 创建一个对象节点
        ObjectNode result = objectMapper.createObjectNode();
        result.put("code", "200");
        result.put("message", "success");
        result.put("data", String.valueOf(data));
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(objectMapper.writeValueAsString(result));
        writer.flush();
        writer.close();
    }

}
