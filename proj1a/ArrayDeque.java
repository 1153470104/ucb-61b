import java.lang.reflect.Array;
import java.util.Objects;

public class ArrayDeque<Glorp> {
    private int size;
    private Glorp[] items;
    private int first;
    private int last;

    /** create an empty linked list deque */
    public ArrayDeque() {
        items = (Glorp [])new Object[8];
        size = 0;
    }

    /** create a deep copy of 'other' */
    public ArrayDeque(ArrayDeque other) {
        this.items = (Glorp [])new Object[other.size()];
        this.size = other.size();
        this.first = 0;
    }

    /**
     * use prevItem() & nextItem()
     * to encapsulate the check function of the array bound
     */
    private int prevItem(int count) {
        if(count == 0) {
            return size - 1;
        } else {
            return count - 1;
        }
    }

    private int nextItem(int count) {
        if(count == size - 1)
            return 0;
        else
            return count + 1;
    }

    /**
     * the amount of memory the program uses
     * must be proportional to the number of items
     * the usage factor always be at least 25%
     */
    public void addFirst(Glorp item) {
        if(this.isEmpty()) {
            this.items[0] = item;
            first = 0;
            last = 0;
        }
        /** array has a length variable */
        if(size < items.length) {
            this.items[prevItem(first)] = item;
            first = prevItem(first);
        } else {
            if(size < 1000) {
                this.resize(size * 2);
            } else {
                this.resize(size + 1000);
            }
            this.items[prevItem(first)] = item;
            first = prevItem(first);
        }
    }

    public void addLast(Glorp item) {
        if(this.isEmpty()) {
            this.items[0] = item;
            first = 0;
            last = 0;
        }
        if(size < items.length) {
            this.items[nextItem(last)] = item;
            last = nextItem(last);
        } else {
            if(size < 1000) {
                this.resize(size * 2);
            } else {
                this.resize(size + 1000);
            }
            this.items[nextItem(last)] = item;
            last = nextItem(last);
        }
    }

    public Glorp removeFirst() {
        Glorp firstItem = this.items[first];
        first = nextItem(first);
        size = size - 1;
        if(this.size == 0) {
            this.first = 0;
            this.last = 0;
        }
        if(4 * this.size < this.items.length && this.size >= 4) {
            this.resize(this.size * 2);
        }
        return firstItem;
    }

    public Glorp removeLast() {
        Glorp lastItem = this.items[last];
        last = prevItem(last);
        size = size - 1;
        if(this.size == 0) {
            this.first = 0;
            this.last = 0;
        }
        if(4 * this.size < this.items.length && this.size >= 4) {
            this.resize(this.size * 2);
        }
        return lastItem;
    }

    private void resize(int newSize) {
        Glorp[] newItems = (Glorp[]) new Object[newSize];
        for(int i = first; i < first + size; i++) {
            newItems[i] = items[i % items.length];
        }
    }

    /** take constant time, too */
    public int size() {
        return this.size;
    }


    /** get must use iteration, not recursion */
    public Glorp get(int index) {
        int site = (index + first) % this.items.length;
        return items[site];
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printDeque() {
        for(int i = first; i < size + first; i++) {
            System.out.print(this.get(i % this.items.length));
        }
    }
}
