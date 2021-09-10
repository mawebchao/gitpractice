package cn.tedu.test;

import java.sql.*;
import java.util.Scanner;

//用高级的传输器来执行sql，因为普通的传输器会发生sql攻击的问题
public class Test0901 {
    //用安全的传输器,解决sql攻击
    public static void method1() throws SQLException {
        Connection connection= null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2107", "root", "root");
            String username = new Scanner(System.in).next();
            String password = new Scanner(System.in).next();
            String sql = "SELECT *" +
                    " FROM user_test where username=? and password=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();//执行拼接好的SQL,返回结果集

            if(rs.next()){
                System.out.println("登录成功~");
            }else{
                System.out.println("登录失败~");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("请输入用户名密码：");
        method1();
    }
}
