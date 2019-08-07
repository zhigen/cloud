package com.zglu.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int roleId;
}