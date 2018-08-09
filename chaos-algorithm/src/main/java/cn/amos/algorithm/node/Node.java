package cn.amos.algorithm.node;

/**
 * NOTE: 链表节点
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/9
 */
class Node<D> {

    private final D data;

    Node<D> next;

    Node(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }

    Node<D> add(Node<D> next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
