package cn.amos.base;

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

        int all = add | update | search | delete;

        System.out.println(all);

        int myAuth = add | update | search;

//        System.out.println((myAuth & add) == add);
//        System.out.println((myAuth & update) == update);
//        System.out.println((myAuth & delete) == delete);
//        System.out.println((myAuth & search) == search);

        System.out.println((6 & 2) == 2);
        System.out.println((14 & 8) == 8);
    }
}
