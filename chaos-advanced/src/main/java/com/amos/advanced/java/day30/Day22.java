package com.amos.advanced.java.day30;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day22 {

    private static TreeSet<Integer> heights = new TreeSet<>();

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int getHeight(Node root) {
        height(root, 0);

        return heights.last();
    }

    private static void height(Node root, int height) {
        if (root == null) {
            return;
        }
        height++;
        heights.add(height);

        if (root.left != null) {
            height(root.left, height);
        }
        if (root.right != null) {
            height(root.right, height);
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
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }

}
