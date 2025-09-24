package com.design.employeesManagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Attendance)实体类
 *
 * @author makejava
 * @since 17:01:03
 */
public class Attendance implements Serializable {
    private static final long serialVersionUID = -27771291534891498L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 绑定日期主键
     */
    private Integer date;
     /**
     * 签到人id
     */
    private Integer userId;
     /**
     * 签到人姓名
     */
    private String userName;
     /**
     * 是否签到 1为签到 0 为未签 -1为签退
     */
    private Integer status;
     /**
     * 签到日期
     */
    private Date createdAt;
     /**
     * 签退日期
     */
    private Date signOutAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getSignOutAt() {
        return signOutAt;
    }

    public void setSignOutAt(Date signOutAt) {
        this.signOutAt = signOutAt;
    }

}

