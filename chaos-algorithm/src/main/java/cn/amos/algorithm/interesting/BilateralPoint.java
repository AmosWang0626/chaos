package cn.amos.algorithm.interesting;

import java.util.ArrayList;

/**
 * NOTE: 在不知道一个List的length的情况下获得其倒数第三个数
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/8
 */
public class BilateralPoint {

    public static void main(String[] args) {
        Node node = new Node(0, "First");
        Node temp = node;
        for (int i = 1; i < 10; i++) {
            temp = temp.add(new Node(i, "val " + i));
        }

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; node != null; i++, node = node.getNext()) {
            list.add(node);
            if (node.getNext() == null) {
                System.out.println(list.get(i - 3));
            }
        }
    }
}

class Node {
    private int index;
    private String value;

    private Node next;

    Node(int index, String value) {
        this.index = index;
        this.value = value;
    }

    Node getNext() {
        return next;
    }

    Node add(Node next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", value='" + value + '\'' +
                '}';
    }
}