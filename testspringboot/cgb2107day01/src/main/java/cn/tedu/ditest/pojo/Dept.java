package cn.tedu.ditest.pojo;

import org.springframework.stereotype.Component;

@Component
public class Dept {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
