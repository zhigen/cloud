package com.zglu.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {
    private String id;
    private String name;
}