package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.SalaryTime;
import com.design.employeesManagement.service.SalaryTimeService;
import org.springframework.web.bind.annotation.*;

import com.design.employeesManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.dto.Page;

import java.util.List;
import java.util.Map;

/**
 * (SalaryTime)表控制层
 *
 * @author makejava
 * @since  10:32:32
 */
@RestController
@RequestMapping("/salaryTime")
public class SalaryTimeController {
    /**
     * 服务对象
     */
    @Autowired
    private SalaryTimeService salaryTimeService;


    /**
     * 根据时间段查询数据
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/time/list")
    public RestFulBean<List<SalaryTime>> getTimeList(@RequestBody Page<SalaryTime> page) throws Exception {
        return this.salaryTimeService.getTimeList(page);
    }


    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<SalaryTime> page) throws Exception {
        return this.salaryTimeService.getList(page);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<SalaryTime> queryById(@RequestBody SalaryTime salaryTime) {
        return this.salaryTimeService.queryById(salaryTime.getId());
    }

    /**
     * 新增数据
     *
     * @param salaryTime 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody SalaryTime salaryTime) {
        return this.salaryTimeService.insert(salaryTime);
    }

    /**
     * 编辑数据
     *
     * @param salaryTime 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody SalaryTime salaryTime) {
        return this.salaryTimeService.update(salaryTime);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody SalaryTime salaryTime) {
        return this.salaryTimeService.deleteById(salaryTime.getId());
    }

    /**
     * @return com.design.employeesManagement.pojo.res.RestFulBean<java.util.List < com.design.employeesManagement.pojo.Attendance>>
     * @author
     * @name 查询打卡记录
     * @date 11:27
     * @Param [attendance]
     */
    @PostMapping("/get/clock/record")
    public RestFulBean<List<SalaryTime>> clockRecord(@RequestBody Page page) {
        return this.salaryTimeService.clockRecord(page);
    }

}

