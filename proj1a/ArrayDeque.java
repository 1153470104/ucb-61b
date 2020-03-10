import java.lang.reflect.Array;

public class ArrayDeque<Glorp> {
    private int size = 0;
    private Glorp[] items;

    /** create an empty linked list deque */
    public ArrayDeque() {
        items = (Glorp [])new Object[8];
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
    public void addFirst(Glorp item) {

    }

    public void addLast(Glorp item) {

    }

    public Glorp removeFirst() {

    }

    public Glorp removeLast() {

    }

    /** take constant time, too */
    public int size() {

    }


    /** get must use iteration, not recursion */
    public Glorp get(int index) {

    }

    public boolean isEmpty() {

    }

    public void printDeque() {

    }
}
