package cn.amos.base.abstracts;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/5
 */
public class AbstractTest2 {

    public static void main(String[] args) {
        BaseInfo info = BaseInfo.instance();
        System.out.println(info.getInfo());
        System.out.println(BaseInfo.name);
    }
}

abstract class BaseInfo {
    static String name = "啦啦啦";

    /**
     * getInfo
     *
     * @return info
     */
    abstract String getInfo();

    static BaseInfo instance() {
        return new Info();
    }
}

class Info extends BaseInfo {

    @Override
    String getInfo() {
        return "hello message";
    }
}
