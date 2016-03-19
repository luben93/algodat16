package algoritms;

/**
 * Created by luben on 2016-03-16.
 */
public class GoFromWork {
    public static void main(String[] args){
        System.out.println(waysToGo(5,6));
    }

    public static int waysToGo(int h,int v){
        if(v==0&&h==0){
            return 1;
        }
        int n =0;
        if(h>0){
            n=waysToGo(h-1,v);
        }
        if(v>0){
            n+=waysToGo(h,v-1);
        }
        return n;
    }
}
