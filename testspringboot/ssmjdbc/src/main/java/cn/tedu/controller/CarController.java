package cn.tedu.controller;

import cn.tedu.pojo.Car;
import cn.tedu.service.serviceimpl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    CarServiceImpl carServiceImpl;
    @GetMapping("get")
    public Object get(){
        List<Car> carList= carServiceImpl.get();
        System.out.println(carList.toArray());
        return carList;
    }
}
