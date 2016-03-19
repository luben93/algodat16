package lists;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by luben on 2016-03-16.
 */
public class BinSearchTree {
    public static void main(String[] args) {
        Integer[] a = new Integer[100];
        for (int i = 0; i < a.length; i++) {
            a[i]= (new Random().nextInt(100)+1);
        }
        a[43]=50;
        Arrays.sort(a);
        Arrays.asList(a).forEach(System.out::println);
        System.out.println("search "+binSearch(a,50));
    }


    public static int binSearch(Object[] arr, Comparable target) {
        return binSearch(arr, target, 0, arr.length - 1);
    }

    private static int binSearch(Object[] arr, Comparable target, int first, int last) {
        if (first > last) {
            return -1;
        }
        int mid=(last+first) / 2;
        int res = target.compareTo(arr[mid]);
        if (res==0) {
            return mid;
        } else if (res < 0) {
            return binSearch(arr, target, first,mid-1);
        } else {
            return binSearch(arr, target, mid+1, last);
        }

    }
}
