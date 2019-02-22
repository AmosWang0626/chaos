package cn.amos.mode.design.creation.simple;

/**
 * PROJECT: chaos
 * DESCRIPTION: 简单工厂模式(Simple AbstractLogFactory Pattern)：又称为静态工厂方法(Static AbstractLogFactory Method)模式，它属于类创建型模式
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class ZzMain {

    /**
     * 重要程度（满分5）：4
     * <p>
     * 1.简单工厂模式的优点：
     * 客户端可以免除直接创建产品对象的责任，而仅仅“消费”产品；
     * 传入参数决定创建相应产品，客户端无须知道所创建的具体产品类的类名。
     * <p>
     * 2.简单工厂模式的缺点：
     * 不满足开闭原则（对拓展开放，对修改关闭）；
     * 由于工厂类集中了所有产品创建逻辑，一旦不能正常工作，整个系统都要受到影响；
     * 使用简单工厂模式将会增加系统中类的个数，在一定程序上增加了系统的复杂度和理解难度；
     * 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。
     * <p>
     * 3.适用环境
     * 工厂类负责创建的对象比较少：由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂；
     * 客户端只知道传入工厂类的参数，对于如何创建对象不关心。
     */
    public static void main(String[] args) {
        String operateMethod = "-";
        double num1 = 10D;
        double num2 = 10D;
        AbstractOperation operate = OperationFactory.createOperate(operateMethod);
        operate.init(num1, num2);
        double result = operate.getResult();
        System.out.println(num1 + operateMethod + num2 + ", result is " + result);
    }

}
