package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.LeaveApplication;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (LeaveApplication)表服务接口
 *
 * @author makejava
 * @since  18:59:50
 */
public interface LeaveApplicationService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<LeaveApplication> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<LeaveApplication> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param leaveApplication 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(LeaveApplication leaveApplication);

    /**
     * 修改数据
     *
     * @param leaveApplication 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(LeaveApplication leaveApplication);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
