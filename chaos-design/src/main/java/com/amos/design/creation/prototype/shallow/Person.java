package com.amos.design.creation.prototype.shallow;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Person implements Cloneable {

    private Long id;
    private String name;
    private Work work = new Work();

    public void setUserInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setWorkInfo(String date, String company) {
        this.work.setWorkInfo(date, company);
    }

    public String display() {
        return "ID: " + this.id + ", NAME: " + this.name
                + ", COMPANY: " + work.getCompany() + ", JOIN_DATE: " + work.getDate();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
