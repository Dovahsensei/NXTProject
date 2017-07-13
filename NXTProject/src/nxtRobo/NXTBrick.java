package nxtRobo;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class NXTBrick {

	public static final NXTAxis ax = new NXTAxis();
	public static final NXTUltrasonicS us = new NXTUltrasonicS(SensorPort.S2);
	public static final NXTLightSensor ls = new NXTLightSensor(SensorPort.S4);
	public static final TouchSensor ts = new TouchSensor(SensorPort.S1);

	public NXTBrick() {

		ls.newLine();
		followLine(ls.correction, ls.getLightValue());
		ax.backAndTurnRight();
		us.setOptimalDistance();
		followWall(us.optimalDistance, us.getDistance());

	}

	public void followLine(int correction, int lightValue) {
		while (true) {
			if (lightValue < correction) {
				ax.correctCurve(-50, 50);
			}
			if (lightValue > correction) {
				ax.correctCurve(50, -50);
			}
			if (ts.isPressed()) {
				break;
			}
		}
	}

	public void followWall(int optimalDistance, int actualDistance) {
		while (true) {
			if (actualDistance > optimalDistance) {
				ax.correctCurve(20, -20);
			}
			if (actualDistance < optimalDistance) {
				ax.correctCurve(-20, 20);
			}
			if (ts.isPressed()) {
				break;
			}
		}
	}

	public static void main(String[] args) {

		NXTBrick brain = new NXTBrick();

	}

}
