package com.design.employeesManagement.pojo;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (SalaryTime)实体类
 *
 * @author makejava
 * @since  10:32:35
 */
public class SalaryTime implements Serializable {
    private static final long serialVersionUID = 122058026075798168L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 时间
     */
    private Date time;

    /**
     * 数据对象
     */
    private Attendance attendances;

    public Attendance getAttendances() {
        return attendances;
    }

    public void setAttendances(Attendance attendances) {
        this.attendances = attendances;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SalaryTime{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}

