package cn.tedu.pojo;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private  String color;
    private Integer id;
    private String name;
    private Double price;
    public Car(){}

    public Car(String color, Integer id, String name, Double price) {

        this.color = color;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
