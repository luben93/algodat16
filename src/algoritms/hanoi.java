package algoritms;

/**
 * Created by luben on 2016-03-16.
 */
public class hanoi {
    public static void hanoi(int n,int f,int t,int x){
        if(n>0) {
            hanoi(n - 1, f,x,t);
            System.out.println(f+" -> "+t);
            hanoi(n - 1, x, t, f);
//            System.out.println(t+" -> "+x);

        }
    }
    public static void main(String[] args){
        hanoi(3,1,2,3);
    }
}
