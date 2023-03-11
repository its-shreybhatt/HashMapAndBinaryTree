package HashMap;

import HashMap.INode;

public class MyLinkedList<K> {
    // class to impliment logic

    private INode head;
    private INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToFront(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void appendToLast(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void insertMethodFirst(INode newNode) {
        INode tempNode = this.head.getNext();
        this.head.setNext(newNode);
        newNode.setNext(tail);
    }

    public void insertMethodSecond(INode firstNode, INode nextNode) {
        INode tempNode = firstNode.getNext();
        firstNode.setNext(nextNode);
        nextNode.setNext(tempNode);
    }

    public INode popFirstNode() {
        INode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode popLastNode() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        INode removedNode = tempNode.getNext();
        tempNode.setNext(null);
        return removedNode;
    }

    public INode searchNode(K key) {
        INode tempNode = head;
        while (tempNode != null ) {
            if (tempNode.getKey().equals(key)) {
                break;
            }
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public void insertAfterParticular(INode previousNode, INode newNode) {
        INode tempNode = previousNode.getNext();
        previousNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public INode deleteAfterParticular(INode previousNode, INode delNode) {
        INode tempNode = delNode.getNext();
        previousNode.setNext(tempNode);
        tempNode.setNext(null);
        return tempNode;
    }

    public void appendSort(INode previousNode, INode newNode) {
        if ((int) previousNode.getKey() < (int) newNode.getKey()) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My LinkedList Nodes : ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)) myNodes.append("-> ");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    @Override
    public String toString() {
        return "" + head +
                " }";
    }
}