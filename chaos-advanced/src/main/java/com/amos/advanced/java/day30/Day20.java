package com.amos.advanced.java.day30;

import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] + a[j + 1];
                    a[j + 1] = a[j] - a[j + 1];
                    a[j] = a[j] - a[j + 1];
                    temp++;
                    sum++;
                }
            }
            if (temp == 0) {
                break;
            }
        }
        System.out.println("Array is sorted in " + sum + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }

}
