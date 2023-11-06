package common;

import java.sql.*;

public class ConnectMysql {
    private Connection conn = null;
    public void createConnect(){
        String dburl  = "jdbc:mysql://127.0.0.1:3306/homework_management?useSSL=false&serverTimezone=UTC";
        String username ="root";
        String password = "123456";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dburl,username,password);
            System.out.println("数据库连接成功");
        }catch (ClassNotFoundException e1){
            System.out.println(e1+"驱动程序找不到");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public ResultSet executeQuery(String sql){
        ResultSet resultSet = null;
        if (conn == null){
            createConnect();
        }
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            // 执行查询语句
            resultSet = statement.executeQuery();
            // 处理查询结果
            while (resultSet.next()) {
                // 取出元素
                String number = resultSet.getString(2);
                String name = resultSet.getString(4);
                String stuClass = resultSet.getString(5);
                System.out.println(number + "-" + name + "-" + stuClass);
            }
            // 关闭结果集
            resultSet.close();
            // 关闭预编译的语句
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            closeConnection();
        }
        return resultSet;
    }


    public int executeUpdate(String sql){
        int resultSet = 0;
        if (conn == null){
            createConnect();
        }
        try {
            Statement statement = conn.createStatement();
            // 执行更新语句
            resultSet = statement.executeUpdate(sql);
            // 关闭预编译的语句
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            closeConnection();
        }
        return resultSet;
    }
}
