package deque;

import java.util.Iterator;

public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    private int minusOne(int index) {
        if (index == 0) {
            index = items.length - 1;
        } else {
            index -= 1;
        }
        return index;
    }


    private int plusOne(int index) {
        if (index + 1 == items.length) {
            index = 0;
        } else {
            index += 1;
        }
        return index;
    }


    /** Adds an item of type T to the front of the deque.
     * You can assume that item is never null. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }


    /** Adds an item of type T to the back of the deque.
     * You can assume that item is never null. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast);
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
        int currentFirst = plusOne(nextFirst);
        int currentLast = minusOne(nextLast);
        for (int i = currentFirst; i <= currentLast; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }


    /** Removes and returns the item at the front of the
     * deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (size > 0) {
            size -= 1;
        }
        if ((size < items.length / 4) && (size > 4)) {
            resize(items.length / 4);
        }
        int currentFirst = plusOne(nextFirst);
        T first = items[currentFirst];
        items[currentFirst] = null;
        nextFirst = currentFirst;
        return first;
    }


    /** Removes and returns the item at the back of the
     * deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size > 0) {
            size -= 1;
        }
        if ((size < items.length / 4) && (size > 4)) {
            resize(items.length / 4);
        }
        int currentLast = minusOne(nextLast);
        T last = items[currentLast];
        items[currentLast] = null;
        nextLast = currentLast;
        return last;
    }


    /** Gets the item at the given index, where 0 is the
     * front, 1 is the next item, and so forth. If no
     * such item exists, returns null. Must not alter the
     * deque! */
    public T get(int index) {
        int currentFirst = plusOne(nextFirst);
        int itemsIndex = currentFirst + index;
        return items[itemsIndex];
    }


    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int currentFirst = plusOne(nextFirst);
        int currentLast = minusOne(nextLast);
        for (int i = items.length - 1; i >= currentFirst; i -= 1) {
            a[i + items.length] = items[i];
        }
        for (int i = 0; i <= currentLast; i += 1) {
            a[i] = items[i];
        }
        nextFirst = currentFirst + items.length - 1;
        items = a;
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
