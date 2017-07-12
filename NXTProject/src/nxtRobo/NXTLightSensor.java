package nxtRobo;

import lejos.nxt.ADSensorPort;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;

public class NXTLightSensor extends LightSensor{
	
	int black;
	int white;
	int correction;
	
	public NXTLightSensor(ADSensorPort port){
		super(port);
	}
	
	public void newLine(){
		System.out.println("Set on ground and press button");
		Button.waitForAnyPress();
		white = getLightValue();
		System.out.println("Set on line and press button");
		Button.waitForAnyPress();
		black = getLightValue();
	}
	

}
