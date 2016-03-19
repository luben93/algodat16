package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class Shell<E extends Comparable<E>> implements sort {
    private E[] arr;

    public Shell(E[] arr) {
        this.arr = arr;
    }

    @Override
    public E[] sort() {
        for (int gap = arr.length; gap >0; gap=gap==2?1:(int)(gap/2.2)) {
            for (int i = gap; i < arr.length; i++) {
                E tmp=arr[i];
                int j=i;
                for (; j >= gap && tmp.compareTo(arr[j-gap])<0; j -= gap) {
                    arr[j]=arr[j-gap];
                }
                arr[j]=tmp;
            }
        }

        return arr;
    }
}
