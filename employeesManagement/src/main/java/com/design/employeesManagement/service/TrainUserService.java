package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.TrainUser;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * (TrainUser)表服务接口
 *
 * @author makejava
 * @since  12:08:39
 */
public interface TrainUserService {

    /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    RestFulBean<Map> getList(Page<TrainUser> page) throws Exception;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<TrainUser> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param trainUser 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(TrainUser trainUser);

    /**
     * 修改数据
     *
     * @param trainUser 实例对象
     * @return 实例对象
     */
    RestFulBean<String> update(TrainUser trainUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);


    /**
     * @return com.design.employeesManagement.pojo.TrainUser
     * @author
     * @name 查询已预约的
     * @date 2023/2/24 13:55
     * @Param [trainUser]
     */
    RestFulBean<List<TrainUser>> queryAllTrain(TrainUser trainUser);
}
