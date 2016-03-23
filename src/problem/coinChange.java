package problem;

import java.util.*;

/**
 * Created by luben on 3/23/16.
 */
public class coinChange {
    private static Integer[] v= {500,200,100,50,20,10,5,1};
    //private static List<Integer> values= new ArrayList<>();
    public static Integer[] Change(int x,int i,Integer[] values) {
        if(i>v.length-1){
            return values;
        }
        //if(x<v[i]) {
            values[i]=(x/v[i]);
        //}else{
            //values[i]=(0);
        //}

        return Change(x%v[i],++i,values);
    }
}
