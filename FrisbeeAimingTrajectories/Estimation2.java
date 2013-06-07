public class Estimation2 {

	public final static double GOAL_HEIGHT = 2.77; // in  meters
	public final static double LAUNCH_HEIGHT = 0.5; // in  meters
	public final static double v0 = 15; // in  meters/second
	public final static double g = 9.8; // in  meters/second2
	
	public static void main(String[] args) {
		System.out.println(findShooterAngle( 10 ));
	}
	public static double findShooterAngle(double distance){
		double v2 = Math.pow(v0, 2); //v squared
		return Math.atan(v2 - Math.sqrt(Math.pow(v0, 4) - g * (g * Math.pow(distance, 2) + 2 * (GOAL_HEIGHT - LAUNCH_HEIGHT) * v2)))/(g * distance);
	}
}
