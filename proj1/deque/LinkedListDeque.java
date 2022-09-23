package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T> {
    private static class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;

        public Node(T i, Node<T> nxt, Node<T> prv) {
            item = i;
            next = nxt;
            prev = prv;
        }
    }

    private Node<T> sentinel;
    private int size;

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Node<T>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    /** Adds an item of type T to the front of the deque.
     * You can assume that item is never null. */
    public void addFirst(T item) {
        sentinel.next = new Node<T>(item, sentinel.next, sentinel);
        size += 1;
    }


    /** Adds an item of type T to the back of the deque.
     * You can assume that item is never null. */
    public void addLast(T item) {
        Node<T> last = new Node<T>(item, sentinel, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }


    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }


    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }


    /** Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been
     * printed, print out a new line. */
    public void printDeque() {
        Node<T> p = sentinel;

        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }

        System.out.println();
    }


    /** Removes and returns the item at the front of the
     * deque. If no such item exists, returns null. */
    public T removeFirst() {
        Node<T> first = sentinel.next;
        sentinel.next = sentinel.next.next;
        if (size >= 1) {
            size -= 1;
        }
        return first.item;
    }


    /** Removes and returns the item at the back of the
     * deque. If no such item exists, returns null. */
    public T removeLast() {
        Node<T> last = sentinel.prev;
        Node<T> secondLast = sentinel.prev.prev;
        sentinel.prev = secondLast;
        secondLast.next = sentinel;
        if (size > 1) {
            size -= 1;
        }
        return last.item;
    }


    /** Gets the item at the given index, where 0 is the
     * front, 1 is the next item, and so forth. If no
     * such item exists, returns null. Must not alter the
     * deque! */
    public T get(int index) {
        int i = 0;
        Node<T> p = sentinel;
        while (i < index) {
            p = p.next;
            i += 1;
        }
        return p.next.item;
    }


    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        Node<T> p = sentinel.next;
        return getRecursiveHelper(p, index);
    }


    public T getRecursiveHelper(Node<T> start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelper(start.next, index - 1);
        }
    }


    /** The deque objects we'll make are iterable (i.e.
     * Iterable<T>) so we must provide this method to
     * return an iterator. */
    public Iterator<T> iterator() {
        return iterator();
    }


    /** Returns whether or not the parameter o is equal
     * to the Deque. o is considered equal if it is a Deque
     * and if it contains the same contents (as governed
     * by the generic T's equals method) in the same order. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<?> deque = (LinkedListDeque<?>) o;
            if (this.size != deque.size) {
                return false;
            }
            int i = 0;
            while (i < size) {
                if (!this.get(i).equals(deque.get(i))) {
                    return false;
                }
                i += 1;
            }
            return true;
        } else {
            return false;
        }
    }
}
