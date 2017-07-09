package robo;

import lejos.nxt.MotorPort;
import lejos.nxt.NXTRegulatedMotor;

public class Motor {
	
	public static final NXTRegulatedMotor RightWheel = new NXTRegulatedMotor(MotorPort.A);
	public static final NXTRegulatedMotor LeftWheel = new NXTRegulatedMotor(MotorPort.C);
	
	final int velocity = 150;
	
	public Motor(){
	}
	
	public void turnLeft(){
		RightWheel.setSpeed(velocity);
		LeftWheel.setSpeed(velocity);
	}
}
