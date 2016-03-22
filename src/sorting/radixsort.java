package sorting;

/**
 * Created by luben on 2016-03-20.
 */
public class radixsort {

    public int[] sort(int[] n) {
        int[][] np = new int[n.length][2];
        int[] q = new int[0x100];
        int i,j,k,l,f = 0;
        for(k=0;k<4;k++)
        {
            for(i=0;i<(np.length-1);i++)
                np[i][1] = i+1;
            np[i][1] = -1;
            for(i=0;i<q.length;i++)
                q[i] = -1;
            for(f=i=0;i<n.length;i++){
                j=((0xFF<<(k<<3))&n[i])>>(k<<3);
                if(q[j]==-1)
                    l=q[j]=f;
                else
                {
                    l=q[j];
                    while(np[l][1]!=-1)
                        l=np[l][1];
                    np[l][1]=f;
                    l=np[l][1];
                }
                f = np[f][1];
                np[l][0]=n[i];
                np[l][1]=-1;
            }
            for(l=q[i=j=0];i<0x100;i++)
                for(l=q[i];l!=-1;l=np[l][1])
                    n[j++]=np[l][0];
        }

//        int size = arr.length, i,l,j;
//        int[] np1 = new int[size];
//        int[] np0 = new int[size];
//        int[] q = new int[0x100];
//        for (int k = 0; k < 4; k++) {
//            for (i = 0; i < size-1; i++) {
//                np1[i] = i + 1;
//            }
//            np1[i] = i - 1;
//            for (i = 0; i < q.length; i++) {
//                q[i] = -1;
//            }
//            for (int f = i = 0; i < size; i++) {
//                j=((0xFF<<(k<<3))&arr[i])>>(k<<3);
//                if(q[j]==-1){
//                    l=q[j]=f;
//                }else{
//                    l=q[j];
//                    while (np1[l]!=-1){
//                        l=np1[l];
//                        np1[l]=f;
//                        l=np1[l];
//                    }
//                    f=np1[f];
//                    np0[l]=arr[i];
//                    np1[l]=-1;
//                }
//
//            }
//            for (l = q[i = j = 0]; i < 0x100; i++) {
//                for (l = q[i]; l != -1; l = np1[l]) {
//                    arr[j++] = np0[l];
//                }
//
//            }
//        }

        return n;
    }
}
