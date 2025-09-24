package com.design.employeesManagement.mapper;

import com.design.employeesManagement.pojo.Depart;
import java.util.List;
import com.design.employeesManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Depart)表数据库访问层
 *
 * @author makejava
 * @since  10:47:45
 */
public interface DepartMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Depart queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Depart> getPageListByCondition(@Param("page") Page<Depart> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Depart> page);


    /**
     * 新增数据
     *
     * @param depart 实例对象
     * @return 影响行数
     */
    int insert(Depart depart);




    /**
     * 修改数据
     *
     * @param depart 实例对象
     * @return 影响行数
     */
    int update(Depart depart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Depart> getDepartList();
}

