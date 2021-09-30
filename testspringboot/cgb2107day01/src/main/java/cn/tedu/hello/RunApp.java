package cn.tedu.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class RunApp {
    public static void main(String[] args) {
        SpringApplication.run(RunApp.class);
    }
}
