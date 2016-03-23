package greedy;

import java.util.*;

/**
 * Created by luben on 3/23/16.
 */
public class knapsack {
    private Integer[] v ;//= {10, 3, 1};
    private Integer[] w ;//= {4, 2, 1};

    public static void main(String[] args) {
         Integer[] v = {10, 3, 1};
         Integer[] w = {4, 2, 1};

        new knapsack(v,w).sack(15).forEach((o) -> System.out.println(v[o]));
    }

    public knapsack(Integer[] v, Integer[] w) {
        this.v = v;
        this.w = w;
    }

    public knapsack() {

    }
q

    private  List<Integer> sack( int maxW) {
        List<Integer> sack = new ArrayList<>();
        int currentW = 0;
        //if (0 <= i) {
            for (int j = 0; j < w.length; j++) {
                while (currentW + w[j] <= maxW) {
                   // System.out.println("im alive");//TODO räkna själv
                    sack.add(j);
                    currentW += w[j];
                }
            }
        //}
        return sack;
    }


    private boolean higher(List<Integer> back, List<Integer> sack) {
        int highBack = 0, highSack = 0;
        for (int b : back) {
            highBack += v[b];
        }
        for (int b : sack) {
            highSack += v[b];
        }
        return highBack > highSack;
    }


}
