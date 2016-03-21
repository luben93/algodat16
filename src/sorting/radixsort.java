package sorting;

/**
 * Created by luben on 2016-03-20.
 */
public class radixsort<E extends Comparable<E>> implements sort<E> {
    private E[] arr;

    public radixsort(E[] arr) {
        this.arr = arr;
    }

    @Override
    public E[] sort() {
        return arr;
    }
}
