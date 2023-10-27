package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysql {
    public void createConnect(){
        String dburl  = "jdbc:mysql://127.0.0.1:3306/job?useSSL=false&serverTimezone=UTC";
        String username ="用户名";
        String password = "密码";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbconn = DriverManager.getConnection(dburl,username,password);
            System.out.println("数据库连接成功");
        }catch (ClassNotFoundException e1){
            System.out.println(e1+"驱动程序找不到");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
