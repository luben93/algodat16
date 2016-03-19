package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class bubblesort<E extends Comparable<E>> implements sort {
    private E[] arr;

    public bubblesort(E[] arr) {
        this.arr = arr;
    }

    @Override
    public E[] sort() {
        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i + 1].compareTo(arr[i]) < 0) {
                    E tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        return arr;
    }
}
