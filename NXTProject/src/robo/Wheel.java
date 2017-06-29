package robo;

import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTRegulatedMotor;

public class Wheel {
	
	public static final NXTRegulatedMotor A = new NXTRegulatedMotor(MotorPort.A);
	
	int v; //speed
	
	
	public Wheel(){
		v = 0;
	}
	
	public void incSpeed(int i){//acceleration
		Motor.A.setSpeed(v + i);
	}
	public void decSpeed(int i){//
		Motor.A.setSpeed(v - i);
	}

}
