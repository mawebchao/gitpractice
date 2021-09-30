package cn.tedu.hello.controller;

import cn.tedu.hello.pojo.Car;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@RestController
@RequestMapping("car")
public class CarController {
    private static Gson gson = new Gson();

    @RequestMapping("hi/{id}")
    public String getCarById(@PathVariable int id) {
        System.out.println("id"+id);
        return gson.toJson(new Car());
    }
    @RequestMapping("search/{brand}/{sno}")
    public String getCar(@PathVariable String brand,@PathVariable String sno) {
        System.out.println("brand"+brand+",sno"+sno);
        return gson.toJson(new Car());
    }
    @RequestMapping("search")
    public String getCar(@RequestParam(required = true) Integer id) {
        System.out.println("id"+id);
        return gson.toJson(new Car("gvtfd",12,null));
    }
    @RequestMapping("searchByCar")
    public String getCarByObj(Car car) {
        System.out.println(car);
        System.out.println("id"+car.brand);
        Car returncar=new Car("gvtfd",12,null);
        System.out.println(returncar);
        return gson.toJson(returncar);
    }

    @RequestMapping("save")
    public Object createNewCar(Car car) {
        try{
            pushToDB(car);
        }catch(Exception ex){
            return "创建失败";
        }

        return "创建成功";
    }
    //用安全的传输器，执行删除id=1的user数据
    public static void pushToDB(Car car) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= null;
        PreparedStatement preparedStatement=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2107", "root", "root");
            String sql = "insert into " +
                    "  car values(?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,car.getId());
            preparedStatement.setString(2,car.getName());
            preparedStatement.setString(3,car.getBrand());
            preparedStatement.setString(4,car.getColor());
            preparedStatement.setFloat(5,car.getPrice().floatValue());
            preparedStatement.setString(6,car.getType());
            boolean b = preparedStatement.execute();//执行拼接好的SQL,返回结果集
            System.out.println("写入成功"+b);
            if(b){
                System.out.println("写入成功~");
            }else{
                System.out.println("写入失败~");
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
