package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.Wage;
import com.design.employeesManagement.service.WageService;
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
 * (Wage)表控制层
 *
 * @author makejava
 * @since  15:08:46
 */
@RestController
@RequestMapping("/wage")
public class WageController {
    /**
     * 服务对象
     */
    @Autowired
    private WageService wageService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Wage> page) throws Exception {
        return this.wageService.getList(page);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<Wage> queryById(@RequestBody Wage wage) {
        return this.wageService.queryById(wage.getId());
    }

    /**
     * 新增数据
     *
     * @param wage 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Wage wage) {
        return this.wageService.insert(wage);
    }

    /**
     * 编辑数据
     *
     * @param wage 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Wage wage) {
        return this.wageService.update(wage);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Wage wage) {
        return this.wageService.deleteById(wage.getId());
    }

    /**
     * @return com.design.employeesManagement.pojo.res.RestFulBean<com.design.employeesManagement.pojo.Wage>
     * @author
     * @name 根据用户ID 月份 查询数据
     * @date 16:29
     * @Param [wage]
     */

    @PostMapping("/get/by/userAndMonth")
    public RestFulBean<Wage> getUserAndMonth(@RequestBody Page page) {
        return this.wageService.getUserAndMonth(page);
    }

}

