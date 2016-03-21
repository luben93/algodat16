package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class Selection implements sort{

    public Comparable[] sort(Comparable[] arr) {
        for (int index = 0; index < arr.length - 1; index++) {
            int min = index;
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i].compareTo(arr[min]) < 0) {
                    min = i;
                }

            }
            Comparable tmp = arr[index];
            arr[index] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }
}
