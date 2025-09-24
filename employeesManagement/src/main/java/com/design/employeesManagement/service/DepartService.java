package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.Depart;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Depart)表服务接口
 *
 * @author makejava
 * @since  10:47:45
 */
public interface DepartService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Depart> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Depart> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param depart 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Depart depart);

    /**
     * 修改数据
     *
     * @param depart 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Depart depart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);


    RestFulBean<List<Depart>> getDepartList();
}
