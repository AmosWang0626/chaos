# Behavior
# 行为型设计模式
> 用于描述类与对象怎样的交互和分配职责（一共11个）

1. 责任链(Chain)
    > 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
2. 命令(Command)
3. 解释器(Interpreter)
    > 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该标示来解释语言中的句子。
4. 迭代器(Iterator)
5. 中介者(Mediator)
6. 备忘录(Memo)
    > 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
7. 观察者(Observer)
    > 定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。
8. 状态(State)
    > 当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
9. 策略(Strategy)
    > 它定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户。
10. 模板方法(Template Method)
    > 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
11. 访问者(Visitor)