package algoritms;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by luben on 2016-03-16.
 */
public class LustigaHissen {

    private int pos, nResor;

    public LustigaHissen(int pos, int nResor) {
        this.pos = pos;
        this.nResor = nResor;
    }

    public static int antalHissBredd(int n, int upp, int ned, int destination) {
//        return antalResorHiss(n, upp, ned, 1, destination, 0, new ArrayDeque<>());
        Queue<LustigaHissen> q= new ArrayDeque<>();
        LustigaHissen l = new LustigaHissen(1,0);
        while(l.pos!=destination){
            if(l.pos+upp<=n){
                q.offer(new LustigaHissen(l.pos+upp,l.nResor+1));
            }
            if(l.pos-ned>=1){
                q.offer(new LustigaHissen(l.pos-ned,l.nResor+1));
            }
            l=q.poll();
        }
        return l.nResor;
    }


    public static int antalResorHiss(int n, int upp, int ned, int postition, int destination, int antalResor, Queue<LustigaHissen> que) {
        if (postition == destination) {
            return antalResor;
        }
        if (antalResor > 30) {
            return Integer.MAX_VALUE;
        }
        int antalupp = Integer.MAX_VALUE, antalNed = antalupp;
        if (postition + upp <= n) {
            if (que != null) {
//                System.out.printf("que up ");

                que.offer(new LustigaHissen(postition+upp,antalResor+1));
                antalupp = antalResorHiss(n, upp, ned, que.peek().pos, destination, que.poll().nResor, que);
            } else {
                antalupp = antalResorHiss(n, upp, ned, postition + upp, destination, antalResor + 1, null);
            }
        }
        if (postition - ned >= 1) {
            if (que != null) {
//                System.out.printf("que down ");
                que.offer(new LustigaHissen(postition-ned,antalResor+1));
                antalNed = antalResorHiss(n, upp, ned, que.peek().pos, destination, que.poll().nResor, que);
            } else {
                antalNed = antalResorHiss(n, upp, ned, postition - ned, destination, antalResor + 1, null);
            }
        }
//        System.out.println("antal resor"+antalResor);
        return Math.min(antalNed, antalupp);

    }

    public static int antalResorHiss(int n, int upp, int ned, int destination) {
        return antalResorHiss(n, upp, ned, 1, destination, 0, null);
    }


}
