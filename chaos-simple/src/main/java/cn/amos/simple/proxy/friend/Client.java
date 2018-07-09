package cn.amos.simple.proxy.friend;

public class Client {

    public static void main(String[] args) {

        GirlBody girlBody = new GirlBody();
        girlBody.setName("大宝贝");
        BoyProxy boyProxy = new BoyProxy(new BoyBody());
        boyProxy.sendFlower(girlBody);
        boyProxy.sendBody(girlBody);

    }

}
