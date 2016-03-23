package algoritms;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Created by luben on 3/22/16.
 */
public class dijkstras {
    private static int o = Integer.MAX_VALUE;//sätt T=V i main
    private static int[][] w = {//för alla bla = bla = infi
            {o, 2, o, o, o, 1, o, o}, //a
            {2, o, 2, 2, 4, o, o, o}, //b
            {o, 2, o, o, 3, o, o, 1}, //c
            {o, 2, o, o, 3, 1, o, o}, //d
            {o, 4, 3, 3, o, o, 7, o}, //e
            {1, o, o, 1, o, o, 5, o}, //f
            {o, o, o, o, 7, 5, o, 6}, //g
            {o, o, 1, o, o, o, 6, o}  //h
    };

    public static void main(String[] args){
        for (int[] a:w) {
            for (int b:a) {
                String out = b + "";
                if (b == o) {
                    out = " ";
                }
                System.out.printf(out + " ");
            }
            System.out.println("");
        }
        System.out.println("--------------");
        recurse();


    }

    private static void recurse(){
        int[] d={0,o,o,o,o,o,o,o};
        int[] p=new int[8];
        boolean[] taken=new boolean[8];
        for (boolean b:taken){
            b=false;
        }

        for (int i = 0; i < d.length; i++) {
            int u= next(d,taken);
            taken[u]=true;
            for (int j = 0; j < w[u].length; j++) {
                if(w[u][j]<o&& d[j]>d[u]+w[u][j]){
                    d[j]=d[u]+w[u][j];
                    p[j]=u;
                }
            }
        }
        for (int i = 1; i < d.length; i++) {
            System.out.println("node "+(char)('A'+i)+" distance "+d[i]+" to A by "+(char)(p[i]+'A'));
        }
    }

    private static int next(int[] i,boolean[]b){
        int low=o,lowi=0;
        for (int j = 0; j < i.length; j++) {
            if(!b[j]){
                if(low>i[j]){
                    low=i[j];
                    lowi=j;
                }
            }
        }
        return lowi;
    }
}
