package study.LinkedList;

import java.util.NoSuchElementException;

/**
 * 큐는 앞뒤로 주소를 알아야한다
 * 선입선출 구조
 * @param <T>
 */
public class Queue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data  = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if(first == null) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}

class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.add(1);
        queue.add(4);
        queue.add(6);
        queue.add(9);

        System.out.println(queue.remove());
        System.out.println(queue.peek());
    }
}
