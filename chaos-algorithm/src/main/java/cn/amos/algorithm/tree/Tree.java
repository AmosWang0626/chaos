package cn.amos.algorithm.tree;

/**
 * NOTE: 树节点
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/9
 */
class Tree<D> {
    private D data;

    Tree<D> left;
    Tree<D> right;

    Tree(D data) {
        this.data = data;
    }

    Tree<D> addLeft(Tree<D> left) {
        this.left = left;
        return left;
    }

    Tree<D> addRight(Tree<D> right) {
        this.right = right;
        return right;
    }

    @Override
    public String toString() {
        return "Tree{" + "data=" + data + '}';
    }
}
