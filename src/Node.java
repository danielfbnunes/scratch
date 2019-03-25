import java.util.ArrayList;
import java.util.List;

public class Node<K, V> {
    private List<Node<K, V>> children = new ArrayList<Node<K, V>>();
    private Node<K, V> parent = null;
    private K id = null;
    private V data = null;

    public Node(K id, V data) {
        this.id = id;
        this.data = data;
    }

    public Node(K id, V data, Node<K, V> parent) {
        this.id = id;
        this.data = data;
        this.parent = parent;
    }

    public List<Node<K, V>> getChildren() {
        return children;
    }

    public void setParent(Node<K, V> parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(K id, V data) {
        Node<K, V> child = new Node<K, V>(id, data);
        child.parent = this;
        this.children.add(child);
    }

    public void addChild(Node<K, V> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public K getID() {
        return this.id;
    }

    public V getData() {
        return this.data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

}
