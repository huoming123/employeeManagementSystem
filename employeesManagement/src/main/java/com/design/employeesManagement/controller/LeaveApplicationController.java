package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.LeaveApplication;
import com.design.employeesManagement.service.LeaveApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.employeesManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.employeesManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (LeaveApplication)表控制层
 *
 * @author makejava
 * @since  18:59:50
 */
@RestController
@RequestMapping("/leaveApplication")
public class LeaveApplicationController {
    /**
     * 服务对象
     */
    @Autowired
    private LeaveApplicationService leaveApplicationService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<LeaveApplication>page) throws Exception{
        return this.leaveApplicationService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<LeaveApplication> queryById(@RequestBody LeaveApplication leaveApplication) {
        return this.leaveApplicationService.queryById(leaveApplication.getId());
    }

    /**
     * 新增数据
     *
     * @param leaveApplication 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody LeaveApplication leaveApplication) {
        return this.leaveApplicationService.insert(leaveApplication);
    }

    /**
     * 编辑数据
     *
     * @param leaveApplication 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody LeaveApplication leaveApplication) {
        return this.leaveApplicationService.update(leaveApplication);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody LeaveApplication leaveApplication) {
        return this.leaveApplicationService.deleteById(leaveApplication.getId());
    }

}

