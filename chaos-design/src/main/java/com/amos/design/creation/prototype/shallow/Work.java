package com.amos.design.creation.prototype.shallow;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Work {

    private String date;
    private String company;

    public Work() {
    }

    public void setWorkInfo(String date, String company) {
        this.date = date;
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public String getCompany() {
        return company;
    }

}
