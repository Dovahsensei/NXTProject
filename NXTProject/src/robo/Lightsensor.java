package robo;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class Lightsensor {
	
	int white;	//Boden
	int black;	//Linie
	int correction;	//Mittelwert zwischen white und black
	LightSensor ls;	//Lichtsensor
	TouchSensor ts;	//Berührungssensor
	
	
	
	public Lightsensor(){
		ls = new LightSensor(SensorPort.S4);
		ts = new TouchSensor(SensorPort.S1);
		newLine();
		correction = (white + black) / 2;
	}
	
	public void newLine(){
		System.out.println("Set on white and press button");
		Button.waitForAnyPress();
		white = ls.getLightValue();
		System.out.println("Set on black and press button");
		Button.waitForAnyPress();
		black = ls.getLightValue();
	}
	
	public void followLine(){
		for(;;){
			System.out.println(ls.getLightValue());
			if(ls.getLightValue() < correction){
				Motor.C.setSpeed(100);
				Motor.A.setSpeed(200);
			}
			if(ls.getLightValue() > correction){
				Motor.C.setSpeed(200);
				Motor.A.setSpeed(100);
			}
			if(ts.isPressed()){
				break;
			}
			Motor.A.forward();
			Motor.C.forward();
		}
	}

	public static void main(String[] args) {
		Lightsensor Lichtsensor = new Lightsensor();
		Lichtsensor.followLine();
	}

}
