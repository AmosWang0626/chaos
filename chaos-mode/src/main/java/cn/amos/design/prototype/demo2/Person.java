package cn.amos.design.prototype.demo2;

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

    public Work work;

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
        work.date = date;
        work.company = company;
    }

    public String display() {
        return "ID: " + this.id + ", NAME: " + this.name
                + "\nCOMPANY: " + work.company + ", JOIN DATE: " + work.date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
