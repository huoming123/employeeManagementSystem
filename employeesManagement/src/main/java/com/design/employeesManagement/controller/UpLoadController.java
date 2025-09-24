package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.service.UpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/upLoad")
public class UpLoadController {
    @Autowired
    private UpLoadService upLoadService;
    //上传照片
    @PostMapping("/file")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception {
        return upLoadService.upload(coverFile);
    }
}
