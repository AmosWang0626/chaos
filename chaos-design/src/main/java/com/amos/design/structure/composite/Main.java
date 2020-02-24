package com.amos.design.structure.composite;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 组合
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("总公司");
        root.add(new DeptFinance(root.getName() + "财务部"));
        root.add(new DeptHr(root.getName() + "人力资源部"));

        ConcreteCompany branch = new ConcreteCompany("上海华东分公司");
        branch.add(new DeptFinance(branch.getName() + "财务部"));
        branch.add(new DeptHr(branch.getName() + "人力资源部"));
        // root add
        root.add(branch);

        ConcreteCompany agency1 = new ConcreteCompany("南京办事处");
        agency1.add(new DeptFinance(agency1.getName() + "财务部"));
        agency1.add(new DeptHr(agency1.getName() + "人力资源部"));

        ConcreteCompany agency2 = new ConcreteCompany("杭州办事处");
        agency2.add(new DeptFinance(agency2.getName() + "财务部"));
        agency2.add(new DeptHr(agency2.getName() + "人力资源部"));
        // branch add
        branch.add(agency1);
        branch.add(agency2);

        System.out.println("结构图：");
        root.display(2);
        System.out.println("\n职责：");
        root.lineOfDuty();
    }

}
