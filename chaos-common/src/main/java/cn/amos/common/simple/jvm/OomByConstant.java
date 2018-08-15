package cn.amos.common.simple.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: chaos
 * NOTE: 类说明
 *
 * @author AMOS
 * @date 2018/8/15 15:58
 */
public class OomByConstant {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        long i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            System.out.println("this list size is " + list.size());
        }
    }

}
