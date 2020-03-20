package com.amos.advanced.java.day30;

import java.util.List;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/28
 */
public class Day24 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 2, 2};
        Node head = null;

        for (int item : arr) {
            head = insert(head, item);
        }
        /// 获取所有重复元素
        // List<Node> dupList = new ArrayList<>();
        // getDuplicates(head, dupList);
        // dupList.forEach(node -> System.out.print(node.data + "\t"));
        // System.out.println(); 

        head = removeDuplicates(head);

        display(head);
    }

    public static Node removeDuplicates(Node head) {

        return head;
    }

    /**
     * 找到所有重复节点
     */
    public static void getDuplicates(Node head, List<Node> dupList) {
        int data = head.data;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == data) {
                dupList.add(temp);
            }
        }
        dupList.forEach(node -> System.out.print(node.data + "\t"));
        System.out.println();

        Node temp2 = head.next;
        if (temp2 == null) {
            return;
        }

        while (dupList.contains(temp2)) {
            temp2 = temp2.next;
        }
        if (temp2 != null) {
            getDuplicates(temp2, dupList);
        }
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null) {
            head = p;
        } else if (head.next == null) {
            head.next = p;
        } else {
            Node start = head;
            while (start.next != null) {
                start = start.next;
            }
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

}
