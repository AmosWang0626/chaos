package cn.amos.common.base;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @apiNote Lambda 表达式
 * @date 2018/2/1
 */
public class LambdaDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.forEach(System.out::println);
    }
}
