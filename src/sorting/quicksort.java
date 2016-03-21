package sorting;

/**
 * Created by luben on 2016-03-20.
 */
public class quicksort<E extends Comparable<E>> implements sort<E> {
    private E[] arr;

    public quicksort(E[] arr) {
        this.arr = arr;
    }

    @Override
    public E[] sort() {
        quicksort(0, arr.length - 1);
        return arr;
    }

    private void quicksort(int lo, int hi) {
        if (lo < hi) {
            int pivot = part(lo, hi);
            quicksort(lo, pivot - 1);
            quicksort(pivot + 1, hi);
        }
    }

    private int part(int lo, int hi) {
        int p=hi;
        E pivot = arr[p];
        int i = lo;
        for (int j = lo; j < hi ; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                E tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }
        E t = arr[p];
        arr[p] = arr[i];
        arr[i] = t;
        return i;
    }
}
