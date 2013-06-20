/*
 * Estimation using gravity - lift force with alpha
 */

import java.lang.Math;
import java.io.*;
/**
 * The class Frisbee contains the method simulate which uses Eulerâ€™s
 * method to calculate the position and the velocity of a frisbee in
 * two dimensions.
 *
 * @author Vance Morrison
 * @version March 4, 2005
 */
public class Estimation4 {
	private static final double g = -9.7999; //The acceleration of gravity (m/s^2).
	private static final double m = 0.175; //The mass of a standard frisbee in kilograms.
	private static final double RHO = 1.23; //The density of air in kg/m^3.
	private static final double DIAM = 0.27305;//The diameter of the frisbee.
	private static final double AREA = Math.pow(DIAM/2, 2)*Math.PI; //The area of OUR frisbee.
	private static final double CL0 = 0.1; //The lift coefficient at alpha = 0.
	private static final double CLA = 1.4; //The lift coefficient dependent on alpha.
	private static final double CD0 = 0.08; //The drag coefficent at alpha = 0.
	private static final double CDA = 2.72;
	private static final double ALPHA = 16;
	private static final double v0 = 15; // m/s
	
	public final static double GOAL_HEIGHT = 2.77; //in meters
	public final static double LAUNCH_HEIGHT = 0.5; // in meters
	public final static double SHOOTER_MIN_ANGLE = 18; // in degrees
	public final static double SHOOTER_MAX_ANGLE = 19; // in degrees

	public static void main(String args[]) {
		System.out.println(findAngle(105));
	}

	
	public static double findAngle(double distanceFromGoal){
		double height = 0;
		double angle = 0;
		for(angle = SHOOTER_MIN_ANGLE; height <= 0; angle+=.5){
			height = simulateHeight(angle, distanceFromGoal);
			if (angle > SHOOTER_MAX_ANGLE)
				return 0;
		}
		return angle;
	}

		/**
		 * A method that uses Euler’s method to simulate the flight of a frisbee in
		 * two dimensions, distance and height (x and y, respectively).
		 *
		 */
		public static double simulateHeight(double angle, double distance)
		{
			
			double x;
			//The x position of the frisbee.
			double y;
			//The y position of the frisbee.
			double vx;
			//The x velocity of the frisbee.
			double vy;
			//The y velocity of the frisbee.
			
			
			double deltaT = 0.005;
			//Calculation of the lift coefficient using the relationship given
			//by S. A. Hummel.
			double cl = CL0 + CLA*ALPHA*Math.PI/180;
			//Calculation of the drag coefficient (for Prantl’s relationship)
			//using the relationship given by S. A. Hummel.
			double cd = CD0 + CDA*Math.pow((ALPHA)*Math.PI/180,2);
			//Initial position x = 0.
			x = 0;
			//Initial position y = y0.
			y = GOAL_HEIGHT-LAUNCH_HEIGHT;
			//Initial x velocity vx = vx0.
			vx = v0 * Math.sin(Math.toRadians(angle));
			//Initial y velocity vy = vy0.
			vy = v0 * Math.cos(Math.toRadians(angle));
			try{
				//A loop index to monitor the simulation steps.
				int k = 0;
				//A while loop that performs iterations until the y position
				//reaches zero (i.e. the frisbee hits the ground).
				while(y>0){
					//The change in velocity in the y direction obtained setting the
					//net force equal to the sum of the gravitational force and the
					//lift force and solving for delta v.
					double deltavy = (RHO*Math.pow(vx,2)*AREA*cl/2/m+g)*deltaT;
					//The change in velocity in the x direction, obtained by
					//solving the force equation for delta v. (The only force
					//present is the drag force).
					double deltavx = -RHO*Math.pow(vx,2)*AREA*cd*deltaT;
					//The new positions and velocities are calculated using
					//simple introductory mechanics.
					vx = vx + deltavx;
					vy = vy + deltavy;
					x = x + vx*deltaT;
					y = y + vy*deltaT;
					if (x >= distance) {
						return y;
					}
					k++;
				}
			}
			catch(Exception e){
				System.out.println("Error, file frisbee.csv is in use.");
				}
			return 0;
		}
	}