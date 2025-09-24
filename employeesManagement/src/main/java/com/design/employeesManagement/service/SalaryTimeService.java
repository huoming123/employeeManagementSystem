package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.Attendance;
import com.design.employeesManagement.pojo.SalaryTime;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;

import java.util.List;
import java.util.Map;

/**
 * (SalaryTime)表服务接口
 *
 * @author makejava
 * @since  10:32:34
 */
public interface SalaryTimeService {


    /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    RestFulBean<List<SalaryTime>> getTimeList(Page<SalaryTime> page) throws Exception;


    /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    RestFulBean<Map> getList(Page<SalaryTime> page) throws Exception;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<SalaryTime> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param salaryTime 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(SalaryTime salaryTime);

    /**
     * 修改数据
     *
     * @param salaryTime 实例对象
     * @return 实例对象
     */
    RestFulBean<String> update(SalaryTime salaryTime);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<SalaryTime>> clockRecord(Page page);
}
