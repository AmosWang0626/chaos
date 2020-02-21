package com.amos.design.creation.prototype.deep;

import java.time.LocalDate;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Work implements Cloneable {

    private LocalDate date;
    private String company;

    public Work(LocalDate date, String company) {
        this.date = date;
        this.company = company;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCompany() {
        return company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
