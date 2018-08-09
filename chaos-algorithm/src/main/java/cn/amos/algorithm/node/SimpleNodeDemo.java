package cn.amos.algorithm.node;

/**
 * NOTE: 简单链表demo
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/8
 */
public class SimpleNodeDemo {

    public static void main(String[] args) {
        Node<String> node = new Node<>("head");
        Node<String> temp = node;
        for (int i = 0; i < 10; i++) {
            temp = temp.add(new Node<>("data " + i));
        }

        int i = 0;
        while (node.next != null) {
            // 添加节点
            if (++i == 3) {
                Node<String> insert = new Node<>("insert " + i);
                insert.next = node.next;
                node.next = insert;
            }
            // 删除节点
            if (i == 5) {
                node.next = node.next.next;
            }
            System.out.println(node.next);
            node = node.next;
        }
    }
}