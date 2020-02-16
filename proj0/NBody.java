import java.lang.Double;

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
		int planetCount = in.readInt();
		in.readDouble();

		/** give some midvalue to manipulate the file content */
		double xP, yP, xV, yV, mass;
		String img;
		Body[] allBodies = new Body[planetCount];
		int count = 0;

		/** the main method loop */
		for(int i = 0; i < planetCount; i++) {
			/**
			 * some mistakes were made here
			 * I don's know that the file is not all consisted by data!
			 * at the end there's bunch of txt to explain something!
			 * 
			 * so, the lesson is: 
			 * if some type error appear, check the data file
			 * error may happen in any proceed, check through the file!
			 */
			xP = in.readDouble();
			yP = in.readDouble();
			xV = in.readDouble();
			yV = in.readDouble();
			mass = in.readDouble();
			img = in.readString();
			Body planet = new Body(xP, yP, xV, yV, mass, img);

			allBodies[i] = planet;
		}
		return allBodies;
	}

	public static void main(String[] args) {
		/** collecting all needed input */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] allPlanets = readBodies(filename);
		int count = allPlanets.length;

		/** drawing the background */
		String backPicture = "images/starfield.jpg";
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-1 * radius, radius);

		/**
		for(int i = 0; i < sound.length; i++) {
			 System.out.printf("%f\t", sound[i]);
		}
		*/
		/** audio file adding */
		double[] sound = StdAudio.read("audio/2001.wav");
		/** audio start playing */
		//StdAudio.play(sound);
		
		/** creating an animation */
		double time;
		for(time = 0; time < T; time += dt) {
			double[] xForces = new double[count];
			double[] yForces = new double[count];

			/** calculate net force for every planet */
			for(int i = 0; i < count; i++) {
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}

			/** update every planet */
			for(int j = 0; j < count; j++) {
				allPlanets[j].update(dt, xForces[j], yForces[j]);
			}

			/** draw */
			StdDraw.picture(0, 0, backPicture);
			for(int i = 0; i < count; i++) {
				StdDraw.enableDoubleBuffering();
				allPlanets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", count);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < count; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                 			 allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                 			 allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
		}

		/** stop audio playing */
		StdAudio.close();
	}
}