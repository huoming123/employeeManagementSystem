package com.design.employeesManagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Manager)实体类
 *
 * @author makejava
 * @since 2024-09-18 13:38:58
 */
public class Manager implements Serializable {
    private static final long serialVersionUID = 266878873362848219L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 管理员编号
     */
    private String userNo;
     /**
     * 手机号码11位
     */
    private String telephone;
     /**
     * 用户名
     */
    private String userName;
     /**
     * 密码
     */
    private String password;
     /**
     * 录入时间
     */
    private Date createdAt;
     /**
     * 头像
     */
    private String images;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}

