package com.design.employeesManagement.mapper;

import com.design.employeesManagement.pojo.Attendance;

import java.util.List;

import com.design.employeesManagement.dto.Page;
import org.apache.ibatis.annotations.Param;

/**
 * (Attendance)表数据库访问层
 *
 * @author makejava
 * @since 17:01:02
 */
public interface AttendanceMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Attendance queryById(Integer id);

    /**
     * 分页查询数据
     *
     * @param
     * @return 实例对象
     */
    List<Attendance> getPageListByCondition(@Param("page") Page<Attendance> page);

    /**
     * 分页查询数据 查询总条数
     *
     * @param
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Attendance> page);


    /**
     * 新增数据
     *
     * @param attendance 实例对象
     * @return 影响行数
     */
    int insert(Attendance attendance);


    /**
     * 修改数据
     *
     * @param attendance 实例对象
     * @return 影响行数
     */
    int update(Attendance attendance);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * @return int
     * @author
     * @name 打卡
     * @date 10:03
     * @Param [id]
     */
    int clockIn(Integer id);

    /**
     * @return
     * @author
     * @name 根据用户ID 时间查询
     * @date 10:02
     * @Param
     */
    Attendance queryByUserIdTime(Attendance attendance);
}

