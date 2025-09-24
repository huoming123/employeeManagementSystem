package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.Attendance;
import com.design.employeesManagement.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import com.design.employeesManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.dto.Page;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * (Attendance)表控制层
 *
 * @author makejava
 * @since 17:01:01
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    /**
     * 服务对象
     */
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Attendance> page) throws Exception {
        return this.attendanceService.getList(page);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<Attendance> queryById(@RequestBody Attendance attendance) {
        return this.attendanceService.queryById(attendance.getId());
    }

    /**
     * 新增数据
     *
     * @param attendance 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Attendance attendance) {
        return this.attendanceService.insert(attendance);
    }

    /**
     * 编辑数据
     *
     * @param attendance 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Attendance attendance) {
        return this.attendanceService.update(attendance);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Attendance attendance) {
        return this.attendanceService.deleteById(attendance.getId());
    }

    /**
     * @return com.design.employeesManagement.pojo.res.RestFulBean<java.lang.String>
     * @author
     * @name 打卡
     * @date  17:08
     * @Param [attendance]
     */
    @PostMapping("/clockIn")
    public RestFulBean<String> clockIn(@RequestBody Attendance attendance) throws ParseException {
        return this.attendanceService.clockIn(attendance);
    }


}

