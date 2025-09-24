package com.design.employeesManagement.mapper;

import com.design.employeesManagement.pojo.Train;
import java.util.List;
import com.design.employeesManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Train)表数据库访问层
 *
 * @author makejava
 * @since  16:33:28
 */
public interface TrainMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Train queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Train> getPageListByCondition(@Param("page") Page<Train> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Train> page);


    /**
     * 新增数据
     *
     * @param train 实例对象
     * @return 影响行数
     */
    int insert(Train train);




    /**
     * 修改数据
     *
     * @param train 实例对象
     * @return 影响行数
     */
    int update(Train train);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

