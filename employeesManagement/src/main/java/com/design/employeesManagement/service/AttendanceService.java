package com.design.employeesManagement.service;

import com.design.employeesManagement.pojo.Attendance;
import com.design.employeesManagement.pojo.res.RestFulBean;
import com.design.employeesManagement.dto.Page;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
/**
 * (Attendance)表服务接口
 *
 * @author makejava
 * @since 17:01:02
 */
public interface AttendanceService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Attendance> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Attendance> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param attendance 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Attendance attendance);

    /**
     * 修改数据
     *
     * @param attendance 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Attendance attendance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<String> clockIn(Attendance attendance) throws ParseException;

}
