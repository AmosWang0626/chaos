package com.amos.design.structure.flyweight;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 享元
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        Website blog = factory.getPublicWebSite("博客");
        blog.access(new Visitor("amos"));
        Website blog2 = factory.getPublicWebSite("博客");
        blog2.access(new Visitor("grace"));
        Website blog3 = factory.getPublicWebSite("博客");
        blog3.access(new Visitor("jack"));

        Website official = factory.getPublicWebSite("官网");
        official.access(new Visitor("amos"));
        Website official2 = factory.getPublicWebSite("官网");
        official2.access(new Visitor("grace"));
        Website official3 = factory.getPublicWebSite("官网");
        official3.access(new Visitor("jack"));

        System.out.println("Website Count: " + factory.getPublicWebsiteCount());

        String str1 = "欢迎 amos.wang";
        String str2 = "欢迎 amos.wang";
        System.out.println("str1 == str2 ? " + (str1 == str2));

        // @see IntegerCache
        Integer int1 = -128;
        Integer int2 = -128;
        System.out.println("-128 (int1 == int2) ? " + (int1 == int2));
        Integer int3 = -129;
        Integer int4 = -129;
        System.out.println("-129 (int3 == int4) ? " + (int3 == int4));
        Integer int5 = 127;
        Integer int6 = 127;
        System.out.println("127 (int5 == int6) ? " + (int5 == int6));
        Integer int7 = 128;
        Integer int8 = 128;
        System.out.println("128 (int7 == int8) ? " + (int7 == int8));
        System.out.println("IntegerCache range [-128, 127]");
    }

}
