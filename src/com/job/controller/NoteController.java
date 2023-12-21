package com.job.controller;

import com.alibaba.fastjson.JSONArray;
import com.job.dao.NoteDao;
import com.job.model.Note;
import com.job.util.Common;
import com.job.util.ResponseData;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/note/*")
public class NoteController  extends BaseController{
    /*
    生成接口唯一标识符
 */
    private static final long serialVersionUID = 1L;

    /*
        日志输出对象
     */
//    private static final Logger logger = Logger.getLogger(StudentController.class.getName());

    /*
        设置每个接口对应方法
     */
    protected HashMap<String, String> urlMethodMap = new HashMap<>();

    /*
        引入接口使用的ORM操作对象
     */
    private final NoteDao noteDao;


    public NoteController() {
        super();
        this.noteDao = new NoteDao();
        this.urlMethodMap.put("queryNote", "GET");
        super.urlMethodMap = urlMethodMap;
    }

    //学生查看笔记
    public void queryNote(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        //拿到id
        String[] userInfo = Common.getUserInfoFromCookies(req);
        assert userInfo != null;
        int studentId = Integer.parseInt(userInfo[1]);
        //调用DAO层拿结果
        JSONArray notes = noteDao.queryNote(studentId);
        //输出到浏览器
        ResponseData responseData = new ResponseData();
        responseData.writeResponseData(resp, notes);
    }
}
