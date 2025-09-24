package com.design.employeesManagement.mapper;

import com.design.employeesManagement.pojo.Users;
import java.util.List;
import com.design.employeesManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since  22:21:50
 */
public interface UsersMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Users> getPageListByCondition(@Param("page") Page<Users> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Users> page);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);




    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Users getByUserNoAndRole(String userNo, String role);

    List<Users> getManagerList();

    Users getByUserNo(String userNo);
}

