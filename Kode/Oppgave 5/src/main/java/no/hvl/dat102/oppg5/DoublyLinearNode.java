package no.hvl.dat102.oppg5;

public class DoublyLinearNode<T> {

    private T element;
    private DoublyLinearNode<T> next;
    private DoublyLinearNode<T> previous;

    public DoublyLinearNode() {
        this(null);
    }

    public DoublyLinearNode(T element) {
        next = previous = null;
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setNext(DoublyLinearNode<T> n) {
        next = n;
    }

    public DoublyLinearNode<T> getNext() {
        return next;
    }

    public void setPrevious(DoublyLinearNode<T> p) {
        previous = p;
    }

    public DoublyLinearNode<T> getPrevious() {
        return previous;
    }

}
