package com.design.employeesManagement.service.impl;

import com.design.employeesManagement.mapper.SalaryTimeMapper;
import com.design.employeesManagement.pojo.SalaryTime;
import com.design.employeesManagement.pojo.Wage;
import com.design.employeesManagement.mapper.WageMapper;
import com.design.employeesManagement.service.WageService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.design.employeesManagement.pojo.res.RestFulBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.design.employeesManagement.util.PageUtil;
import com.design.employeesManagement.dto.Page;

/**
 * (Wage)表服务实现类
 *
 * @author makejava
 * @since  15:08:46
 */
@Service("wageService")
public class WageServiceImpl implements WageService {
    @Autowired
    private WageMapper wageMapper;
    @Autowired
    private SalaryTimeMapper salaryTimeMapper;


    /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Wage> page) throws Exception {
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum = page.getPageNum();
        Integer startNum = (pageNum - 1) * page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Wage> list = wageMapper.getPageListByCondition(page);
        if (list.size() > 0) {  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for (Wage wage : list) {

            }
        }
        //根据条件查询数据的条数
        Integer count = wageMapper.getPageListCount(page);
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
    public RestFulBean<Wage> queryById(Integer id) {
        Wage wage = this.wageMapper.queryById(id);
        return RestFulBean.succ(wage);
    }

    /**
     * 新增数据
     *
     * @param wage 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Wage wage) {
        wage.setBasePay(0);
        wage.setBonus(0);
        wage.setWeal(0);
        wage.setWageTotal(0);
        this.wageMapper.insert(wage);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param wage 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> update(Wage wage) {
        if(wage.getBasePay()==null){
            return RestFulBean.error("基本工资不能为空");
        }
        if(wage.getWeal()==null){
            return RestFulBean.error("福利不能为空");
        }
        if(wage.getBonus()==null){
            return RestFulBean.error("奖金不能为空");
        }
        this.wageMapper.update(wage);//执行数据库的修改语句 根据id 修改
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
        this.wageMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
        return RestFulBean.succ("删除成功");
    }


    /**
     * @return com.design.employeesManagement.pojo.res.RestFulBean<com.design.employeesManagement.pojo.Wage>
     * @author
     * @name 根据用户ID 月份 查询数据
     * @date 16:29
     * @Param [wage]
     */
    @Override
    public RestFulBean<Wage> getUserAndMonth(Page page) {
        // 根据id 当前时间获取 用户当月打卡记录
        List<SalaryTime> salaryTimes = this.salaryTimeMapper.clockRecord(page);
        System.out.println(salaryTimes);
        // 声明sum为工时
        int sum = 0;
        int attendanceHour = 0;
        // 循环数据 获取每天打卡时间
        for (SalaryTime e : salaryTimes) {
            System.out.println(e);
            if (e.getAttendances() != null) {
                // 获取上班打卡时间
                long createdAt = e.getAttendances().getCreatedAt().getTime();
                // 获取上班打卡时间
                long signOutAt = e.getAttendances().getSignOutAt().getTime();
                // 上班时间减去下班时间
                long l = signOutAt - createdAt;
                // 统计数据 到sum 为毫秒
                sum += l;
            }
        }
        if (sum != 0) {
            int i = 60 * 60;
            attendanceHour = Integer.parseInt(String.valueOf(sum)) / i; // 转为小时 现在数据还需要除以1000为小时
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 把时间戳转成 2025-01-02 格式 没有时分秒
        String format = simpleDateFormat.format(page.getSameTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            // 2025-01-02转成把时间戳  格式 没有时分秒
            parse = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Wage wage = new Wage();
        wage.setMonth(parse);
        wage.setAttendanceHour(attendanceHour);
        wage.setUserId(page.getUserId());
        // 查询有数据没有
        Wage userAndMonth = this.wageMapper.getUserAndMonth(wage);
        System.out.println(userAndMonth);
        if (userAndMonth == null) {
            // 没有就新增
            this.insert(wage);
        } else {
            // 有 修改书聚
            wage.setId(userAndMonth.getId());
            this.update(wage);
        }

        int timeSum = 176;// 每月工时 一个月上班22天
        Wage wageData = this.wageMapper.getUserAndMonth(wage); // 查询数据
        int i = (wageData.getBasePay() / timeSum) * (wageData.getAttendanceHour()/ 1000) + wageData.getBonus() + wageData.getWeal(); // 计算工资
        int i1 = wageData.getAttendanceHour() / 1000;
        wageData.setAttendanceHour(i1); // 出勤小时
        wageData.setWageTotal(i); // 总工资
        return RestFulBean.succ(wageData);
    }
}
