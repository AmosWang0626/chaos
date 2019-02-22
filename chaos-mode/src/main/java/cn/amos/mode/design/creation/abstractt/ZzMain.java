package cn.amos.mode.design.creation.abstractt;

/**
 * PROJECT: chaos
 * DESCRIPTION: 抽象工厂模式
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class ZzMain {

    /**
     * 1.优点
     * 符合“开闭原则”，秉承“高内聚低耦合”，因此抽象工厂模式得到了广泛的应用；
     * 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为；
     * 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象，非常实用。
     * <p>
     * 2.缺点
     * 开闭原则的倾斜性（增加新的工厂和产品族容易，增加新的产品等级结构麻烦）。
     * <p>
     * 3.适用环境
     * 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是重要的；
     * 系统中有多于一个的产品族，而每次只使用其中某一产品族；
     * 属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来；
     * 系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。
     */
    public static void main(String[] args) {
        // Factory factory = new FactoryMySQL();
        Factory factory = new FactoryOracle();
        Manage manage = factory.dataManage();
        manage.lock();
        User user = factory.createUser();
        System.out.println("Name: " + user.getName());
        manage.unLock();
    }

}
