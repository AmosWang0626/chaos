package com.amos.advanced.java.day30;

import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: if else
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day03 {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        boolean weird = true;
        int N = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N % 2 == 0) {
            weird = false;
            if (N >= 6 && N <= 20) {
                weird = true;
            }
        }

        if (weird) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }

        SCANNER.close();
    }

}
