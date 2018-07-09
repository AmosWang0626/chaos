package cn.amos.mode.design.prototype.demo1;

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

    private String date;
    private String company;

    public void setUserInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setWorkInfo(String date, String company) {
        this.date = date;
        this.company = company;
    }

    public String display() {
        return "ID: " + this.id + ", NAME: " + this.name
                + "\nCOMPANY: " + this.company + ", JOIN DATE: " + this.date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
