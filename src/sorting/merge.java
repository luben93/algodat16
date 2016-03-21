package sorting;

import java.util.Arrays;

/**
 * Created by luben on 2016-03-19.
 */
public class merge implements sort {

    @Override
    public Comparable[] sort(Comparable[] arr) {
        mergeSort(arr);
        return arr;
    }

    private void mergeSort(Comparable[] a) {
        if (a.length == 1) {
            return;
        }
        Comparable[] b = Arrays.copyOf(a,( a.length / 2));
        Comparable[] c = Arrays.copyOfRange(a, (a.length / 2) , a.length);
        mergeSort(b);
        mergeSort(c);
        merge(b, c, a);
        return;
    }

    private void merge(Comparable[] a, Comparable[] b, Comparable[] c) {
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

