package com.amos.advanced.java.day30;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day23 {

    private static LinkedList<Integer> nodes = new LinkedList<>();

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void levelOrder(Node root) {
        if (root != null) {
            nodes.add(root.data);
        }
        hello(root);
        nodes.forEach(integer -> System.out.print(integer + " "));
    }

    static void hello(Node root) {
        if (root != null) {
            nodes.add(root.data);
            if (root.left != null) {
                nodes.add(root.left.data);
            }
            if (root.right != null) {
                nodes.add(root.right.data);
            }
            hello(root.left);
            hello(root.right);
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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }


}
