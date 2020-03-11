package com.amos.advanced.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class MapStudy {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i, "HashMap-" + i);
        }
        System.out.println(map);

        Map<Integer, String> currentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            currentMap.put(i, "ConcurrentHashMap-" + i);
        }
        System.out.println(currentMap);
    }

}
