public class Estimation1 {
	
	public final static double GOAL_HEIGHT = 2.77; //in meters
	public final static double LAUNCH_HEIGHT = 0.5; // in  meters
	
	public static void main(String[] args) {
		System.out.println(findShooterAngle( 5 ));
	}
	public static double findShooterAngle(double distance){
		double angle = Math.atan((GOAL_HEIGHT - LAUNCH_HEIGHT)/distance);
		return Math.toDegrees(angle);
	}
}
