package sorting;

/**
 * Created by luben on 2016-03-19.
 */
public class insert implements sort {

    @Override
    public Comparable[] sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable data = arr[i];
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
