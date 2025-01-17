package com.demo.practical_training.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 用户违规表
 */
@Entity
@Data
public class UserViolation {
    /**
     * 违规ID
     */
    @Id
    private String violationID;
    /**
     * 违规的用户ID
     */
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "userID")
    private User user;
    /**
     * 举报者ID（如果是其他用户举报的则有）
     */
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "reporterID")
    private User reporter;
    /**
     * 违规的原因
     */
    private String reason;
    /**
     * 处罚决定 1禁言 2封号
     */
    private Integer penaltyDecision;
    /**
     *处罚时长 1为3天,2为7天，3为15天，4为永久（可改）
     */
    private Integer duration;
    /**
     * 结束时间（在这个时间后，将用户状态设为正常）
     */
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp endTime;
}
