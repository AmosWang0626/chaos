package com.amos.advanced.java;

/**
 * DESCRIPTION: intern
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
public class StringStudy {

    public static void main(String[] args) {
        String a = new String("1");
        String aIntern = a.intern();
        String a1 = "1";
        System.out.println("a 的内存地址为 " + System.identityHashCode(a));
        System.out.println("aIntern 的内存地址为 " + System.identityHashCode(aIntern));
        System.out.println("a1 的内存地址为 " + System.identityHashCode(a1));
        System.out.printf("\ta == a1 ? %b\n", (a == a1));
        System.out.printf("\taIntern == a1 ? %b\n", (aIntern == a1));

        System.out.println("==============================================");

        String a2 = new String("1") + new String("1");
        String a3 = "11";
        String a2Intern = a2.intern();
        System.out.println("a2 的内存地址为 " + System.identityHashCode(a2));
        System.out.println("a2Intern 的内存地址为 " + System.identityHashCode(a2Intern));
        System.out.println("a3 的内存地址为 " + System.identityHashCode(a3));
        System.out.printf("\ta2 == a3 ? %b\n", (a2 == a3));
    }

}
