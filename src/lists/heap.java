package lists;

/**
 * Created by luben on 2016-03-19.
 */
public class heap<E extends Comparable<E>> {
    public heap(int size) {
        arr = (E[]) new Comparable[size];
    }

    private E[] arr;

    public void add(E element) {
        int i = 0;
        while (arr[i] != null) {
            i++;
        }
        arr[i] = element;
//        System.out.println("addi "+i+" ");

        while (i > 0) {
//            System.out.printf(i+" ");
            if (arr[(i - 1) / 2].compareTo(arr[i]) < 0) {
                E tmp = arr[(i - 1) / 2];
                arr[(i - 1) / 2] = arr[i];
                arr[i] = tmp;
                i = (i - 1) / 2;
            }else {
                break;
            }
        }
    }

    public Comparable remove() {
        int n = 0;
        E out = arr[n];
        int heapsize = arr.length - 1;
        while (arr[heapsize] == null && heapsize > n) {
            heapsize--;
        }

        arr[n] = arr[heapsize];
        arr[heapsize] = null;

        while (n + n + 1 < heapsize ){ //&& arr[n].compareTo(arr[n * n + 1]) < 0&& arr[n].compareTo(arr[n * n + 1 + 1]) < 0) {
            int l = n + n + 1, r = l + 1;
            if (r >= heapsize) {
                if (arr[l].compareTo(arr[n]) > 0) {//one child
                    arraySwap(l, n);
                }
                break;
            }
            if (arr[l].compareTo(arr[n]) > 0) {//check left and right
                if (arr[l].compareTo(arr[r]) > 0) {//left
                    arraySwap(l, n);
                    n = l;
                } else {
                    arraySwap(r, n);
                    n = r;
                }
            } else {
                if (arr[r].compareTo(arr[n]) > 0) {//right only
                    arraySwap(r, n);
                    n = r;
                }else {
                    break;
                }
            }

        }
//        System.out.println("n " + n + " size " + heapsize);

        return out;
    }


    private void arraySwap(int a, int b) {
        E tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }
}
