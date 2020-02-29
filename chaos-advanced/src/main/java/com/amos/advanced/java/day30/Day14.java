package com.amos.advanced.java.day30;

import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}

class Difference {
    private int[] elements;
    public int maximumDifference;

    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i; j < elements.length; j++) {
                int temp = Math.abs(elements[i] - elements[j]);
                if (temp > maximumDifference) {
                    maximumDifference = temp;
                }
            }
        }
    }

}