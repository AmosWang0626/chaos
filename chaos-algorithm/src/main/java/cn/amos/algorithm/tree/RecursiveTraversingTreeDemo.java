package cn.amos.algorithm.tree;

import java.util.Random;

/**
 * NOTE: 简单二叉树初始化以及递归的方式进行遍历
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/9
 */
public class RecursiveTraversingTreeDemo {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // 初始化树
        Tree<String> tree = simpleTree();
        printTreeNodePre(tree);
    }

    /**
     * 先序遍历,递归遍历
     */
    private static void printTreeNodePre(Tree<String> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.toString());
        printTreeNodePre(node.left);

        printTreeNodePre(node.right);
    }

    /**
     * 中序遍历,递归遍历
     */
    private static void printTreeNodeCenter(Tree<String> node) {
        if (node == null) {
            return;
        }
        printTreeNodeCenter(node.left);
        System.out.println(node.toString());
        printTreeNodeCenter(node.right);
    }

    /**
     * 后序遍历,递归遍历
     */
    private static void printTreeNodeEnd(Tree<String> node) {
        if (node == null) {
            return;
        }
        printTreeNodeEnd(node.left);
        printTreeNodeEnd(node.right);
        System.out.println(node.toString());
    }

    private static Tree<String> simpleTree() {
        // 生成简单树
        Tree<String> tree = new Tree<>("root");
        // 根节点左右节点
        Tree<String> treeLeft1 = tree.addLeft(new Tree<>("L"));
        Tree<String> treeRight1 = tree.addRight(new Tree<>("R"));
        // 给左节点添加左右节点
        treeLeft1.addLeft(new Tree<>("L L"));
        treeLeft1.addRight(new Tree<>("L R"));
        // 给右节点添加左右节点
        treeRight1.addLeft(new Tree<>("R L"));
        treeRight1.addRight(new Tree<>("R R"));

        return tree;
    }

    private static Tree<String> generateRandomTree() {
        int treeHigh = 5;
        // 生成一棵随机树
        Tree<String> tree = new Tree<>("root");
        Tree<String> temp = tree;

        for (int i = 0; i < treeHigh; i++) {
            if (RANDOM.nextBoolean()) {
                Tree<String> newLeft = temp.addLeft(new Tree<>("left " + i));
                Tree<String> newRight = temp.addRight(new Tree<>("right " + i));
                temp = RANDOM.nextBoolean() ? newLeft : newRight;
            } else {
                if (RANDOM.nextBoolean()) {
                    temp = temp.addLeft(new Tree<>("left " + i));
                } else {
                    temp = temp.addRight(new Tree<>("right " + i));
                }
            }
        }

        return tree;
    }
}

