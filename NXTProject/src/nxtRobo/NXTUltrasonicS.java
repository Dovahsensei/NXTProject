package nxtRobo;

import lejos.nxt.I2CPort;
import lejos.nxt.UltrasonicSensor;

public class NXTUltrasonicS extends UltrasonicSensor{
	
	int optimalDistance;
	NXTUltrasonicS(I2CPort port){
		super(port);
	}
	
	public void setOptimalDistance(){
		optimalDistance = getDistance();
	}
	
	public static void main(String[] args) {
		
	}
}
