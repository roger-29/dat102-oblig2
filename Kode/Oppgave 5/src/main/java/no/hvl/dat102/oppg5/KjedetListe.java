package no.hvl.dat102.oppg5;

import java.util.Iterator;

public abstract class KjedetListe<T> implements ListeADT<T>, Iterable<T>{

    protected int count;
    protected DoublyLinearNode<T> head, tail;
    protected int modCount;

    public KjedetListe() {
        count = modCount = 0;
        head = tail = null;
    }

    @Override
    public T removeFirst() {
        if (count == 0)
            throw new EmptyCollectionException("KjedetListe");

        T result = head.getElement();

        if (count == 1)
            head = tail = null;

        head = head.getNext();
        count--;
        modCount++;

        return result;
    }

    @Override
    public T removeLast() {
        if (count == 0)
            throw new EmptyCollectionException("KjedetListe");

        T result = tail.getElement();
        DoublyLinearNode<T> current = tail;
        DoublyLinearNode<T> previous = current.getPrevious();

        if(count == 1)
            head = tail = null;
        else {
            previous.setNext(null);
            current = null;
            tail = previous;
        }

        count--;
        modCount++;
        return result;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException{
        if(isEmpty())
            throw new EmptyCollectionException("KjedetListe");

        boolean found = false;
        DoublyLinearNode<T> previous = null;
        DoublyLinearNode<T> current = head;

        while ( current != null && !found) {
            if(element.equals(current.getElement()))
                found = true;
            else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found)
            throw new ElementNotFoundException("KjedetListe");

        if (size() == 1)
            head = tail = null;
        else if (current.equals(head))
            head = current.getNext();
        else if (current.equals(tail)) {
            tail = previous;
            tail.setNext(null);
        }
        else
            previous.setNext(current.getNext());
        count--;
        modCount++;

        return current.getElement();
    }

    @Override
    public T first() {
        return head.getElement();
    }

    @Override
    public T last() {
        return tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        DoublyLinearNode<T> current = head;
        boolean found = false;
        while(current != null && !found) {
            if(current.equals(target))
                found = true;
            else
                current = current.getNext();
        }

        return found;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {

        return null;
    }

    public String toString() {
        String string = "";
        DoublyLinearNode<T> temp = head;
        int scan = 0;
        while(scan < size()) {
            string += temp.getElement().toString() + "\n";
            temp = temp.getNext();
            scan++;
        }
        return string;
    }


}