package com.design.employeesManagement.service.impl;

import com.design.employeesManagement.pojo.SalaryTime;
import com.design.employeesManagement.mapper.SalaryTimeMapper;
import com.design.employeesManagement.service.SalaryTimeService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

import com.design.employeesManagement.util.PageUtil;
import com.design.employeesManagement.dto.Page;

/**
 * (SalaryTime)表服务实现类
 *
 * @author makejava
 * @since  10:32:34
 */
@Service("salaryTimeService")
public class SalaryTimeServiceImpl implements SalaryTimeService {
    @Autowired
    private SalaryTimeMapper salaryTimeMapper;

    /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<List<SalaryTime>> getTimeList(Page<SalaryTime> page) {
        System.out.println("55555");
        List<SalaryTime> timeListByCondition = salaryTimeMapper.getTimeListByCondition(page);
        return RestFulBean.succ(timeListByCondition);
    }

    /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<SalaryTime> page) throws Exception {
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum = page.getPageNum();
        Integer startNum = (pageNum - 1) * page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<SalaryTime> list = salaryTimeMapper.getPageListByCondition(page);
        if (list.size() > 0) {  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for (SalaryTime salaryTime : list) {

            }
        }
        //根据条件查询数据的条数
        Integer count = salaryTimeMapper.getPageListCount(page);
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
    public RestFulBean<SalaryTime> queryById(Integer id) {
        SalaryTime salaryTime = this.salaryTimeMapper.queryById(id);
        return RestFulBean.succ(salaryTime);
    }

    /**
     * 新增数据
     *
     * @param salaryTime 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(SalaryTime salaryTime) {
        this.salaryTimeMapper.insert(salaryTime);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param salaryTime 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> update(SalaryTime salaryTime) {
        this.salaryTimeMapper.update(salaryTime);//执行数据库的修改语句 根据id 修改
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
        this.salaryTimeMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
        return RestFulBean.succ("删除成功");
    }

    /**
     * @return com.design.employeesManagement.pojo.res.RestFulBean<java.util.List < com.design.employeesManagement.pojo.Attendance>>
     * @author
     * @name 查询打卡记录
     * @date 11:23
     * @Param [attendance]
     */
    @Override
    public RestFulBean<List<SalaryTime>> clockRecord(Page page) {
        List<SalaryTime> salaryTimes = this.salaryTimeMapper.clockRecord(page);
        return RestFulBean.succ(salaryTimes);
    }
}
