import java.lang.Math;

/**
 * the Body class
 * xxPos: the current x position, yyPos: the current y position
 * xxVel: the current velocity in the x position, yyVel is just same...
 * mass: its mass
 * imgFileName: the name of the image file that depicts the body
 */

public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/** the scientific notation java already support */
	private double Gravi = 6.67e-11;

	/**
	 * constructor one
	 */
	public Body(double xP, double yP, double xV,
	             double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
	    imgFileName = img;
	}

	/**
	 * return the distance between this & the input Body
	 */
	public double calcDistance(Body b) {
		double distance = Math.pow((this.xxPos - b.xxPos), 2) + 
							Math.pow((this.yyPos - b.yyPos), 2);
		distance = Math.sqrt(distance);
		return distance;
	}

	/**
	 * return the force exerted by another Body
	 */
	public double calcForceExertedBy(Body b) {
		double distance = this.calcDistance(b);
		double forceExertedBy = this.mass * b.mass * Gravi
								 / distance / distance;
		return forceExertedBy;
	}

	/**
	 * return the Netforce exerted by X 
	 * and the next method is the y version
	 */
	public double calcForceExertedByX(Body b) {
		double distanceByX = b.xxPos - this.xxPos;
		double distance = this.calcDistance(b);
		double force = this.calcForceExertedBy(b); 
		
		double forceExertedByX = force * distanceByX / distance;
		return forceExertedByX;
	}

	public double calcForceExertedByY(Body b) {
		double distanceByY = b.yyPos - this.yyPos;
		double distance = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);
		
		double forceExertedByY = force * distanceByY / distance;
		return forceExertedByY;
	}

	/**
	 * return the netForce exerted by X & Y respectively
	 */
	public double calcNetForceExertedByX(Body[] list) {
		int length = list.length;
		double netForceByX = 0;

		for (int i = 0; i < length; i++) {
			if (!this.equals(list[i])) {
				netForceByX += this.calcForceExertedByX(list[i]);
			}
		}
		return netForceByX;
	}

	public double calcNetForceExertedByY(Body[] list) {
		int length = list.length;
		double netForceByY = 0;

		for (int i = 0; i < length; i++) {
			if (!this.equals(list[i])) {
				netForceByY += this.calcForceExertedByY(list[i]);
			}
		}
		return netForceByY;
	}
	
	/**
	 * update the position & the velocity of this Body
	 * according to the given forces & dt
	 */
	public void update(double dt, double fx, double fy) {
		double acceleretionX = fx / this.mass;
		double acceleretionY = fy / this.mass;

		this.xxVel = this.xxVel + dt * acceleretionX;
		this.yyVel = this.yyVel + dt * acceleretionY;

		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}








	/**
	 * constructor two
	 */
	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
	    imgFileName = b.imgFileName;
	}
}