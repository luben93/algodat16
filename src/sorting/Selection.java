package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class Selection<E extends Comparable<E>> {
    private E[] arr;

    public Selection(E[] arr) {
        this.arr = arr;
    }

    public void sort() {
        for (int index = 0; index < arr.length - 1; index++) {
            int min = index;
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i].compareTo(arr[min]) < 0) {
                    min = i;
                }

            }
            E tmp = arr[index];
            arr[index] = arr[min];
            arr[min] = tmp;
        }
    }
}
