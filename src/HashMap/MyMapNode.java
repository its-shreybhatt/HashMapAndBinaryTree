package HashMap;

public class MyMapNode<K, V> implements INode<K> {
    private K key;
    private V value;
    private MyMapNode<K, V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    public INode<K> getNext() {
        return next;
    }

    public void setNext(INode<K> next) {
        this.next = (MyMapNode<K, V>) next;
    }

    @Override
    public String toString() {
        StringBuilder myMapNodeString = new StringBuilder();
        myMapNodeString.append("{Key= '").append(key)
                .append("' & value=").append(value).append("}");
        if (next != null) myMapNodeString.append(" -> ").append(next);
        return myMapNodeString.toString();
    }

}