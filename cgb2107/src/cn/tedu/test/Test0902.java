package cn.tedu.test;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

public class Test0902 {
    public static void main(String[] args) {
        method1();
    }
    //用安全的传输器，执行删除id=1的user数据
    public static void method1(){
        Connection connection= null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2107", "root", "root");
            int userid = new Scanner(System.in).nextInt();
            String sql = "delete " +
                    " FROM user_test where userid=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,userid);
            int i = preparedStatement.executeUpdate();//执行拼接好的SQL,返回结果集

            if(i>0){
                System.out.println("删除成功~");
            }else{
                System.out.println("删除失败~");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
