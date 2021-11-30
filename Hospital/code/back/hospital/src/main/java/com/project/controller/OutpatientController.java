package com.project.controller;

import com.project.service.OutPatientDoctorService;
import com.project.service.RegisterSenderService;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin
@RequestMapping("/outPatient")
public class OutpatientController {
    @Autowired
    private OutPatientDoctorService outPatientDoctorService;

    @PostMapping("/addDoctor")
    public String addDoctor(String queue_name, String name) throws IOException, TimeoutException {
        outPatientDoctorService.registerDoctor(queue_name,name);
        return "医生上线了";
    }
}
