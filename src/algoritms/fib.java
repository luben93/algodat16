package algoritms;

import java.util.concurrent.RecursiveAction;

/**
 * Created by luben on 2016-03-16.
 */
public class fib extends RecursiveAction {
    public static long fib(long n) {
        return fib(n, 3, 1, 1);
    }

    private static long fib(long n, long i, long a, long b) {
        if (i == n) {
            return a + b;
        }
        return fib(n, i + 1, b, a + b);
    }

    public static long fibBottom(long n,boolean thread) {
        if(!thread) {
            if (n <= 2) {
                return 1;
            }

            return fibBottom(n - 1,false) + fibBottom(n - 2,false);
        }else {
            fib f1 = new fib().setN(n - 1);
            fib f2 = new fib().setN(n - 2);
            f1.compute();
            f2.fork();
            f1.join();
            return f1.getOut()+f2.getOut();
        }
    }

    public static long itrFib(long n) {
        long fn = 1, a = 1, b = 1;
        for (long i = 3; i <= n; i++) {
            fn = a + b;
            a = b;
            b = fn;
        }
        return fn;
    }

    public static long ordOneFib(long num) {
//        num+=3;
        double phi= (1+Math.sqrt(5))/2;
        return((long)((Math.pow(phi,num)-Math.pow(1-phi,num))/Math.sqrt(5))); //finding fibonnaci number using formula.
    }

    private long N;

    public long getOut() {
        return out;
    }

    private long out;

    public fib setN(long n) {
        N = n;
        return this;
    }

    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
        out=fibBottom(N,N<=10);
    }
}
