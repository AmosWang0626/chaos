package cn.amos.design.prototype.demo3;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Work implements Cloneable {

    private String date;
    private String company;

    public Work(String date, String company) {
        this.date = date;
        this.company = company;
    }

    public String getDate() {
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
