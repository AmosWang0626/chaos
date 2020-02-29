package com.amos.advanced.java.day30;

import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day10 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] split = Integer.toBinaryString(n).split("0");
        int max = 0;
        for (String s : split) {
            if (max < s.length()) {
                max = s.length();
            }
        }

        System.out.println(max);

        scanner.close();
    }

}
