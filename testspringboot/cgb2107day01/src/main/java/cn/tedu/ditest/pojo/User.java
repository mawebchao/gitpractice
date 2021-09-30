package cn.tedu.ditest.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Autowired
    Dept dept;
    int id;
    String name;

    public User() {
    }

    public User(Dept dept, int id, String name) {
        this.dept = dept;
        this.id = id;
        this.name = name;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "dept=" + dept +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
