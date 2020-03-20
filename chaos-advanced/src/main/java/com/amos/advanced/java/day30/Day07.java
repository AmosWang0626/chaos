package com.amos.advanced.java.day30;

import java.util.Arrays;
import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: 数组颠倒顺序
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day07 {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int n = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = SCANNER.nextLine().split(" ");
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = arr.length; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }

        Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));

        // Stream.of(arr).forEach(ints -> sb.append(ints).append(" "));

        System.out.println(sb.toString().trim());

        SCANNER.close();
    }

}
