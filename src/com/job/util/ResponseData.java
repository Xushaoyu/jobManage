package com.job.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ResponseData {

    public void writeResponseData(HttpServletResponse resp, int code, String message, String data) throws IOException {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("message", message);
        result.put("data", data);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(result);
        writer.flush();
        writer.close();
    }

    public void writeResponseData(HttpServletResponse resp, String message, String data) throws IOException {
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", message);
        result.put("data", data);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(result);
        writer.flush();
        writer.close();
    }

    public void writeResponseData(HttpServletResponse resp, String data) throws IOException {
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", data);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(result);
        writer.flush();
        writer.close();
    }

    public void writeResponseData(HttpServletResponse resp, JSONObject data) throws IOException {
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", data);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(result);
        writer.flush();
        writer.close();
    }

    public void writeResponseData(HttpServletResponse resp, JSONArray data) throws IOException {
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", data);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(result);
        writer.flush();
        writer.close();
    }

}
