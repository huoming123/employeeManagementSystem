package com.design.employeesManagement.controller;

import com.design.employeesManagement.pojo.Train;
import com.design.employeesManagement.service.TrainService;
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
 * (Train)表控制层
 *
 * @author makejava
 * @since  16:33:26
 */
@RestController
@RequestMapping("/train")
public class TrainController {
    /**
     * 服务对象
     */
    @Autowired
    private TrainService trainService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Train>page) throws Exception{
        return this.trainService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Train> queryById(@RequestBody Train train) {
        return this.trainService.queryById(train.getId());
    }

    /**
     * 新增数据
     *
     * @param train 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Train train) {
        return this.trainService.insert(train);
    }

    /**
     * 编辑数据
     *
     * @param train 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Train train) {
        return this.trainService.update(train);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Train train) {
        return this.trainService.deleteById(train.getId());
    }

}

