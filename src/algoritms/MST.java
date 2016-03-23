package algoritms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luben on 3/22/16.
 */
public class MST{

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

    private static int[] node=new int[8];

    public static void main(String[] args){
        //int[] tree={0,o,o,o,o,o,o,o};
        //tree[0]=0;
       // boolean done=false;
        List<Integer> tree=new ArrayList<>();
        tree.add(0);
        //while(tree.size()<8){
        lowest(tree);
        tree.remove(0);
        tree.forEach((o1) -> System.out.println((char) (o1+'a')+" via "+(char)(node[o1]+'a')));
        //}

    }

    private static void lowest(List<Integer> tree){
        if(tree.size()>=8){
            return;
        }
        int lowest=o,lowestI=-1;
        for (int n:tree) {
            for (int i = 0; i < w[n].length; i++) {
                if(lowest>w[n][i]&&!tree.contains(i)){
                    lowest=w[n][i];
                    lowestI=i;
                    node[i]=n;
                }
            }
        }
        tree.add(lowestI);
        lowest(tree);
    }

}