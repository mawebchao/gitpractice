package com.project.controller;

import com.project.service.OutPatientDoctorService;
import com.project.service.RegisterSenderService;
import com.project.vo.OutPatientDoctorVO;
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

    //门诊医生上线
    @PostMapping("/addDoctor")
    public OutPatientDoctorVO addDoctor(String queue_name, String name) throws IOException, TimeoutException {
        return outPatientDoctorService.registerDoctor(queue_name,name);
    }
    //门诊医生下线
    @PostMapping("/logoutDoctor")
    public String logoutDoctor(String queue_name, String name) throws IOException, TimeoutException {
        outPatientDoctorService.logoutDoctor(queue_name,name);
        return "医生下线了";
    }
//    @PostMapping("/addIdleDoctor")
    @PostMapping("/doctor/nextPatient")
    public String nextPatient(String queue_name,String name) throws IOException {
        outPatientDoctorService.nextPatient(queue_name,name);
        return "增加了一个"+queue_name+"科室的空闲的医生"+name;
    }
}
