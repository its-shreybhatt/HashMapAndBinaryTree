package HashMap;

public interface INode<K> {
    // methods for getter and setter
    K getKey();

    void setKey(K key);

    INode<K> getNext();

    void setNext(INode<K> next);
}
