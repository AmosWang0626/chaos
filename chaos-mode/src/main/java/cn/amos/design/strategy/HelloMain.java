package cn.amos.design.strategy;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class HelloMain {

    public static void main(String[] args) {
        HelloContext chineseHello = new HelloContext(new ChineseHello());
        chineseHello.contextInterface();
        HelloContext englishHello = new HelloContext(new EnglishHello());
        englishHello.contextInterface();

        HelloContextFactory china = new HelloContextFactory("china");
        china.contextInterface();
        HelloContextFactory english = new HelloContextFactory("english");
        english.contextInterface();
    }
}
