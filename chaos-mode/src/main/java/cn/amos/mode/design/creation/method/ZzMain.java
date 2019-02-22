package cn.amos.mode.design.creation.method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 工厂方法模式：简称工厂模式，它属于类创建型模式；又被称为多态工厂模式，是因为所有的具体工厂类都具有同一抽象父类。
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
public class ZzMain {

    /**
     * 重要程度（满分5）：5
     * <p>
     * 1.工厂方法模式的优点：
     * 满足开闭原则：增加新的产品类时无须修改现有系统，并封装了产品对象的创建细节，系统具有良好的灵活性和可扩展性；
     * 用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
     * <p>
     * 2.工厂方法模式的缺点：
     * 增加新产品的同时需要增加新的工厂，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性；
     * 由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度，且在实现时可能需要用到DOM、反射等技术，增加了系统的实现难度。
     * <p>
     * 3.适用环境：
     * 客户端需要知道创建具体产品的工厂类；
     * 一个类通过其子类来指定创建哪个对象：利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展；
     */
    public static void main(String[] args) {
        AbstractRealLog instance = new LogFactoryFile().getInstance();
        instance.writeLog("啦啦啦啦啦啦啦啦啦啦啦啦啦");
        instance = new LogFactoryDatabase().getInstance();
        instance.writeLog("啦啦啦啦啦啦啦啦啦啦啦啦啦");
    }
}
