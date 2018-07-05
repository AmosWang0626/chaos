package cn.amos.base;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/5
 */
public class AbstractTest {

    public static void main(String[] args) {
        BaseHello hello = new Hello("Amos");
        System.out.println(hello.getName() + " say hello!");
    }
}

abstract class BaseHello {
    private String name;

    BaseHello(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Hello extends BaseHello {

    Hello(String name) {
        super(name);
    }
}