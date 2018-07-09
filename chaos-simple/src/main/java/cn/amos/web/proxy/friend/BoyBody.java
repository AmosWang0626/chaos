package cn.amos.web.proxy.friend;

public class BoyBody implements SendInter {

    @Override
    public void sendFlower(GirlBody girlBody) {
        System.out.println(this.getClass().getSimpleName() + "买花，准备送给" + girlBody);
    }

    @Override
    public void sendBody(GirlBody girlBody) {
        System.out.println(this.getClass().getSimpleName() + "买布娃娃，准备送给" + girlBody);
    }
}
