package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.Depart;
import com.design.employeesManagement.service.DepartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.employeesManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.employeesManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Depart)表控制层
 *
 * @author makejava
 * @since  10:47:45
 */
@RestController
@RequestMapping("/depart")
public class DepartController {
    /**
     * 服务对象
     */
    @Autowired
    private DepartService departService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Depart>page) throws Exception{
        return this.departService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Depart> queryById(@RequestBody Depart depart) {
        return this.departService.queryById(depart.getId());
    }

    /**
     * 新增数据
     *
     * @param depart 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Depart depart) {
        return this.departService.insert(depart);
    }

    /**
     * 编辑数据
     *
     * @param depart 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Depart depart) {
        return this.departService.update(depart);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Depart depart) {
        return this.departService.deleteById(depart.getId());
    }
    /**
     * 部门 下来数据
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/depart/list")
    public RestFulBean<List<Depart>> getDepartList() throws Exception{
        return this.departService.getDepartList();
    }
}

