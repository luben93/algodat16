package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class insert<E extends Comparable<E>> implements sort {
    private E[] arr;

    public insert(E[] arr) {
        this.arr = arr;
    }

    @Override
    public E[] sort() {
        for (int i = 1; i < arr.length; i++) {
            E data = arr[i];
            int dataIndex=i;
            while(dataIndex>0 && data.compareTo(arr[dataIndex-1])<0){
                arr[dataIndex]=arr[dataIndex-1];
                dataIndex--;
            }
            arr[dataIndex]=data;
        }
        return arr;
    }
}
