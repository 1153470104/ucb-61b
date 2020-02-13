/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a == b;
    }

    /**
     * so, the problem is the data type
     * there's difference between Integer & int
     * though I don't know the reason, but we can fix it easily...
     *
     public static boolean isSameNumber(int a, int b) {
        return a == b;
    }
     */

    public static void main(String... args) {
        boolean r1 = Flik.isSameNumber(1,1);
        boolean r2 = Flik.isSameNumber(12,15);
        boolean r3 = Flik.isSameNumber(200,200);
        System.out.println("the boolean: " + r1);
        System.out.println("the boolean: " + r2);
        System.out.println("the boolean: " + r3);
    }
}
