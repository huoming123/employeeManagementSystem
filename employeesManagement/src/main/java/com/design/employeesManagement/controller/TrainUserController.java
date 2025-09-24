package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.TrainUser;
import com.design.employeesManagement.service.TrainUserService;
import org.springframework.web.bind.annotation.*;

import com.design.employeesManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.dto.Page;

import java.util.List;
import java.util.Map;

/**
 * (TrainUser)表控制层
 *
 * @author makejava
 * @since  12:08:39
 */
@RestController
@RequestMapping("/trainUser")
public class TrainUserController {
    /**
     * 服务对象
     */
    @Autowired
    private TrainUserService trainUserService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<TrainUser> page) throws Exception {
        return this.trainUserService.getList(page);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<TrainUser> queryById(@RequestBody TrainUser trainUser) {
        return this.trainUserService.queryById(trainUser.getId());
    }

    /**
     * 新增数据
     *
     * @param trainUser 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody TrainUser trainUser) {
        return this.trainUserService.insert(trainUser);
    }

    /**
     * 编辑数据
     *
     * @param trainUser 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody TrainUser trainUser) {
        return this.trainUserService.update(trainUser);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody TrainUser trainUser) {
        return this.trainUserService.deleteById(trainUser.getId());
    }

    /**
     * @return com.design.employeesManagement.pojo.TrainUser
     * @author
     * @name 查询已预约的

     * @Param [trainUser]
     */
    @PostMapping("/get/all/list")
    public RestFulBean<List<TrainUser>> queryAllTrain(@RequestBody TrainUser trainUser) {
        return this.trainUserService.queryAllTrain(trainUser);
    }

}

