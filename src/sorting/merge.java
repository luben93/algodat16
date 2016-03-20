package sorting;

import java.util.Arrays;

/**
 * Created by luben on 2016-03-19.
 */
public class merge<E extends Comparable<E>> implements sort {
    private E[] arr;

    public merge(E[] arr) {
        this.arr = arr;
    }

    @Override
    public E[] sort() {
        mergeSort(arr);
        return arr;
    }

    private void mergeSort(E[] a) {
        if (a.length == 1) {
            return;
        }
        E[] b = Arrays.copyOf(a,( a.length / 2));
        E[] c = Arrays.copyOfRange(a, (a.length / 2) , a.length);
        mergeSort(b);
        mergeSort(c);
        merge(b, c, a);
        return;
    }

    private void merge(E[] a, E[] b, E[] c) {
        int indexa = 0, indexb = 0, indexc = 0;
        while (indexa < a.length && indexb < b.length) {
            if (a[indexa].compareTo(b[indexb]) <= 0) {
                c[indexc++] = a[indexa++];
//                indexa++;
            } else {
                c[indexc++] = b[indexb++];
//                indexb++;
            }
        }
        while (indexa < a.length) {
            c[indexc++] = a[indexa++];
//            indexa++;
        }
        while (indexb < b.length) {
            c[indexc++] = b[indexb++];
//            indexb++;
        }
    }
}

