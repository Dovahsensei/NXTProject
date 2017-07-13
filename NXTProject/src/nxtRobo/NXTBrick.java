package nxtRobo;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class NXTBrick {

	public static final NXTAxis ax = new NXTAxis();
	public static final NXTUltrasonicS us = new NXTUltrasonicS(SensorPort.S2);
	public static final NXTLightSensor ls = new NXTLightSensor(SensorPort.S4);
	public static final TouchSensor ts = new TouchSensor(SensorPort.S1);

	public NXTBrick() {

		ls.newLine();
		followLine(ls.correction);
		ax.backAndTurnRight();
		us.setOptimalDistance();
		followWall(us.optimalDistance);

	}

	public void followLine(int correction) {
		while (true) {
			System.out.println("actual lightvalue: " + ls.getLightValue());
			if (ls.getLightValue() < correction) {
				ax.correctCurve(50, -50);
			}
			if (ls.getLightValue() > correction) {
				ax.correctCurve(-50, 50);
			}
			if (ts.isPressed()) {
				break;
			}
			LCD.clear();
		}
	}

	public void followWall(int optimalDistance) {
		while (true) {
			System.out.println("actual distance: " + us.getDistance());
			if (us.getDistance() > optimalDistance) {
				ax.correctCurve(20, -20);
			}
			if (us.getDistance() < optimalDistance) {
				ax.correctCurve(-20, 20);
			}
			if (us.getDistance()  == optimalDistance){
				ax.correctCurve(0, 0);
			}
			if (ts.isPressed()) {
				break;
			}
			LCD.clear();
		}
	}

	public static void main(String[] args) {

		NXTBrick brain = new NXTBrick();

	}

}
