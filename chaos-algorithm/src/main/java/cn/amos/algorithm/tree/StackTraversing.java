package cn.amos.algorithm.tree;

import java.util.Random;
import java.util.Stack;

/**
 * NOTE: 简单二叉树初始化以及栈方式进行遍历
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/9
 */
public class StackTraversing {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // 初始化树
        Tree<String> tree = simpleTree();
        printTreeNodeEnd(tree);
    }

    /**
     * 先序遍历,递归遍历
     */
    private static void printTreeNodePre(Tree<String> node) {
        if (node == null) {
            return;
        }
        Stack<Tree<String>> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            Tree<String> popNode = stack.pop();
            System.out.println(popNode.toString());
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
        }
    }

    /**
     * 中序遍历,递归遍历
     */
    private static void printTreeNodeCenter(Tree<String> node) {
        if (node == null) {
            return;
        }
        Stack<Tree<String>> stack = new Stack<>();
        Tree<String> tempNode = node;

        while (tempNode != null || !stack.empty()) {
            if (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
                continue;
            }
            Tree<String> popNode = stack.pop();
            System.out.println(popNode.toString());
            tempNode = popNode.right;
        }
    }

    /**
     * 后序遍历,递归遍历
     * 先序遍历右节点优先,再逆序
     */
    private static void printTreeNodeEnd(Tree<String> node) {
        if (node == null) {
            return;
        }
        Stack<Tree<String>> stack = new Stack<>();
        Stack<Tree<String>> finalStack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            Tree<String> popNode = stack.pop();
            finalStack.push(popNode);
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
        }

        while (!finalStack.empty()) {
            System.out.println(finalStack.pop());
        }
    }

    private static Tree<String> simpleTree() {
        // 生成简单树
        Tree<String> tree = new Tree<>("A");
        // 根节点左右节点
        Tree<String> treeLeft1 = tree.addLeft(new Tree<>("B"));
        Tree<String> treeRight1 = tree.addRight(new Tree<>("C"));
        // 给左节点添加左右节点
        treeLeft1.addLeft(new Tree<>("D"));
        treeLeft1.addRight(new Tree<>("E"));
        // 给右节点添加左右节点
        treeRight1.addLeft(new Tree<>("F"));
        treeRight1.addRight(new Tree<>("G"));

        return tree;
    }
}

