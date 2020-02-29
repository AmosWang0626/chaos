package com.amos.advanced.java.day30;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<String, Integer> map = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            map.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
            Integer phoneNo = map.get(s);
            if (phoneNo == null) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + phoneNo);
            }
        }
        in.close();
    }

}
