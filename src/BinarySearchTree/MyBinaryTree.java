package BinarySearchTree;

public class MyBinaryTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0) return current;
        if (compareResult < 0) {
            current.left = addRecursively(current.left, key);
        } else {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    public int getsize() {
        return this.getSizeRecursively(root);
    }

    private int getSizeRecursively(MyBinaryNode<K> current) {
        return current == null ? 0 : 1 + this.getSizeRecursively(current.left)
                + this.getSizeRecursively(current.right);
    }

    public void search(K key) {
        this.searchRecursively(root, key);
    }

    private MyBinaryNode<K> searchRecursively(MyBinaryNode<K> current, K key) {
        if (current != null) {
            int compareResult = key.compareTo(current.key);
            if (compareResult == 0) System.out.println("Key is Present");
            if (compareResult < 0) {
                current.left = searchRecursively(current.left, key);
            } else if (compareResult > 0) {
                current.right = searchRecursively(current.right, key);
            }
        } else System.out.println("Key Not present");
        return current;
    }
}