package cn.amos.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * NOTE: 简单二叉树初始化以及遍历
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/9
 */
public class SimpleTreeDemo {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // 初始化树
        Tree<String> tree = generateRandomTree();
        Tree<String> tempTree = tree;

        // 树的所有节点
        List<Tree<String>> treeNodeList = new ArrayList<>();
        List<Tree<String>> tempArray = new ArrayList<>();
        tempArray.add(tree);

        while (true) {
            System.out.println(tempTree);
            treeNodeList.add(tempTree);

            if (tempTree.left != null) {
                tempArray.add(tempTree.left);
                tempTree = tempTree.left;
                continue;
            }
            if (tempTree.right != null) {
                tempArray.add(tempTree.right);
                tempTree = tempTree.right;
                continue;
            }

            for (int i = tempArray.size() - 2; i >= 0; i--) {
                tempTree = tempArray.get(i);
                if (tempTree.right == null) {
                    continue;
                }
                break;
            }

            if (tempTree.right != null) {
                tempArray.remove(tempArray.size() - 2);
                tempArray.remove(tempArray.size() - 1);
                tempArray.add(tempTree.right);
                tempTree = tempTree.right;
                continue;
            }

            break;
        }

        System.out.println(treeNodeList.size());
        System.out.println(treeNodeList.toString());
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
        // 生成一棵随机树
        Tree<String> tree = new Tree<>("root");
        Tree<String> temp = tree;

        for (int i = 0; i < 10; i++) {
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

