package com.design.employeesManagement.mapper;

import com.design.employeesManagement.pojo.Wage;
import java.util.List;
import com.design.employeesManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Wage)表数据库访问层
 *
 * @author makejava
 * @since  15:08:46
 */
public interface WageMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Wage queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Wage> getPageListByCondition(@Param("page") Page<Wage> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Wage> page);


    /**
     * 新增数据
     *
     * @param wage 实例对象
     * @return 影响行数
     */
    int insert(Wage wage);




    /**
     * 修改数据
     *
     * @param wage 实例对象
     * @return 影响行数
     */
    int update(Wage wage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    Wage getUserAndMonth(Wage wage);


}

