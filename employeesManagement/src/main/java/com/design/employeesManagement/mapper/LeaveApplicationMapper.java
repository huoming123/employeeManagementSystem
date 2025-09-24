package com.design.employeesManagement.mapper;

import com.design.employeesManagement.pojo.LeaveApplication;
import java.util.List;
import com.design.employeesManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (LeaveApplication)表数据库访问层
 *
 * @author makejava
 * @since  18:59:50
 */
public interface LeaveApplicationMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LeaveApplication queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<LeaveApplication> getPageListByCondition(@Param("page") Page<LeaveApplication> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<LeaveApplication> page);


    /**
     * 新增数据
     *
     * @param leaveApplication 实例对象
     * @return 影响行数
     */
    int insert(LeaveApplication leaveApplication);




    /**
     * 修改数据
     *
     * @param leaveApplication 实例对象
     * @return 影响行数
     */
    int update(LeaveApplication leaveApplication);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

