package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UpLoadService {
    RestFulBean<Map> upload(MultipartFile coverFile);
}
