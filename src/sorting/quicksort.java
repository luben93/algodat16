package sorting;

/**
 * Created by luben on 2016-03-20.
 */
public class quicksort  implements sort {

    private Comparable[] arr;

    @Override
    public Comparable[] sort(Comparable[] arr) {
        this.arr=arr;
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
        Comparable pivot = arr[p];
        int i = lo;
        for (int j = lo; j < hi ; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                Comparable tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }
        Comparable t = arr[p];
        arr[p] = arr[i];
        arr[i] = t;
        return i;
    }
}
