package com.hucode.study.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Created by admin on 2017/6/2.
 */
public class BaseEntity {

    @Id
    private Integer id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
