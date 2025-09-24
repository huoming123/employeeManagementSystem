package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.Train;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Train)表服务接口
 *
 * @author makejava
 * @since  16:33:27
 */
public interface TrainService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Train> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Train> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param train 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Train train);

    /**
     * 修改数据
     *
     * @param train 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Train train);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
