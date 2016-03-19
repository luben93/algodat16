package lists;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by luben on 2016-03-16.
 */
public class que<E> extends AbstractQueue<E> implements Iterable<E> {
    private int first = 0, last = 0;
    private E[] list = (E[]) new Object[10];

    private void reallocate() {
        E[] tmp = (E[]) new Object[list.length * 2];
        int s =size()-1;
        for (int i = 0; i < s ; i++) {
            tmp[i] = poll();
        }
        list = tmp;
        first = 0;
        last = size();

    }

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int i = first;

            @Override
            public boolean hasNext() {
                return i < last;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return list[(i++) % list.length];
            }
        };
    }

    @Override
    public int size() {//TODO kolla vad som händer efter bara offers
        int tmp = last;
        if (tmp < first) {
            tmp += list.length + 1;
        }
        return tmp - first;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param o the element to add
     * @return {@code true} if the element was added to this queue, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this queue
     * @throws NullPointerException     if the specified element is null and
     *                                  this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *                                  prevents it from being added to this queue
     */
    @Override
    public boolean offer(E o) {
        if (size() == list.length) {
            reallocate();
        }
        list[(last++) % list.length] = o;

        return true;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
        return list[first++ % list.length + 1];
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E peek() {
        return list[first];
    }


}
