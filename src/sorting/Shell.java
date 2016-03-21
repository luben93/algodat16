package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class Shell implements sort {

    @Override
    public Comparable[] sort(Comparable[] arr) {
        for (int gap = arr.length; gap >0; gap=gap==2?1:(int)(gap/2.2)) {
            for (int i = gap; i < arr.length; i++) {
                Comparable tmp=arr[i];
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
