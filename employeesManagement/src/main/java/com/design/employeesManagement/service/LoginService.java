package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.Users;
import com.design.employeesManagement.pojo.res.RestFulBean;

public interface LoginService {

    RestFulBean<Users> login(Users users) throws Exception;
}
