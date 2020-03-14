import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeTest {
    /**
     * test the rm/add under the normal scale
     * case1: test size & .first & .last after addFirst
     * case2: test size & .first & .last after addLast
     */
    @org.junit.jupiter.api.Test
    void addTest() {
        ArrayDeque<String> arr1 = new ArrayDeque<>();
        ArrayDeque<Double> arr2 = new ArrayDeque<>();

        arr1.addFirst("things");
        assertEquals(0, arr1.first);
        assertEquals(0, arr1.last);
        assertEquals(1, arr1.size());

        arr2.addLast(3.0);
        assertEquals(0, arr2.first);
        assertEquals(0, arr2.last);
        assertEquals(1, arr2.size());

        arr1.addFirst("others");
        arr1.addLast("another");
        assertEquals(7, arr1.first);
        assertEquals(1, arr1.last);
        assertEquals(3, arr1.size());
    }

    /**
     * case1: test size after add & rmFirst
     * case2: test size after add & rmLast
     */
    @org.junit.jupiter.api.Test
    void addRemoveTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(1);

        int fi = arr.removeFirst();
        assertEquals(1, fi);
        assertEquals(0, arr.size());

        arr.addFirst(0);
        int la = arr.removeLast();
        assertEquals(0, la);
        assertEquals(0, arr.size());

        for(int i = 0; i < 9; i++)
            arr.addFirst(0);
        for(int j = 0; j < 4; j++)
            arr.removeFirst();
        assertEquals(5, arr.size());
        for(int k = 0; k < 5; k++)
            arr.removeLast();
        assertEquals(0, arr.size());

    }

    /** test the deep copy method */
    @Test
    void copyInitTest() {
        ArrayDeque<Double> arr1 = new ArrayDeque<>();
        arr1.addFirst(1.1);
        arr1.addFirst(1.2);
        ArrayDeque<Double> arr2 = new ArrayDeque<>(arr1);
        assertEquals(2, arr2.size());
        arr2.removeLast();
        assertEquals(2, arr1.size());
        assertEquals(1, arr2.size());
    }

    /**
     * case1: test circular array with .first
     * case2: test expanding array size, test resize with the usage
     * case3: test shrink array size & usage
     * case4: test get in different site
     */
    @org.junit.jupiter.api.Test
    void sizeGetTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for(int i = 0; i < 8; i++) {
            arr.addFirst(1);
        }
        assertEquals(1, arr.first);
        for(int j = 0; j < 100; j++) {
            arr.addLast(2);
        }
        assertTrue(0.25 < (double)arr.size() / (double)arr.itemsLength());
        assertEquals(1, arr.get(7));
        assertEquals(2, arr.get(9));
        assertEquals(2, arr.get(8));

        for(int k = 0; k < 104; k++) {
            arr.removeFirst();
        }
        assertTrue(0.25 < (double)arr.size() / (double)arr.itemsLength());
        assertEquals(4, arr.size());
        assertEquals(2, arr.get(2));
    }

    /**
     * case1: first initialized
     * case2: added and removed to empty
     */
    @Test
    void isEmptyTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        assertTrue(arr.isEmpty());

        arr.addFirst(1);
        arr.addFirst(5);
        arr.removeLast();
        assertFalse(arr.isEmpty());

        arr.removeFirst();
        assertTrue(arr.isEmpty());
    }

    public static void main(String[] args) {

    }
}