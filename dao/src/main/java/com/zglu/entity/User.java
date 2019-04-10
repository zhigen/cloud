package com.zglu.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "zglu_user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login_name;
    private String password;
    private String name;
    private String phone;
    private boolean sex = true;
    private String id_card;
    @CreatedDate
    private Date createdDate;
    @CreatedBy
    private Integer createdBy;
    @LastModifiedDate
    private Date modifiedDate;
    @LastModifiedBy
    private Integer modifiedBy;
    private Boolean enable = true;
}