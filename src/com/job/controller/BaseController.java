package com.job.controller;


import com.job.auth.Authority;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

public class BaseController extends HttpServlet {

    private final Authority authority;
    public final String nginxUrl = "http://localhost:8080/jobManage/";

    /*
        子类重写父类方法，参考https://blog.51cto.com/u_5650011/5386958
     */
    protected HashMap<String, String> urlMethodMap;

    protected BaseController(){
        this.authority = new Authority();
    }
    /*
    方法映射
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String method = req.getMethod();
        // 获取请求的URI地址信息
        String url = req.getRequestURI();
        // 截取其中的方法名
        String methodName = url.substring(url.lastIndexOf("/") + 1);
        System.out.printf("current url: %s, method: %s\n", methodName, urlMethodMap.get(methodName));
        if (!Objects.equals(urlMethodMap.get(methodName), method)) {
            resp.getWriter().println("404");
            return;
        }
        String[] classNameUrl = getClass().getName().split("\\.");
        if (!methodName.equals("login") && !methodName.equals("register") && !authority.verify(req, classNameUrl[classNameUrl.length - 1], methodName)) {
            resp.getWriter().println("403");
            return;
        }
        Method func;
        try {
            // 使用反射机制获取在本类中声明了的方法
            func = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            func.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            resp.getWriter().println("404");
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
