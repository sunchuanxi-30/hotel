package com.dareway.hotel.hotel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private String role;
    private String userSfzhm;
    private String userTel;
    private String userAddress;
    private String userRealname;

    private int pageSize;
    private int currentPage;
}
