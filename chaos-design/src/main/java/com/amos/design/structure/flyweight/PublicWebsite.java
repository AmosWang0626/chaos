package com.amos.design.structure.flyweight;

/**
 * DESCRIPTION: 共有网站模型
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/23/2020
 */
public class PublicWebsite implements Website {

    private String name;

    public PublicWebsite(String name) {
        this.name = name;
    }

    @Override
    public void access(Visitor visitor) {
        System.out.println("网站类型: " + name + ", 访问者: " + visitor.getName());
    }

}
