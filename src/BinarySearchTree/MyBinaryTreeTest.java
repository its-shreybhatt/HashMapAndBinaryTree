package BinarySearchTree;

public class MyBinaryTreeTest {
    public static void main(String[] args) {
        MyBinaryTree<Integer> myBinaryTree = new MyBinaryTree<>();
        myBinaryTree.add(56);
        myBinaryTree.add(30);
        myBinaryTree.add(70);
        int size = myBinaryTree.getsize();
        System.out.println("Total num of Nodes = " + size);
    }
}
