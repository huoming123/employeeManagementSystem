package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.Manager;
import com.design.employeesManagement.pojo.Users;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Manager)表服务接口
 *
 * @author makejava
 */
public interface ManagerService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Manager> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Manager> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<String> updatePassword(Users users);
}
