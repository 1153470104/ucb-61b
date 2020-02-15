
/** NBody is going to stimulate a universe specified in a txt file */
public class NBody {
	
	/** read the radious of the universe */
	public static double readRadius(String file) {
		/** instantiate */
		In in = new In(file);
		
		in.readInt();
		double radius = in.readDouble();
		
		return radius;
	}

	/** then read the body of the file */
	public static Body[] readBodies(String file) {
		/** instantiate & skip the first two number */
		In in = new In(file);
		in.readInt();
		in.readDouble();

		/** give some midvalue to manipulate the file content */
		double xP, yP, xV, yV, mass;
		String img;

		/** the main method loop */
		while(!in.isEmpty()) {
			
		}
	}
}