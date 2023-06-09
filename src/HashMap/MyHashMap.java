package HashMap;

import java.util.ArrayList;

public class MyHashMap<K, V> {
    private final int numBuckets;
    private INode head;
    ArrayList<MyLinkedList<K>> myBucketArray;
    public MyHashMap() {
        this.numBuckets = 10;
        this.myBucketArray = new ArrayList<>(numBuckets);
        // Create empty LinkedList all index of array =null
        for (int i = 0; i < numBuckets; i++) {
            this.myBucketArray.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList =this.myBucketArray.get(index);
        if (myLinkedList == null) return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.searchNode(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList =this.myBucketArray.get(index);
        if (myLinkedList == null){
            myLinkedList = new MyLinkedList<>();
            this.myBucketArray.set(index,myLinkedList);
        }
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.searchNode(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.appendToLast(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }
    public INode remove(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList =this.myBucketArray.get(index);
        if (myLinkedList == null) return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.searchNode(key);
        INode tempNode = head;
        while (!tempNode.getNext().equals(myMapNode)) {
            tempNode = tempNode.getNext();
            break;
        }
        INode removedNode = tempNode.getNext();
        tempNode.setNext(null);
        return removedNode;
    }

    public String toString() {
        return "MyLinkedHashMap = { " + myBucketArray + " ";
    }
}
