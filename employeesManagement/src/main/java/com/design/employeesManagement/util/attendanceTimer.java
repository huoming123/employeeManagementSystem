package com.design.employeesManagement.util;

import com.design.employeesManagement.mapper.SalaryTimeMapper;
import com.design.employeesManagement.pojo.SalaryTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class attendanceTimer {
    @Autowired
    private SalaryTimeMapper salaryTimeMapper;

//    @Scheduled(cron = "0 */1 * * * ?") //每分钟执行一次
    @Scheduled(cron = "0/2 * * * * ?") //每两秒钟执行一次
    //@Scheduled(cron = "0 30 9 1 * ?")//0 30 9 1 * ? 每月1号上午9点半
//   @Scheduled(cron = "0 0 2 1 * ?") //每月1号上午2点 执行下面的数据
    public void test() {
          Date date = new Date();
           SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM");
           String dateStr = fmt.format(date);
           List<SalaryTime> list =salaryTimeMapper.getByDate(dateStr); //根据当前日期判断这个月份是否生成考勤日期
      if(list.size()==0){
    // 获取当前年
    SimpleDateFormat y = new SimpleDateFormat("yyyy");
    // 获取当前月
    SimpleDateFormat m = new SimpleDateFormat("MM");
    // 转化为int
    int year = Integer.parseInt(y.format(date));
    int month = Integer.parseInt(m.format(date));
    // 传到方法 getDayByMonth里面
    List<SalaryTime> dayByMonth = getDayByMonth(year, month);
    System.out.println(dayByMonth);
    // 将数据保存到数据库
    salaryTimeMapper.insertOrUpdateBatch(dayByMonth);
    }


    }

    // 获取当前月 有多少天 给成数据 2023-01-01格式
    public static List<SalaryTime> getDayByMonth(int yearParam, int monthParam) {
        List<SalaryTime> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(yearParam, monthParam - 1, 1);
        int year = calendar.get(Calendar.YEAR);//年份
        int month = calendar.get(Calendar.MONTH) + 1;//月份
        int day = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String date = null;
            SalaryTime salaryTime = new SalaryTime();
            if (month < 10 && i < 10) {
                date = String.valueOf(year) + "-0" + month + "-0" + i;
            }
            if (month < 10 && i >= 10) {
                date = String.valueOf(year) + "-0" + month + "-" + i;
            }
            if (month >= 10 && i < 10) {
                date = String.valueOf(year) + "-" + month + "-0" + i;
            }
            if (month >= 10 && i >= 10) {
                date = String.valueOf(year) + "-" + month + "-" + i;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = null;
            try {
                date1 = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);
            System.out.println(date1);
            salaryTime.setTime(date1);
            list.add(salaryTime);
        }
        return list;
    }

}
