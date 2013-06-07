public class Estimation1 {
	
	public final static double GOAL_HEIGHT = 2.77; //M
	
	public static void main(String[] args) {
		System.out.println(findShooterAngle( 10 ));
	}
	public static double findShooterAngle(double distance){
		return Math.atan(GOAL_HEIGHT/distance);
	}
}
