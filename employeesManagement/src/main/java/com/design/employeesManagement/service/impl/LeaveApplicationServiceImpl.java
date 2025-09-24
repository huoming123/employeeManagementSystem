package com.design.employeesManagement.service.impl;

import com.design.employeesManagement.pojo.LeaveApplication;
import com.design.employeesManagement.mapper.LeaveApplicationMapper;
import com.design.employeesManagement.service.LeaveApplicationService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.employeesManagement.util.PageUtil;
import com.design.employeesManagement.dto.Page;
/**
 * (LeaveApplication)表服务实现类
 *
 * @author makejava
 * @since  18:59:50
 */
@Service("leaveApplicationService")
public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    @Autowired
    private LeaveApplicationMapper leaveApplicationMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<LeaveApplication> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<LeaveApplication> list= leaveApplicationMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = leaveApplicationMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<LeaveApplication> queryById(Integer id) {
       LeaveApplication leaveApplication=this.leaveApplicationMapper.queryById(id);
         return RestFulBean.succ(leaveApplication);
    }

    /**
     * 新增数据
     *
     * @param leaveApplication 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(LeaveApplication leaveApplication) {
        if(leaveApplication.getReason()==null){
            return RestFulBean.error("请假原因不能为空");
        }
        if(leaveApplication.getStartDate()==null){
            return RestFulBean.error("请假日期不能为空");
        }
        if(leaveApplication.getEndDate()==null){
            return RestFulBean.error("请假日期不能为空");
        }
        this.leaveApplicationMapper.insert(leaveApplication);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param leaveApplication 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(LeaveApplication leaveApplication) {
        this.leaveApplicationMapper.update(leaveApplication);//执行数据库的修改语句 根据id 修改
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
        this.leaveApplicationMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
