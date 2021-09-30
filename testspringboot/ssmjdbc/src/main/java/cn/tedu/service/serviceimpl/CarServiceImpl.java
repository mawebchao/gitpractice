package cn.tedu.service.serviceimpl;

import cn.tedu.pojo.Car;
import cn.tedu.service.CarService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> get(){
        Car c1=new Car("红色",12,"dewsdg",2323.42);
        Car c2=new Car("绿色",213,"gdfgv",3423.090);
        return new ArrayList<Car>(Arrays.asList(c1,c2));
    }
}
