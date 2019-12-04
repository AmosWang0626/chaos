package cn.amos.common.simple.base;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/18
 */
public class Java8 {

    public static void main(String[] args) {
        String search = "NAME_06";
        List<String> body = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            body.add("NAME_0" + i);
        }
        boolean match = body.stream().anyMatch(search::equals);
        System.out.println("String array " + body + ",\nhave String (" + search + "): " + match);
    }

}
