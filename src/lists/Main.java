package lists;

import algoritms.LustigaHissen;
import algoritms.fib;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        mList<String> arr = new mArray<String>();
        arr.add("hej");
        arr.add("på");
        arr.add("dig");
        arr.forEach(System.out::println);

        System.out.println(arr.get(2) + arr.remove(0) + arr.get(0));
        arr = new LinkList<>();
        arr.add("link list");
        arr.add("yooyoyy");
        arr.forEach(System.out::println);
        que<String> que = new que<>();
        que.offer("hej");
        que.offer("på");
        que.offer("dig");
        que.offer("hej");
        que.offer("på");
        que.offer("dig");
        que.offer("hej");
        que.offer("på");
        que.offer("dig");
        que.offer("hej");
        que.offer("på");
        que.offer("dig");
        que.offer("hej");
        que.offer("på");
//        que.forEach(s -> System.out.println(que.poll()));

        que.offer("dig");
        que.offer("hej");
        que.offer("på");
        que.offer("dig");
        System.out.println(que.size());
//        que.parallelStream().filter(Predicate.isEqual("hej")).forEach(s1 -> System.out.println(s1));
        int n = 50;
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println(fib.fib(n));
        System.out.println(fib.itrFib(n));
        System.out.println(fib.ordOneFib(n));
//        System.out.println(fib.fibBottom(n, false));
        fib b = new fib().setN(n);
//        pool.invoke(b);
        System.out.println(b.getOut());

        System.out.println(LustigaHissen.antalResorHiss(7, 3, 1, 2) + " " + LustigaHissen.antalHissBredd(7, 3, 1, 2) + " " + LustigaHissen.antalResorHiss(7, 3, 1, 1, 2, 0, new ArrayDeque<>()));
        BST<String> bst = new BST<>();
        bst.add("string");
        bst.add("hej");
        bst.add("hej4");
        bst.add("hej5");
        bst.add("hej3");
        bst.add("hej6");
        bst.add("hej7");
        bst.add("hej1");
        bst.add("hej2");
        bst.add("yoyo");

        System.out.println(bst.find("hej"));
        System.out.println(bst.toString());
        bst.delete("hej4");
        System.out.println(bst.toString());

    }

}

class mArray<E> extends mList<E> {

    private E[] arr = (E[]) new Object[10];
    private int current = 0;

    public E get(int i) {
        if (i >= 0 && i <= arr.length) {
            return arr[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public void add(E e) {
        if (arr.length == current) {
            reallocate();
        }
        arr[current++] = e;
    }

    private void reallocate() {
        //TODO
        E[] tmp = (E[]) new Object[arr.length * 2];
        Arrays.copyOf(arr, arr.length * 2);
        arr = tmp;
    }

    public E remove(int i) {
        E tmp = arr[i];
        for (int j = i; j < current - 1; j++) {
            arr[i] = arr[i + 1];
        }
        return tmp;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int c = 0;

            @Override
            public boolean hasNext() {
                return c != current;
            }

            @Override
            public E next() {
                return arr[c++];
            }
        };
    }

}

class LinkList<E> extends mList<E> {
    Node head;

    public LinkList() {
        head = new Node(null, null);
    }

    /**
     * Returns an iterator over elements of type {@code T}
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public E next() {
                current = current.next;
                return current.data;
            }
        };
    }

    private class Node {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public E get(int i) {
        Node node = head;
        for (int j = 0; j < i; j++) {
            node = node.next;//TODO unless null
        }
        return node.data;
    }

    public void add(E e) {
        head = new Node(e, head);
    }

    public E remove(int i) {
        Node node = head;
        Node tmp = head;
        for (int j = 0; j < i; j++) {
            tmp = node;
            node = node.next;
        }
        tmp.next = node.next;
        return node.data;
    }

    public Stream<E> stream(){
        return java.util.stream.StreamSupport.stream(this.spliterator(),false);
    }

}

abstract class mList<E> implements Iterable<E> {
    abstract E get(int i);

    abstract void add(E e);

    abstract E remove(int i);

}
