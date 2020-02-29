package com.amos.advanced.java.day30;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day11 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (k == 1 && (l == 0 || l == 2)) {
                            continue;
                        }
                        temp += arr[i + k][j + l];
                    }
                }
                set.add(temp);
            }
        }
        System.out.println(set.last());

        scanner.close();
    }

    /*
     * 1 1 1 0 0 0
     * 0 1 0 0 0 0
     * 1 1 1 0 0 0
     * 0 0 2 4 4 0
     * 0 0 0 2 0 0
     * 0 0 1 2 4 0
     */

}
