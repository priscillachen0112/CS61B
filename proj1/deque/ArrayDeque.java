package deque;

import java.util.Iterator;

public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[10];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    /** Adds an item of type T to the front of the deque.
     * You can assume that item is never null. */
    public void addFirst(T item) {
        size += 1;
        items[nextFirst] = item;
        if (nextFirst - 1 == -1) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }


    /** Adds an item of type T to the back of the deque.
     * You can assume that item is never null. */
    public void addLast(T item) {
        size += 1;
        items[nextLast] = item;
        if (nextLast + 1 == items.length) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
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
        for (int i = nextFirst - 1; i <= nextLast - 1; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }


    /** Removes and returns the item at the front of the
     * deque. If no such item exists, returns null. */
    public T removeFirst() {
        T first = items[nextFirst];
        items[nextFirst] = null;
        return first;
    }


    /** Removes and returns the item at the back of the
     * deque. If no such item exists, returns null. */
    public T removeLast() {
        T last = items[nextLast];
        items[nextLast] = null;
        return last;
    }


    /** Gets the item at the given index, where 0 is the
     * front, 1 is the next item, and so forth. If no
     * such item exists, returns null. Must not alter the
     * deque! */
    public T get(int index) {
        return items[index];
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
        if (o instanceof ArrayDeque) {
            ArrayDeque<?> deque = (ArrayDeque<?>) o;
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
