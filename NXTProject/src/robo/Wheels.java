package robo;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTRegulatedMotor;

public class Wheels extends Motor{
	public static final NXTRegulatedMotor RightWheel = new NXTRegulatedMotor(MotorPort.A);
	public static final NXTRegulatedMotor LeftWheel = new NXTRegulatedMotor(MotorPort.C);
	int speed; //speed	
		
	public Wheels(){
		vRight = 0;
		vLeft = 0;
	}
		
	public void incRightSpeed(int i){//acceleration
		Motor.A.setSpeed(vRight + i);
	}
	public void decRightSpeed(int i){//
		Motor.A.setSpeed(vRight - i);
	}
	
	public void incLeftSpeed(int i){//acceleration
		Motor.C.setSpeed(vLeft + i);
	}
	public void decLeftSpeed(int i){//jkölkö
		Motor.C.setSpeed(vLeft - i);
	}
	public void accelerate(int i){
		incRightSpeed(i);
		incLeftSpeed(i);
	}
	public void slowDown(int i){
		decRightSpeed(i);
		decLeftSpeed(i);
	}
	static public void wheelsForward(){
		Motor.A.forward();
		Motor.C.forward();
	}
	static public void wheelsBackward(){
		Motor.A.backward();
		Motor.C.backward();
	}
	
	public static void main(String[] args){
		Wheels wheels = new Wheels();
		wheels.accelerate(720);
		wheelsForward();
		Button.waitForAnyPress();
		wheels.slowDown(360);
		Button.waitForAnyPress();
		wheels.accelerate(720);
		wheelsBackward();
		Button.waitForAnyPress();
	}
}
