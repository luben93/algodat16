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
    public void sorting() throws Exception {
        int size = (int) 1E4;
        int tries = 5;
        Integer[] arr = new Integer[size];//{3, 5, 8, 2, 7, 92, 5, 81, 52, 62, 72, 13, 53, 21, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(arr.length);
        }


        Integer[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        List<sort<Integer>> sorters = new ArrayList<>();


        sorters.add(new insert());
        sorters.add(new Selection());
        sorters.add(new bubblesort());
        sorters.add(new Shell());
        sorters.add(new merge());
        sorters.add(new heapsort<Integer>());
        sorters.add(new quicksort());

        for (sort<Integer> s : sorters) {
            s.sort(Arrays.copyOf(arr, arr.length));
            System.out.printf(s.toString());
            long tot = 0;
            for (int i = 0; i < tries; i++) {
                long time = System.nanoTime();
                assertEquals(sorted, s.sort(Arrays.copyOf(arr, arr.length)));
                tot += (System.nanoTime() - time);
            }
            System.out.println(" ok,\tAvg time: " + tot / (tries + 1000000) + "ms");

        }
        radixsort r = new radixsort();
        r.sort( Arrays.copyOf(Arrays.asList(arr).stream().mapToInt(Integer::intValue).toArray(), arr.length));
        System.out.printf(r.toString());
        long tot = 0;
        for (int i = 0; i < tries; i++) {
            long time = System.nanoTime();
            assertEquals(sorted, r.sort(Arrays.copyOf(Arrays.asList(arr).stream().mapToInt(Integer::intValue).toArray(), arr.length)));
            tot += (System.nanoTime() - time);
        }
        System.out.println(" ok,\tAvg time: " + tot / (tries + 1000000) + "ms");


    }
}