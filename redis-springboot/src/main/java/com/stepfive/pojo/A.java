package com.stepfive.pojo;

import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@Data
@Component
public class A {
    @Autowired
    @Property
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "fuck you bitch";
    }
}
