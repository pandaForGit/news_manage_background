package com.demo.practical_training.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 用户
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(columnDefinition = "CHAR(33)")
    private String userID;
    /**
     * 用户头像路径
     */
    private String userAvatar;
    /**
     * 用户名(可改，但是唯一)
     */
    @Column(unique = true)
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 性别 0女 1男
     */
    private Integer userSex;
    /**
     * 手机号码(唯一,一个用户绑定一个手机号码)
     */
    private String userPhone;
    /**
     * 注册时间
     */
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp registrationTime;
    /**
     * 用户状态 1正常 0已注销 -1违规禁言 -2违规封号
     */
    private Integer userState;
    /**
     * 是否实名认证 1是 0否
     */
    private Integer isCertified;
    /**
     * 违规次数
     */
    private Integer violationNumber;
    @ManyToMany
    @JoinTable(name = "userAndLabel",
        joinColumns = @JoinColumn(name = "userID",referencedColumnName = "userID"),
            inverseJoinColumns = @JoinColumn(name = "newLabelID",referencedColumnName = "newLabelID")
    )

    private List<NewsLabel> newsLabelList;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "newsAndUser")
    private List<News> newsList;
}
