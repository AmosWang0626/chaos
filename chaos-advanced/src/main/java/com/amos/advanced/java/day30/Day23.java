package com.amos.advanced.java.day30;

import java.util.*;

/**
 * PROJECT: interview
 * DESCRIPTION: 二叉树一层一层输出
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day23 {

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        listMap.put(1, Collections.singletonList(root.data));

        int deep = 2;
        range(root, deep, listMap);

        listMap.forEach((key, list) -> {
            if (list != null) {
                list.forEach(temp -> System.out.print(temp + " "));
            }
        });
    }

    static void range(Node root, int deep, Map<Integer, List<Integer>> listMap) {
        List<Integer> list = listMap.get(deep);
        if (root.left != null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(root.left.data);
        }
        if (root.right != null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(root.right.data);
        }
        listMap.put(deep, list);

        if (root.left != null) {
            range(root.left, deep + 1, listMap);
        }
        if (root.right != null) {
            range(root.right, deep + 1, listMap);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        final int count = 9;
        int[] arr = new int[]{20, 50, 35, 44, 9, 15, 62, 11, 13};
        Node root = null;

        for (int i : arr) {
            root = insert(root, i);
        }
        levelOrder(root);
    }


}
