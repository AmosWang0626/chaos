package cn.amos.simple.proxy.friend;

public class BoyProxy implements SendInter {

    private BoyBody boyBody;

    public BoyProxy(BoyBody boyBody) {
        this.boyBody = boyBody;
    }

    @Override
    public void sendFlower(GirlBody girlBody) {
        boyBody.sendFlower(girlBody);
        System.out.println(this.getClass().getSimpleName() + "代理送花给" + girlBody);
    }

    @Override
    public void sendBody(GirlBody girlBody) {
        boyBody.sendBody(girlBody);
        System.out.println(this.getClass().getSimpleName() + "送布娃娃给" + girlBody);
    }
}
