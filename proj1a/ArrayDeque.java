import java.lang.reflect.Array;

public class ArrayDeque<T> {
    private int size = 0;
    private T[] items;

    /** create an empty linked list deque */
    public ArrayDeque() {
        items = new T[10];
        size = 0;
    }

    /** create a deep copy of 'other' */
    public ArrayDeque(ArrayDeque other) {

    }

    /**
     * the amount of memory the program uses
     * must be proportional to the number of items
     * the usage factor always be at least 25%
     */
    public void addFirst(T item) {

    }

    public void addLast(T item) {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    /** take constant time, too */
    public int size() {

    }


    /** get must use iteration, not recursion */
    public T get(int index) {

    }

    public boolean isEmpty() {

    }

    public void printDeque() {

    }
}
