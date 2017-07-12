package nxtRobo;

import lejos.nxt.I2CPort;
import lejos.nxt.UltrasonicSensor;

public class NXTUltrasonicSensor extends UltrasonicSensor{
	
	int optimalDistance;
	NXTUltrasonicSensor(I2CPort port){
		super(port);
	}
	
	public void setOptimalDistance(){
		optimalDistance = getDistance();
	}
}
