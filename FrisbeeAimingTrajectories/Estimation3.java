public class Estimation3 {

	static final double GOAL_HEIGHT = 2.77; // in  meters
	static final double LAUNCH_HEIGHT = 0.5; // in  meters
	static final double v0 = 15.2; // in  meters/second
	static final double g = 9.65; // in  meters/second2
	static final double LIFT_FORCE = 0.1499; // in  meters/second2
	
	public static void main(String[] args) {
		System.out.println(findShooterAngle( 5 ));
	}
	public static double findShooterAngle(double distance){
		double v2 = Math.pow(v0, 2); //v squared
		double sqrt =  Math.sqrt(Math.pow(v0, 4) - (g - LIFT_FORCE) * ((g - LAUNCH_HEIGHT) * Math.pow(distance, 2) + 2 * (GOAL_HEIGHT - LAUNCH_HEIGHT) * v2));
		double angle = Math.atan((v2 - sqrt)/((g - LIFT_FORCE) * distance));
		return Math.toDegrees(angle);
	}
}
