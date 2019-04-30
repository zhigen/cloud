package com.zglu.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "zglu_role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roleId;
    private int permissionId;
}