import java.lang.reflect.Array;
import java.util.Objects;

public class ArrayDeque<Glorp> {
    private int size;
    public Glorp[] items;
    public int first;
    public int last;

    /** create an empty array deque */
    public ArrayDeque() {
        items = (Glorp [])new Object[8];
        size = 0;
    }

    /** create a deep copy of 'other' */
    public ArrayDeque(ArrayDeque other) {
        this.items = (Glorp [])new Object[other.size()];
        this.size = 0;
        for(int i = 0; i < other.size(); i++) {
            this.addFirst((Glorp) other.get(i));
        }
    }

    /**
     * use prevItem() & nextItem()
     * to encapsulate the check function of the array bound
     */
    private int prevItem(int count) {
        if(count == 0) {
            //return size - 1;
            //the problem is here, i muddle items.length with size!
            return items.length - 1;
        } else {
            return count - 1;
        }
    }

    private int nextItem(int count) {
        if(count == items.length - 1)
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
        size++;
        if(this.isEmpty()) {
            this.items[0] = item;
            first = 0;
            last = 0;
//            // i forgot to return!!!
//            return;
        } else if(size < items.length) {
            first = prevItem(first);
            this.items[first] = item;
        } else {
            if(size < 1000) {
                this.resize(size * 2);
            } else {
                this.resize(size + 1000);
            }
            first = prevItem(first);
            this.items[first] = item;
        }
    }

    public void addLast(Glorp item) {
        size++;
        if(this.isEmpty()) {
            this.items[0] = item;
            first = 0;
            last = 0;
        } else if(size < items.length) {
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
        size--;
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
        size--;
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
            newItems[i % newSize] = items[i % items.length];
        }
        //forget to change the reference of item
        //forget to change last
        last = (first + size) % newSize;
        this.items = newItems;
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
