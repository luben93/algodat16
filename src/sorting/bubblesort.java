package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class bubblesort implements sort {

    public Comparable[] sort(Comparable[] arr) {

        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i + 1].compareTo(arr[i]) < 0) {
                    Comparable tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        return arr;
    }

}
