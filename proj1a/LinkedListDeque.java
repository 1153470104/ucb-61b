public class LinkedListDeque<T> {
    private LinkedNode sentinel;
    private int size;

    private class LinkedNode {
        public LinkedNode prev;
        public T item;
        public LinkedNode next;
    }



    /** create an empty linked list deque */
    public LinkedListDeque() {

    }

    /** create a deep copy of 'other' */
    public LinkedListDeque(LinkedListDeque other) {

    }

    /**
     * the next eight method is the operations of deque
     * 1-4 manipulating item: add / remove, first / last
     * 5-8 isempty / size / get / printDeque
     *
     * the first 4 methods must take "constant time"
     * i.e. execution time should not depend on the size of the deque
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

    /** same as get, but uses recursion */
    public  T getRecursive(int index) {

    }

    public boolean isEmpty() {

    }

    public void printDeque() {

    }

}
