package cn.amos.chaos.test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DESCRIPTION: PrefixMain
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/3/11
 */
public class PrefixMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("col" + i + "_名字" + i);
        }
        System.out.println(list);
        System.out.println(list.stream()
                .map(s -> s = s.substring(s.indexOf("_") + 1))
                .collect(Collectors.toList()));
    }

}
