package com.design.employeesManagement.service.impl;

import com.design.employeesManagement.pojo.TrainUser;
import com.design.employeesManagement.mapper.TrainUserMapper;
import com.design.employeesManagement.service.TrainUserService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

import com.design.employeesManagement.util.PageUtil;
import com.design.employeesManagement.dto.Page;

/**
 * (TrainUser)表服务实现类
 *
 * @author makejava
 * @since  12:08:39
 */
@Service("trainUserService")
public class TrainUserServiceImpl implements TrainUserService {
    @Autowired
    private TrainUserMapper trainUserMapper;

    /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<TrainUser> page) throws Exception {
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum = page.getPageNum();
        Integer startNum = (pageNum - 1) * page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<TrainUser> list = trainUserMapper.getPageListByCondition(page);

        //根据条件查询数据的条数
        Integer count = trainUserMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list", list);
        return RestFulBean.succ(map);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<TrainUser> queryById(Integer id) {
        TrainUser trainUser = this.trainUserMapper.queryById(id);
        return RestFulBean.succ(trainUser);
    }

    /**
     * 新增数据
     *
     * @param trainUser 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean insert(TrainUser trainUser) {
        TrainUser trainUser1 = this.trainUserMapper.queryUserIdAndTrainId(trainUser);
        if (trainUser1 == null) {
            this.trainUserMapper.insert(trainUser);//执行数据库的新增语句
            return RestFulBean.succ("添加成功");
        }
        return RestFulBean.error("请不要重复添加！！");
    }

    /**
     * 修改数据
     *
     * @param trainUser 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> update(TrainUser trainUser) {
        this.trainUserMapper.update(trainUser);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.trainUserMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
        return RestFulBean.succ("删除成功");
    }

    /**
     * @return com.design.employeesManagement.pojo.TrainUser
     * @author
     * @name 查询已预约的
     * @date 2023/2/24 13:55
     * @Param [trainUser]
     */
    @Override
    public RestFulBean< List<TrainUser>> queryAllTrain(TrainUser trainUser) {
        List<TrainUser> list = this.trainUserMapper.queryAllTrain(trainUser);
        return RestFulBean.succ(list);
    }
}
