package com.design.employeesManagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Wage)实体类
 *
 * @author makejava
 * @since  15:08:46
 */
public class Wage implements Serializable {
    private static final long serialVersionUID = -37911350554207014L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 月份
     */
    private Date month;
     /**
     * 用户
     */
    private Integer userId;
     /**
     * 出勤小时
     */
    private Integer attendanceHour;
     /**
     * 基本工资
     */
    private Integer basePay;
     /**
     * 奖金
     */
    private Integer bonus;
     /**
     * 福利
     */
    private Integer weal;
     /**
     * 总工资
     */
    private Integer wageTotal;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAttendanceHour() {
        return attendanceHour;
    }

    public void setAttendanceHour(Integer attendanceHour) {
        this.attendanceHour = attendanceHour;
    }

    public Integer getBasePay() {
        return basePay;
    }

    public void setBasePay(Integer basePay) {
        this.basePay = basePay;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getWeal() {
        return weal;
    }

    public void setWeal(Integer weal) {
        this.weal = weal;
    }

    public Integer getWageTotal() {
        return wageTotal;
    }

    public void setWageTotal(Integer wageTotal) {
        this.wageTotal = wageTotal;
    }

}

