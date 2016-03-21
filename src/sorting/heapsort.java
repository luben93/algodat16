package sorting;

import lists.heap;

/**
 * Created by luben on 2016-03-19.
 */
public class heapsort<E extends Comparable<E>> implements sort {
    private E[] arr;
    //    private E[] heap;
//    private int heapsize = 1;

    public heapsort(E[] a) {
        arr = a;
//        heap = (E[]) new Comparable[a.length];
    }

    @Override
    public E[] sort() {
        heap<E> myHeap=new heap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            //add(i);
            myHeap.add(arr[i]);
        }
        for (int i = arr.length; i > 0; ) {
//        for (int i = 0; i < arr.length; i++) {
            //arraySwap(0, --i);
            //remove(0, i);
            arr[--i]=myHeap.remove();
        }
        return arr;
    }


    private void add(int i) {
        if (i < 0) {
            return;
        }
        int p = (i - 1) / 2;
        if (arr[i].compareTo(arr[p]) < 0) {
            arraySwap(i, p);
            add(p);
        }
    }



    private void remove(int i, int heapsize) {
        int left = (i * 2) + 1;
        if (left >= heapsize) // node has no left child
            return; // reached the bottom; heap is heapified
        int right = left + 1;
        if (right >= heapsize) { // node has a left child, but no right child
            if (arr[left].compareTo(arr[i]) < 0) // if left child is greater than node
                arraySwap(left, i); // swap left child with node
            return; // heap is heapified
        }
        if (arr[left].compareTo(arr[i]) < 0) { // (left > n)
            if (arr[left].compareTo(arr[right]) < 0) { // (left > right) & (left > n)
                arraySwap(left, i);
                remove(left, heapsize);
            } else { // (right > left > n)
                arraySwap(right, i);
                remove(right, heapsize);
            }
        } else { // (n > left)
            if (arr[right].compareTo(arr[i]) < 0) { // (right > n > left)
                arraySwap(right, i);
                remove(right, heapsize);
            }
        }
    }


    public void arraySwap(int a, int b) {
        E tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }
}