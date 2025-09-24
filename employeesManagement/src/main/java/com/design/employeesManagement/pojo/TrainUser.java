package com.design.employeesManagement.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * (TrainUser)实体类
 *
 * @author makejava
 * @since  12:08:39
 */
public class TrainUser implements Serializable {
    private static final long serialVersionUID = -12919592140430907L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 关联用户id
     */
    private Integer userId;
    /**
     * 关联培训计划id
     */
    private Integer trainId;

    // 关键数据 参与的培训
    private Train train;
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
    private Integer  trainUserId;

    public Integer getTrainUserId() {
        return trainUserId;
    }

    public void setTrainUserId(Integer trainUserId) {
        this.trainUserId = trainUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

}

