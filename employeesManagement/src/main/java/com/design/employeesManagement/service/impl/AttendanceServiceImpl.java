package com.design.employeesManagement.service.impl;

import com.design.employeesManagement.mapper.SalaryTimeMapper;
import com.design.employeesManagement.mapper.UsersMapper;
import com.design.employeesManagement.pojo.Attendance;
import com.design.employeesManagement.mapper.AttendanceMapper;
import com.design.employeesManagement.pojo.SalaryTime;
import com.design.employeesManagement.pojo.Users;
import com.design.employeesManagement.service.AttendanceService;
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
 * (Attendance)表服务实现类
 *
 * @author makejava
 * @since 17:01:02
 */
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private SalaryTimeMapper salaryTimeMapper;
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Attendance> page) throws Exception {
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum = page.getPageNum();
        Integer startNum = (pageNum - 1) * page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Attendance> list = attendanceMapper.getPageListByCondition(page);
        if (list.size() > 0) {  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for (Attendance attendance : list) {

            }
        }
        //根据条件查询数据的条数
        Integer count = attendanceMapper.getPageListCount(page);
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
    public RestFulBean<Attendance> queryById(Integer id) {
        Attendance attendance = this.attendanceMapper.queryById(id);
        return RestFulBean.succ(attendance);
    }

    /**
     * 新增数据
     *
     * @param attendance 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Attendance attendance) {
        this.attendanceMapper.insert(attendance);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param attendance 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> update(Attendance attendance) {
        this.attendanceMapper.update(attendance);//执行数据库的修改语句 根据id 修改
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
        this.attendanceMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
        return RestFulBean.succ("删除成功");
    }

    /**
     * 打卡
     *
     * @param attendance 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> clockIn(Attendance attendance) throws ParseException {
        // 获取时间戳
//        long date = new Date().getTime();
        Date date = new Date();
        // 转成yy-MM-dd格式 字符串
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        String format = ymd.format(date);
        Date parse = null;
        try {
            // 转时间 Date格式
            parse = ymd.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
        // 数据库查询时间
        SalaryTime salaryTime = this.salaryTimeMapper.queryByTime(parse);
        // 获取当前时间
        attendance.setDate(salaryTime.getId());
        // 获取用户数据
        Users users = this.usersMapper.queryById(attendance.getId());
        // 设置用户name
        attendance.setUserName(users.getUserName());
        attendance.setUserId(users.getId());
        // 设置当前时间的方法
        SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
        String format1 = hm.format(date);
        // 设置上班 下班时间 yyyy-MM-dd HH:mm:ss
        long s = hm.parse("08:30").getTime();
        long x = hm.parse("17:30").getTime();
        long clock = hm.parse(format1).getTime();

        //是否成功
        int _is = 0;
        // 查询是否有数据，有就修改，没有就新增
        Attendance attendance1 = attendanceMapper.queryByUserIdTime(attendance);
        if (attendance1 == null) {
            System.out.println("没有数据");
            // 没有数据新增
            if (clock < s) {
                // 上班
                attendance.setCreatedAt(date);
                attendance.setStatus(1);
            } else if (clock > s && clock < x) {
                // 迟到
                attendance.setCreatedAt(date);
                attendance.setStatus(0);
            } else if (clock > x) {
                // 未上班
                attendance.setCreatedAt(date);
                attendance.setSignOutAt(date);
                attendance.setStatus(-2);
            }
            _is = attendanceMapper.insert(attendance);
        } else {
            System.out.println("有数据");
            // 判断是否有打下班卡 有打判断为重复打卡
            if (attendance1.getSignOutAt() != null) {
                return RestFulBean.error("请不要重复打卡");
            }
            // 没有数据新增
            if (clock < s) {
                // 上班
                System.out.println("重复打卡上班");
                return RestFulBean.error("请不要重复打上班卡");
            } else if (clock > s && clock < x) {
                // 早退
                attendance.setSignOutAt(date);
                attendance.setStatus(-1);
            } else if (clock > x) {
                // 下班卡
                attendance.setSignOutAt(date);
                attendance.setStatus(2);
            }
            attendance.setId(attendance1.getId());
            _is = attendanceMapper.update(attendance);
        }
        if (_is > 0) {
            if (attendance.getStatus() == -2) {
                return RestFulBean.error("未上班");
            } else if (attendance.getStatus() == -1) {
                return RestFulBean.error("早退");
            } else if (attendance.getStatus() == 0) {
                return RestFulBean.error("迟到");
            } else if (attendance.getStatus() == 1) {
                return RestFulBean.succ("上班打卡");
            } else if (attendance.getStatus() == 2) {
                return RestFulBean.succ("下班打卡");
            }
            return RestFulBean.error("服务器异常");
        }
        return RestFulBean.error("打卡失败请重新打卡");
    }

}
