package sorting;

import java.util.Arrays;

/**
 * Created by luben on 2016-03-19.
 */
public class main {
    public static void main(String[] args){
        Integer[] arr= {3,5,8,2,7,92,5,81,52,62,72,13,53,21,1};
        Integer[] copy=Arrays.copyOf(arr,arr.length);
        new Selection<Integer>(copy).sort();

        System.out.println("selection ");
        Arrays.asList(copy).forEach(System.out::println);
    }
}
