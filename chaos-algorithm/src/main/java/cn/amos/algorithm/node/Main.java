package cn.amos.algorithm.node;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/8
 */
public class Main {

    public static void main(String[] args) {
        Node<String, String> node = new Node<>("initKey", "initValue");
        Node<String, String> temp = node;
        for (int i = 0; i < 10; i++) {
            temp = temp.setNext(new Node<>("key " + i, "val " + i));
        }
        System.out.println(node.toString());
    }
}

class Node<K, V> {

    final K key;
    
    V value;

    Node<K, V> next;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    Node<K, V> setNext(Node<K, V> next) {
        this.next = next;
        return next;
    }
}