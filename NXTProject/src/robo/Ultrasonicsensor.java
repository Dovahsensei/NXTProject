package robo;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class Ultrasonicsensor {
	
	int distance; //ursprüngliche Entfernung
	static UltrasonicSensor us;
	static TouchSensor ts;
	static final int v = 150;
	
	Ultrasonicsensor() {
		us = new UltrasonicSensor(SensorPort.S2);
		ts = new TouchSensor(SensorPort.S1);
		System.out.println("Gewünschter Abstand zur Wand");
		Button.waitForAnyPress();
		distance = us.getDistance();
		Motor.C.setSpeed(v);
		Motor.A.setSpeed(v);
		Motor.C.forward();
		Motor.A.forward();
		followWall();
	}
	
	public void followWall(){
		while (true) {	

			System.out.println("Derzeitiger Abstand zur Wand: " + us.getDistance());

			if (distance > us.getDistance()) {
				Motor.C.setSpeed(v + 20);
				Motor.A.setSpeed(v - 20);
			}
			if (distance < us.getDistance()) {
				Motor.C.setSpeed(v - 20);
				Motor.A.setSpeed(v + 20);
			}
			if (ts.isPressed()) {
				break;
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		Ultrasonicsensor test = new Ultrasonicsensor();
		Sound.twoBeeps();
	}

}
