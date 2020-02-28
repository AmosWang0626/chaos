package com.amos.design.behavior.iterator;

/**
 * DESCRIPTION: 字符串集合 [用数组、指针实现]
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public class StringCluster extends BaseCluster<String> {

    private String[] array = new String[Byte.MAX_VALUE];

    private int point = -1;


    @Override
    public int add(String... ts) {
        int success = 0;
        for (String t : ts) {
            array[++point] = t;
            success++;
        }
        return success;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return point;
    }

}
