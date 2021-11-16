package main.java.biz.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO {
    private String id;
    private String password;
    private String name;
    private Date regDate;
    private String role;
}
