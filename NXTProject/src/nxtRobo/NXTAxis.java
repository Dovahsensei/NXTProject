package nxtRobo;

import lejos.nxt.Motor;
import lejos.nxt.MotorPort;

public class NXTAxis {
	
	public static final NXTWheel rightWheel = new NXTWheel(MotorPort.A);
	public static final NXTWheel leftWheel = new NXTWheel(MotorPort.C);
	
	public NXTAxis(){
	}
	
	public void correctCurve(int correctionRightWheel, int correctionLeftWheel){
		rightWheel.setSpeed(rightWheel.normalVelocity + correctionRightWheel);
		leftWheel.setSpeed(leftWheel.normalVelocity + correctionLeftWheel);
		rightWheel.forward();
		leftWheel.forward();
	}
	
	public void backAndTurnRight(){
		rightWheel.stop();
		leftWheel.stop();
		rightWheel.setSpeed(180);
		leftWheel.setSpeed(180);
		rightWheel.backward();
		leftWheel.backward();
		try{
			Thread.sleep(4000);	
		} catch(Exception e){
			
		}
		rightWheel.rotate(-396/2, true);
		leftWheel.rotate(396/2);
	}
}
