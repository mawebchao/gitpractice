package cn.tedu.test;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

//测试
//1.导入jar包  2.连接数据库
public class Test1 {
    @Test
    public void method1() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库的连接（用户名、密码、端口号、ip地址、指定库名）
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2107", "root", "root");
        //获取传输器
        Statement statement = connection.createStatement();
        String sql = "SELECT *" +
                " FROM dept;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("dname");
            String location = resultSet.getString(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(location);
        }
    }

    @Test
    public void method2() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库的连接（用户名、密码、端口号、ip地址、指定库名）
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2107", "root", "root");
        //获取传输器
        Statement statement = connection.createStatement();
        String sql = "SELECT *" +
                " FROM emp;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                Object o = resultSet.getObject(i);
                System.out.println(o);
//                System.out.println(o==null?"null":o.getClass());
            }
        }
        Object stu = new Student(1, "繁华如发货快呢");
        System.out.println(stu);
    }

    @Test
    public void method3() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库的连接（用户名、密码、端口号、ip地址、指定库名）
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2107", "root", "root");
        //获取传输器
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO emp VALUES(255,'vgxfg','副总',NULL,'2002-05-1',90000,NULL,1);";
        int resultSet = statement.executeUpdate(sql);
        System.out.println(resultSet);
        System.out.println(resultSet > 0 ? "插入数据成功" : "插入数据失败");
        statement.close();
        connection.close();
    }

    public static boolean hasUser(String username, String password) throws SQLException, ClassNotFoundException {
        boolean result=false;
        //1.注册驱动
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库的连接（用户名、密码、端口号、ip地址、指定库名）
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2107", "root", "root");
        //获取传输器
        Statement statement = connection.createStatement();
        String sql = "SELECT *" +
                " FROM user_test where username='" + username + "' and password='" + password + "';";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            result=true;
        }
        resultSet.close();
        connection.close();
        return result;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("请输入用户名密码：");
        String username = new Scanner(System.in).next();
        String password = new Scanner(System.in).next();
        boolean hasUser =hasUser(username,password);
        if(hasUser){
            System.out.println("存在该用户");
        }else{
            System.out.println("不存在该用户");
        }
    }
}

class Student {
    int sno;
    String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                '}';
    }
}