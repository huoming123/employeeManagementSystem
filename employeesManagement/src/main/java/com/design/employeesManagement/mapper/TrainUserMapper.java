package com.design.employeesManagement.mapper;

import com.design.employeesManagement.pojo.TrainUser;

import java.util.List;

import com.design.employeesManagement.dto.Page;
import org.apache.ibatis.annotations.Param;

/**
 * (TrainUser)表数据库访问层
 *
 * @author makejava
 * @since  12:08:39
 */
public interface TrainUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TrainUser queryById(Integer id);

    /**
     * 分页查询数据
     *
     * @param
     * @return 实例对象
     */
    List<TrainUser> getPageListByCondition(@Param("page") Page<TrainUser> page);

    /**
     * 分页查询数据 查询总条数
     *
     * @param
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<TrainUser> page);


    /**
     * 新增数据
     *
     * @param trainUser 实例对象
     * @return 影响行数
     */
    int insert(TrainUser trainUser);


    /**
     * 修改数据
     *
     * @param trainUser 实例对象
     * @return 影响行数
     */
    int update(TrainUser trainUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * @return com.design.employeesManagement.pojo.TrainUser
     * @author
     * @name 查询是否有预约
     * @date 2023/2/24 13:56
     * @Param [trainUser]
     */
    TrainUser queryUserIdAndTrainId(TrainUser trainUser);

    /**
     * @return com.design.employeesManagement.pojo.TrainUser
     * @author
     * @name 查询已预约的
     * @date 2023/2/24 13:55
     * @Param [trainUser]
     */



    Integer getPageListCountAll(@Param("page") Page<TrainUser> page);


    List<TrainUser> queryAllTrain(TrainUser trainUser);
}

