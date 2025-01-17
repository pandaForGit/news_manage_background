package com.demo.practical_training.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 评论
 */
@Entity
@Data
public class Comment {
    /**
     * 评论ID
     */
    @Id
    private String commentID;
    /**
     * 新闻ID
     */
    @OneToOne
    @JoinColumn(name = "newsID")
    private News news;
    /**
     * 用户ID
     */
    @OneToOne
    @JoinColumn(name = "userID")
    private User user;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 评论时间
     */
    @Column(columnDefinition="TIMESTAMP")
    private Timestamp commentTime;
    /**
     * 回复用户ID
     */
    private String replyUserId;
    /**
     * 回复用户是否已读,0未读,1已读
     */
    private Integer replyUserHasRead;
    /**
     * 点赞数
     */
    private Long likeNumber;
}
