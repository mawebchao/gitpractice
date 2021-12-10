package com.stepfive.pojo;

import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Data
@Component
public class B {
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Autowired
    @Property
    private  A a;
    @Override
    public String toString() {
        return "fuck you bitch";
    }
}
