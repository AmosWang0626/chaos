# 工厂模式

## simple
> 简单工厂模式
>
> eg.数字运算
1. 一个接口：BigDecimal getResult(num1, num2);
2. 四个实现类：
    - add       num1 + num2
    - subtract  num1 - num2
    - multiply  num1 * num2
    - divide    num1 / num2
3. 一个工厂类：case(+ - * /) return 具体实现类

## method
> 工厂方法模式
1. 一个接口：BaseOperation getInstance();
2. 一个抽象类：
    - private BigDecimal num1;
    - private BigDecimal num2;
    - public abstract BigDecimal getResult();
3. 四个实现类/四个工厂类：
    - add      工厂返回 add      实现类 (num1 + num2)
    - subtract 工厂返回 subtract 实现类 (num1 - num2) 
    - multiply 工厂返回 multiply 实现类 (num1 * num2) 
    - divide   工厂返回 divide   实现类 (num1 / num2) 
4. Main

## abstract
> 抽象工厂模式
1. 一个工厂接口：
    - 创建用户：abstract User createUser();
    - 数据管理：abstract Manage dataManage();
2. 两个实例工厂/以及相应的工厂接口实现类：

    | 工厂 | 用户相关 | 数据管理相关 |
    | :--- | :---: | ---: |
    | MySQL     | UserMySQL     | ManageMySQL   |
    | Oracle    | UserOracle    | ManageOracle  |
3. Main 
