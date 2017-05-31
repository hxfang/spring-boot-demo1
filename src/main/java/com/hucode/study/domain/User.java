package com.hucode.study.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by admin on 2017/5/31.
 */

@Data
public class User implements Serializable {

    private long id;
    private String name;
    private String password;
    private String phone;
    private String email;

}
