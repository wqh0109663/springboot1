package com.hacker.huan.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @author wqh
 * @date 18-5-6
 */
@Entity
@Data
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String username;
    private String password;
    @Min(value = 18,message = "未成年")
    private Integer age ;
    private Date createTime;
    private Integer identity;


}
