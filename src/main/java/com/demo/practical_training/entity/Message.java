package com.demo.practical_training.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 消息
 */
@Entity
@Data
public class Message {
    /**
     * 消息ID
     */
    @Id
    private String messageID;
    /**
     * 来源ID
     */
    private String formID;
    /**
     * 去处ID（某个用户）
     */
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "toID")
    private User user;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 是否已读
     */
    private Integer isRead;
    /**
     * 创建时间
     */
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp createTime;
}
