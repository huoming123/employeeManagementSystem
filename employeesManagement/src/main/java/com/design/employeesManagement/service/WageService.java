package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.Wage;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;

import java.util.Map;

/**
 * (Wage)表服务接口
 *
 * @author makejava
 * @since  15:08:46
 */
public interface WageService {

    /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    RestFulBean<Map> getList(Page<Wage> page) throws Exception;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Wage> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param wage 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Wage wage);

    /**
     * 修改数据
     *
     * @param wage 实例对象
     * @return 实例对象
     */
    RestFulBean<String> update(Wage wage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    /**
     * @return com.design.employeesManagement.pojo.res.RestFulBean<com.design.employeesManagement.pojo.Wage>
     * @author
     * @name 根据用户ID 月份 查询数据
     * @date 16:29
     * @Param [wage]
     */
    RestFulBean<Wage> getUserAndMonth(Page page);
}
