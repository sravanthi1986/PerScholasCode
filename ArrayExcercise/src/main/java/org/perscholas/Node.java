package org.perscholas;

public class Node {
    
    public static final Node NIL = null;
    private Object value;
    private Node nextNode;
    public Node(Object value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
    public Object getValue() {
        return this.value;
    }
    public Node getNext() {
        return this.nextNode;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }
}
