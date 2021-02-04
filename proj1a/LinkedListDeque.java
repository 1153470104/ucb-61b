public class LinkedListDeque<T> {
    /**
     * use a circle sentinel
     * there is a sentinel, use it to simplify the add and remove
     */
    private LinkedNode sentinel;
    private int size;

    private class LinkedNode {
        public LinkedNode prev;
        public T item;
        public LinkedNode next;

        public LinkedNode(){
            this.prev = null;
            this.item = null;
            this.next = null;
        }

        public LinkedNode(LinkedNode p, T i, LinkedNode n) {
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }

    /** create an empty linked list deque */
    public LinkedListDeque() {
        this.sentinel = new LinkedNode();
        //make sure to add these references to sentinel itself !!!
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    /** create a deep copy of 'other' */
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new LinkedNode();
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        size = 0;
        int theSize = other.size();
        while(this.size() < theSize) {
            //there's a question that:
            //if you don't define the generic type in the input type
            //other's item would be define as object
            this.addFirst(other.get(this.size));
        }
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
        /** so clear and simple! */
        LinkedNode first = new LinkedNode(this.sentinel, item, this.sentinel.next);
        this.sentinel.next.prev = first;
        this.sentinel.next = first;
        size++;
    }

    public void addLast(T item) {
        LinkedNode last = new LinkedNode(this.sentinel.prev, item, this.sentinel);
        this.sentinel.prev.next = last;
        this.sentinel.prev = last;
        size++;
    }

    public T removeFirst() {
        T first = this.sentinel.next.item;
        this.sentinel.next.next.prev = this.sentinel;
        this.sentinel.next = this.sentinel.next.next;
        //can't believe I forget size's manipulation !
        size--;
        return first;
    }

    public T removeLast() {
        T last = this.sentinel.prev.item;
        this.sentinel.prev.prev.next = this.sentinel;
        this.sentinel.prev = this.sentinel.prev.prev;
        size--;
        return last;
    }

    /** take constant time, too */
    public int size() {
        return this.size;
    }


    /** get must use iteration, not recursion */
    public T get(int index) {
        LinkedNode p = this.sentinel;
        for(int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /** same as get, but uses recursion */
    public T getRecursive(int index) {
        LinkedListDeque<T> newList = new LinkedListDeque<>(this);
        return newList.recursive(index);
    }

    /** same as get, but uses recursion */
    private T recursive(int index) {
        if(index == -1) {
            return this.sentinel.item;
        }
        this.sentinel = this.sentinel.next;
        return this.getRecursive(index - 1);
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printDeque() {
        LinkedNode p = this.sentinel;
        for(int i = 0; i < size; i++) {
            p = p.next;
            System.out.print(p.item + "  ");
        }
        System.out.println();
    }

}
