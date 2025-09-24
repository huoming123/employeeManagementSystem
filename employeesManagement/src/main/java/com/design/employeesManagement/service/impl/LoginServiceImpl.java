package com.design.employeesManagement.service.impl;

import com.design.employeesManagement.mapper.ManagerMapper;

import com.design.employeesManagement.mapper.UsersMapper;
import com.design.employeesManagement.pojo.Manager;
import com.design.employeesManagement.pojo.Users;

import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class  LoginServiceImpl implements LoginService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public RestFulBean<Users> login(Users users) throws Exception {
        if(users.getUserNo()==null)
        {
            return RestFulBean.error("编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        if(users.getRole()==null)
        {
            return RestFulBean.error("角色不能为空");
        }
        Users user =new Users(); //new一个用户对象
        user.setRole(users.getRole());
        if(users.getRole().equals("普通员工")) //判断角色是否等于普通员工
        {

            Users  usersed =usersMapper.getByUserNo(users.getUserNo());//根据编号获取员工数据
            if(usersed==null){
                return RestFulBean.error("该员工账号不存在");
            }

            //赋值
            user.setId(usersed.getId());
            user.setUserName(usersed.getUserName());
            user.setUserNo(usersed.getUserNo());
            user.setRole(users.getRole());
            user.setPassword(usersed.getPassword());
        }
        if(users.getRole().equals("管理员")) //判断角色是否等于管理员
        {
            Manager manager =managerMapper.getByUserNo(users.getUserNo());//根据编号获取管理员数据
            if(manager==null){
                return RestFulBean.error("该管理员用户不存在");
            }

            //赋值
            user.setId(manager.getId());
            user.setRole(users.getRole());
            user.setUserName(manager.getUserName());
            user.setUserNo(manager.getUserNo());
            user.setPassword(manager.getPassword());
        }
            //判断密码跟数据库是否一样
            if(users.getPassword().equals(user.getPassword())){
                return RestFulBean.succ(user); //如果密码一样将用户对象放回到前端
            }
            else{
                return RestFulBean.error("密码错误");
            }
    }
}
