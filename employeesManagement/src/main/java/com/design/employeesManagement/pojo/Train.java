package com.design.employeesManagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Train)实体类
 *
 * @author makejava
 * @since  16:33:28
 */
public class Train implements Serializable {
    private static final long serialVersionUID = 676391540286250542L;
     /**
     * 主键
     */
    private Integer id;
     /**
     * 培训标题
     */
    private String trainingTitle;
     /**
     * 培训时间
     */
    private Date trainingTime;
     /**
     * 培训内容
     */
    private String trainingProgram;
     /**
     * 培训价格
     */
    private Integer trainingExpenses;

    private String  userName;
    private Integer  userId;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public Date getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(Date trainingTime) {
        this.trainingTime = trainingTime;
    }

    public String getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(String trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public Integer getTrainingExpenses() {
        return trainingExpenses;
    }

    public void setTrainingExpenses(Integer trainingExpenses) {
        this.trainingExpenses = trainingExpenses;
    }

}

