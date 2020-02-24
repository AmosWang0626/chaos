# Design
> 设计模式, 代码的孙子兵法

---
## 1、原则
1. 单一职责原则
    > 就一个类而言，应该仅有一个引起它变化的原因。
2. 开闭原则
    > 软件实体（类、模块、函数等等）应该可以扩展，但是不可以修改。
3. 依赖倒置原则
    > 要针对接口编程，不要对实现编程。
    1. 高层模块不应该依赖低层模块，两个都应该依赖抽象；
    2. 抽象不应该依赖细节，细节应该依赖抽象。
4. 里式替换原则
    > 子类型必须能够替换掉他们的父类型。
5. 接口隔离原则
    > 细化接口，但要适中，不大不小方为最佳实践。
    1. 客户端不应该依赖它不需要的接口；
    2. 类间的依赖关系应该建立在最小的接口上。
6. 迪米特原则
    > 如果两个类不必彼此直接通信，那么这两个类就不应当发生直接的相互作用。
      如果其中一个类需要调用另一个类的某一个方法的话，可以通过第三者转发这个调用。

### 原则总结 [参考:设计模式图册](https://mp.weixin.qq.com/s/xQLBvFJrMDTF8551oFxLnA)
> 用抽象构建框架，用实现扩展细节
- 单一职责原则告诉我们实现类要职责单一；
- 里氏替换原则告诉我们不要破坏继承体系；
- 依赖倒置原则告诉我们要面向接口编程；
- 接口隔离原则告诉我们在设计接口的时候要精简单一；
- 迪米特法则告诉我们要降低耦合。

而开闭原则是总纲，他告诉我们要对扩展开放，对修改关闭。

---
## 2、分类
### 2.1 [创建型模式](https://github.com/AmosWang0626/chaos/tree/master/chaos-design/src/main/java/com/amos/design/creation)
1. 建造者(Builder)
2. 工厂方法(Factory Method)
3. 抽象工厂(Abstract Factory)
4. 原型(Prototype)
5. 单例(Singleton)

### 2.2 [结构型模式](https://github.com/AmosWang0626/chaos/tree/master/chaos-design/src/main/java/com/amos/design/structure)
1. 适配器(Adapter)
2. 桥接(Bridge Pattern)
3. 组合(Composite)
4. 装饰者(Decorator)
5. 外观(Facade)
6. 享元(Flyweight)
7. 代理(Proxy)

### 2.3 [行为型模式](https://github.com/AmosWang0626/chaos/tree/master/chaos-design/src/main/java/com/amos/design/behavior)
> 整理中
1. 责任链(Chain)
2. 命令(Command)
3. 解释器(Interpreter)
4. 迭代器(Iterator)
5. 中介者(Mediator)
6. 备忘录(Memo)
7. 观察者(Observer)
8. 状态(State)
9. 策略(Strategy)
10. 模板方法(Template Method)
11. 访问者(Visitor)
