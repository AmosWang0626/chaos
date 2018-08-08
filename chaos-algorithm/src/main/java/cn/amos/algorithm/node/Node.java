package cn.amos.algorithm.node;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/8
 */
public class Node<K, V> {

    final K key;
    V value;

    Node<K, V> next;

    Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;

        return oldValue;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public Node<K, V> setNext(Node<K, V> next) {
        Node<K, V> oldNext = this.next;
        this.next = next;

        return oldNext.getNext();
    }
}
