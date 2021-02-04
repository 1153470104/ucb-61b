/**
 * print the serial cooridnates of Bodies
 */
public class TestBody {
	/**
	 * give three Body a, b, c
	 * try to print their continuous coordinates
	 *
	 * though I don't think it's a testing...
	 */
	public static Body a = new Body(20.0, 20.0, 1.0, 5.0, 5000.0, "some");
	public static Body b = new Body(60.0, -20.0, 13.0, 3.0, 1000.0, "some");
	public static Body c = new Body(5.0, 100.0, 5.0, -6.0, 12000.0, "some");

	public static Body[] BodyList = {a, b, c};

	/** encapsulation of the update methods */
	public static void updateBody(Body bb, double dt) {
		double fx = bb.calcNetForceExertedByX(BodyList);
		double fy = bb.calcNetForceExertedByY(BodyList);
		bb.update(dt, fx, fy);
	}

	/** print the current position of Body */
	public static void printBodyCoordinate(Body b) {
		System.out.printf("%.2f\t", b.xxPos);
		System.out.printf("%.2f\t", b.yyPos);
	}

	/** main methods to print the whole list */
	public static void main(String[] args) {
		double time = 0;
		double dt = 0.2;
		while (time < 20) {
			updateBody(a, dt);	updateBody(b, dt);	updateBody(c, dt);
			printBodyCoordinate(a);
			printBodyCoordinate(b);
			printBodyCoordinate(c);
			System.out.println();
			time += dt;
		}
	}
}