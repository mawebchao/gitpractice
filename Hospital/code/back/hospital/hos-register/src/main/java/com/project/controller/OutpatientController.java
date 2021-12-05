package com.project.controller;

import com.project.service.OutPatientDoctorService;
import com.project.vo.OutPatientDoctorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        outPatientDoctorService.registerDoctor(queue_name,name);
        return outPatientDoctorService.nextPatient(name);
    }
    //门诊医生下线
    @PostMapping("/logoutDoctor")
    public String logoutDoctor(String queue_name, String name) throws IOException, TimeoutException {
        outPatientDoctorService.logoutDoctor(queue_name,name);
        return "医生下线了";
    }
//    @PostMapping("/addIdleDoctor")
    @PostMapping("/doctor/nextPatient")
    public OutPatientDoctorVO nextPatient(String queue_name,String username) throws IOException {
        outPatientDoctorService.ackNowPatient(queue_name);
        return outPatientDoctorService.nextPatient(username);
    }
    @GetMapping("/recursive/nextPatient/{name}")
    public OutPatientDoctorVO recursiveNextPatient(@PathVariable("name") String name){
        return outPatientDoctorService.nextPatient(name);
    }
}
