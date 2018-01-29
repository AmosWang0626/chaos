package cn.amos.simple.base;

/**
 * PROJECT: demo-java
 * DATE: 2017/11/24
 *
 * @author DaoYuanWang
 */
public class TestMath {

    public static void main(String[] args) {
        System.out.println(Math.pow(16, 2));
        System.out.println(Math.sqrt(16));

        int add = 2;
        int update = 4;
        int search = 8;
        int delete = 16;

        // 设置所有权限
        int all = add | update | search | delete;
        System.out.println(all);

        // 个人权限: 增加/查询
        int myPermit = add | search;
        System.out.println("permit (add|search) ====  add   \t" + ((myPermit & add) == add));
        System.out.println("permit (add|search) ====  update\t" + ((myPermit & update) == update));
        System.out.println("permit (add|search) ====  delete\t" + ((myPermit & delete) == delete));
        System.out.println("permit (add|search) ====  search\t" + ((myPermit & search) == search));

        System.out.println("(6 & 2) == 2  ? " + ((6 & 2) == 2));
        System.out.println("(6 & 4) == 4  ? " + ((6 & 4) == 4));
        System.out.println("(14 & 2) == 2 ? " + ((14 & 2) == 2));
        System.out.println("(14 & 4) == 4 ? " + ((14 & 4) == 4));
        System.out.println("(14 & 8) == 8 ? " + ((14 & 8) == 8));

        System.out.println("(6 & 2) == " + (6 & 2));
        System.out.println("(6 | 2) == " + (6 | 2));
        System.out.println("(5 & 2) == " + (5 & 2));
        System.out.println("(5 | 2) == " + (5 | 2));
        System.out.println("(16 & 2) == " + (16 & 2));
        System.out.println("(16 | 2) == " + (16 | 2));
        System.out.println("(17 & 2) == " + (17 & 2));
        System.out.println("(17 | 2) == " + (17 | 2));
        System.out.println("(18 & 2) == " + (18 & 2));
        System.out.println("(18 | 2) == " + (18 | 2));
    }
}
