package com.design.employeesManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since  11:24:19
 */
public class Users implements Serializable {
    private static final long serialVersionUID = -65444126440439950L;

    private Integer id;
     /**
     * 密码
     */
    private String password;
     /**
     * 手机号存个字符串11位
     */
    private String telephone;
     /**
     * 录入时间
     */
    private Date createdAt;
     /**
     * 姓名
     */
    private String userName;
     /**
     * 身份证
     */
    private String cardId;
     /**
     * 年龄
     */
    private Integer age;
     /**
     * 性别
     */
    private String sex;
     /**
     * 住址
     */
    private String address;
     /**
     * 民族
     */
    private String nation;
     /**
     * 出生年月 时间戳
     */
    private Date birthday;
     /**
     * 籍贯
     */
    private String nativePlace;
     /**
     * 婚姻状况
     */
    private String maritalStatus;
     /**
     * 政治面貌
     */
    private String political;
     /**
     * 录入人
     */
    private String createdBy;
     /**
     * 11位员工号
     */
    private String userNo;
     /**
     * 角色
     */
    private String role;
     /**
     * 照片 
     */
    private String images;
    private String imagesUrl;
     /**
     * 入职时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startAt;
     /**
     * 辞职时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leaveAt;
     /**
     * 部门
     */
    private String depart;
     /**
     * 职称
     */
    private String ranks;
     /**
     * 学历
     */
    private String education;
     /**
     * 是否为优秀员工
     */
    private String excellent;
     /**
     * 邮箱
     */
    private String email;
    private String oldPassword;
    private String newsPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewsPassword() {
        return newsPassword;
    }

    public void setNewsPassword(String newsPassword) {
        this.newsPassword = newsPassword;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", createdAt=" + createdAt +
                ", userName='" + userName + '\'' +
                ", cardId='" + cardId + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday=" + birthday +
                ", nativePlace='" + nativePlace + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", political='" + political + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", userNo='" + userNo + '\'' +
                ", role='" + role + '\'' +
                ", images='" + images + '\'' +
                ", imagesUrl='" + imagesUrl + '\'' +
                ", startAt=" + startAt +
                ", leaveAt=" + leaveAt +
                ", depart='" + depart + '\'' +
                ", ranks='" + ranks + '\'' +
                ", education='" + education + '\'' +
                ", excellent='" + excellent + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }

    /**
     * 是否离职 1为在职 0 为离职
     */
    private Integer status;

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getLeaveAt() {
        return leaveAt;
    }

    public void setLeaveAt(Date leaveAt) {
        this.leaveAt = leaveAt;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getRanks() {
        return ranks;
    }

    public void setRanks(String ranks) {
        this.ranks = ranks;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExcellent() {
        return excellent;
    }

    public void setExcellent(String excellent) {
        this.excellent = excellent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

