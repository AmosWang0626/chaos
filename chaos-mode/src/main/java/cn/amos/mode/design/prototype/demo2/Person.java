package cn.amos.mode.design.prototype.demo2;

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
    private Work work;

    /*
     * Date 默认实现了Cloneable接口类
     */

    public Person() {
        work = new Work();
    }

    public void setUserInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setWorkInfo(String date, String company) {
        work.setDate(date);
        work.setCompany(company);
    }

    public String display() {
        return "ID: " + this.id + ", NAME: " + this.name
                + "\nCOMPANY: " + work.getCompany() + ", JOIN DATE: " + work.getDate();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
