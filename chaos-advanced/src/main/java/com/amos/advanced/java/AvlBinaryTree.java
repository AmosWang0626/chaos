package com.amos.advanced.java;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * DESCRIPTION: 平衡二叉树
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/10
 */
public class AvlBinaryTree {

    public static void main(String[] args) {
        // simpleBinaryTree();
        randomBinaryTree();
    }

    private static void simpleBinaryTree() {
        /// init list [模拟左旋、右旋]
        // List<Integer> list = Arrays.asList(4, 3, 6, 5, 7, 8);
        List<Integer> list = Arrays.asList(6, 4, 7, 3, 5, 2);
        System.out.println("原始数组: " + list + ", 数组Size: " + list.size());

        AvlTreeNode root = new AvlTreeNode();
        for (Integer temp : list) {
            root.add(temp);
        }
    }

    public static void randomBinaryTree() {
        // 搞1000个数练练手
        int maxSize = 1000;
        AvlTreeNode root = new AvlTreeNode();
        // 不要用set存 [set有序,有序容易影响树高]
        List<Integer> list = new ArrayList<>();
        while (list.size() < maxSize) {
            int temp = new Random().nextInt(maxSize * 10);
            if (!list.contains(temp)) {
                list.add(temp);
            }
        }
        System.out.println("原始数组: " + list);
        list.forEach(root::add);
        System.out.print("最终二叉树: ");
        range(root);
    }

    /**
     * 先序遍历
     *
     * @param node TreeNode
     */
    public static void range(AvlTreeNode node) {
        System.out.printf("[%d](%d)\t\t", node.value, node.height());
        if (node.left != null) {
            range(node.left);
        }
        if (node.right != null) {
            range(node.right);
        }
        if (node.parent == null) {
            System.out.println();
        }
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    private static class AvlTreeNode {
        private Integer value;

        private AvlTreeNode left;
        private AvlTreeNode right;
        private AvlTreeNode parent;

        public AvlTreeNode() {
        }

        public AvlTreeNode(Integer value) {
            this.value = value;
        }

        public int height() {
            return Math.max(this.left == null ? 0 : this.left.height(),
                    this.right == null ? 0 : this.right.height()) + 1;
        }

        public int leftHeight() {
            return this.left == null ? 0 : left.height();
        }

        public int rightHeight() {
            return this.right == null ? 0 : right.height();
        }

        /**
         * 左旋
         */
        public void leftSpin() {
            AvlTreeNode newNode = new AvlTreeNode(this.value);
            newNode.left = this.left;
            newNode.right = this.right.left;
            newNode.parent = this;
            this.left = newNode;
            this.value = this.right.value;
            this.right = this.right.right;
            if (this.left.leftHeight() < this.left.rightHeight()) {
                this.left.leftSpin();
            }
        }

        /**
         * 右旋
         */
        public void rightSpin() {
            AvlTreeNode newNode = new AvlTreeNode(this.value);
            newNode.right = this.right;
            newNode.left = this.left.right;
            newNode.parent = this;
            this.right = newNode;
            this.value = this.left.value;
            this.left = this.left.left;

            if (this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightSpin();
            }
        }

        /**
         * 添加节点
         */
        public void add(Integer value) {
            if (this.value == null) {
                this.value = value;
                return;
            }
            AvlTreeNode node = new AvlTreeNode(value);
            if (this.value >= node.value) {
                if (this.left != null) {
                    this.left.add(value);
                } else {
                    this.left = node;
                    node.parent = this;
                }
            } else {
                if (this.right != null) {
                    this.right.add(value);
                } else {
                    this.right = node;
                    node.parent = this;
                }
            }
            if (this.parent == null && Math.abs(this.leftHeight() - this.rightHeight()) > 1) {
                do {
                    System.out.print("原始二叉树: ");
                    range(this);

                    if (this.leftHeight() > this.rightHeight()) {
                        System.out.print("二叉树右旋: ");
                        this.rightSpin();
                        range(this);
                    } else if (this.leftHeight() < this.rightHeight()) {
                        System.out.print("二叉树左旋: ");
                        this.leftSpin();
                        range(this);
                    }
                } while (Math.abs(this.leftHeight() - this.rightHeight()) > 1);
            }
        }

    }

}
