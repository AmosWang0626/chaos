package com.amos.advanced.java;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * DESCRIPTION: 二叉树（增删改查）
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/10
 */
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int temp = new Random().nextInt(80) + 10;
            list.add(temp);
            root.add(new TreeNode(temp));
        }
        System.out.println("原始数组: " + list);
        range(root);
        System.out.println();

        // 二叉树删除
        Integer number = list.get(list.size() / 2);
        list.remove(number);
        System.out.println("删除节点: " + number);
        root.delete(new TreeNode(number));

        number = list.get(list.size() / 2);
        list.remove(number);
        System.out.println("删除节点: " + number);
        root.delete(new TreeNode(number));

        number = list.get(list.size() / 2);
        list.remove(number);
        System.out.println("删除节点: " + number);
        root.delete(new TreeNode(number));

        range(root);
        System.out.println();
    }


    /**
     * 先序遍历
     *
     * @param node TreeNode
     */
    public static void range(TreeNode node) {
        System.out.print(node.value + "\t");
        if (node.left != null) {
            range(node.left);
        }
        if (node.right != null) {
            range(node.right);
        }
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    private static class TreeNode {
        private Integer value;

        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(Integer value) {
            this.value = value;
        }

        /**
         * 添加节点
         *
         * @param node TreeNode
         */
        public void add(TreeNode node) {
            if (this.value >= node.value) {
                if (this.left != null) {
                    this.left.add(node);
                } else {
                    this.left = node;
                    node.parent = this;
                }
            } else {
                if (this.right != null) {
                    this.right.add(node);
                } else {
                    this.right = node;
                    node.parent = this;
                }
            }
        }

        /**
         * 删除节点
         *
         * @param node TreeNode
         */
        public void delete(TreeNode node) {
            if (this.value > node.value) {
                if (this.left != null) {
                    this.left.delete(node);
                } else {
                    System.out.println("LEFT NOT FOUND!!!");
                    return;
                }
            }
            if (this.value < node.value) {
                if (this.right != null) {
                    this.right.delete(node);
                } else {
                    System.out.println("LEFT NOT FOUND!!!");
                    return;
                }
            }

            /*
            三种情况
            1.删除节点为叶子节点
            2.删除节点左右子树都不为空
            3.删除节点左子树或右子树为空
            */

            // 1.删除的节点没有左右节点,可直接删除
            if (this.left == null && this.right == null) {
                if (this.parent.left.value.equals(this.value)) {
                    this.parent.left = null;
                } else {
                    this.parent.right = null;
                }
                return;
            }

            // 2.左右子树都不为空, 找左子树最大或右子树最小替代中间节点
            if (this.left != null && this.right != null) {
                TreeNode maxLeft = getMaxLeft(this.left);
                this.value = maxLeft.value;
                return;
            }

            // 3.左右子树只有一个为空,下一节点顶上
            if (this.left != null) {
                if (this.parent.left.value.equals(this.value)) {
                    this.parent.left = this.left;
                } else {
                    this.parent.right = this.left;
                }
                return;
            }
            if (this.parent.left.value.equals(this.value)) {
                this.parent.left = this.right;
            } else {
                this.parent.right = this.right;
            }
        }

        /**
         * 获取左子树最大节点
         *
         * @param node root下左子树
         * @return 左子树最大节点
         */
        private TreeNode getMaxLeft(TreeNode node) {
            if (node.right == null) {
                if (node.left != null) {
                    node.parent.right = node.left;
                    node.left = null;
                }
                return node;
            }
            return getMaxLeft(node.right);
        }

        /**
         * 获取左子树最大节点
         *
         * @param node root下左子树
         * @return 左子树最大节点
         */
        private TreeNode getMinRight(TreeNode node) {
            if (node.left == null) {
                if (node.right != null) {
                    node.parent.left = node.right;
                    node.right = null;
                }
                return node;
            }
            return getMinRight(node.left);
        }
    }

}
