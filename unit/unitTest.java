import org.testng.annotations.Test;
import sorting.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by luben on 2016-03-21.
 */
public class unitTest {
    @Test
    public void testName() throws Exception {
        Integer[] arr = new Integer[(int)1E4];//{3, 5, 8, 2, 7, 92, 5, 81, 52, 62, 72, 13, 53, 21, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[i]= new Random().nextInt(arr.length);
        }



        Integer[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        List<sort<Integer>> sorters = new ArrayList<>();


        sorters.add(new insert<Integer>(Arrays.copyOf(arr, arr.length)));
        sorters.add(new Selection<Integer>(Arrays.copyOf(arr, arr.length)));
        sorters.add(new bubblesort<Integer>(Arrays.copyOf(arr, arr.length)));
        sorters.add(new Shell<Integer>(Arrays.copyOf(arr, arr.length)));
        sorters.add(new merge<Integer>(Arrays.copyOf(arr, arr.length)));
        sorters.add(new heapsort<Integer>(Arrays.copyOf(arr, arr.length)));
        sorters.add(new quicksort<Integer>(Arrays.copyOf(arr, arr.length)));

        for (sort<Integer> s : sorters) {
            System.out.printf(s.toString());
            long time=System.nanoTime();
            assertEquals(sorted,s.sort());
            System.out.println(" ok, time: "+(System.nanoTime()-time)/100000+"ms");
        }

    }
}