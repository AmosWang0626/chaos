package com.amos.advanced.java.day30;

import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        try {
            Integer integer = Integer.valueOf(s);
            System.out.println(integer);
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
    }

}
