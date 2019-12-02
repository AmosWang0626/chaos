package cn.amos.common.simple.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/27
 */
public class Aaa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(sc.nextLine());
        }

        list.forEach(s -> {
            char[] chars = s.toCharArray();
            char[] rtn = new char[chars.length + 1];

            int evenIndex = 0;
            int oddIndex;

            if (chars.length % 2 == 0) {
                rtn[chars.length / 2] = ' ';
                oddIndex = chars.length / 2 + 1;
            } else {
                rtn[chars.length / 2 + 1] = ' ';
                oddIndex = chars.length / 2 + 2;
            }

            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    rtn[evenIndex] = chars[i];
                    evenIndex++;
                } else {
                    rtn[oddIndex] = chars[i];
                    oddIndex++;
                }
            }

            System.out.println(rtn);
        });
    }

}
