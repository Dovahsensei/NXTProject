package nxtRobo;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class NXTBrick {
	
	public static final NXTWheel rightWheel = new NXTWheel(MotorPort.A);
	public static final NXTWheel leftWheel = new NXTWheel(MotorPort.C);
	public static final NXTUltrasonicSensor us = new NXTUltrasonicSensor(SensorPort.S2);
	public static final NXTLightSensor ls = new NXTLightSensor(SensorPort.S4);
	public static final TouchSensor ts = new TouchSensor(SensorPort.S1);
	
	public NXTBrick(){
		
		
		while (!ts.isPressed()){
			while(!ts.isPressed()){
				followLine(ls.correction,ls.getLightValue());
			}
			followWall(us.optimalDistance, us.getDistance());
		}
	}
	
	public void followLine(int correction, int lightvalue){
		if (ls.getLightValue() < ls.correction){
			rightWheel.setSpeed(rightWheel.normalVelocity + 50);
			leftWheel.setSpeed(leftWheel.normalVelocity - 50);
		}
		if (ls.getLightValue() > ls.correction){
			rightWheel.setSpeed(rightWheel.normalVelocity - 50);
			leftWheel.setSpeed(leftWheel.normalVelocity + 50);
		}
	}
	
	public void followWall(int optimalDistance, int actualDistance){
		if (actualDistance < optimalDistance){
			rightWheel.setSpeed(rightWheel.normalVelocity - 20);
			leftWheel.setSpeed(leftWheel.normalVelocity + 20);
		}
		if (actualDistance > optimalDistance){
			rightWheel.setSpeed(rightWheel.normalVelocity + 20);
			leftWheel.setSpeed(leftWheel.normalVelocity - 20);
		}
	}

	public static void main(String[] args) {
		
		NXTBrick brain = new NXTBrick();
		
		

	}

}
