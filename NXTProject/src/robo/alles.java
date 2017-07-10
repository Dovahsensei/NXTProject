package robo;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class alles {
	
	int white;	//Boden
	int black;	//Linie
	int correction;	//Mittelwert zwischen white und black
	int v = 150;
	int distance;	  //ursprüngliche Entfernung
	LightSensor ls;	//Lichtsensor
	TouchSensor ts;	//Berührungssensor
	UltrasonicSensor us;
	
	public void newLine(){
		System.out.println("Set on white and press button");
		Button.waitForAnyPress();
		white = ls.getLightValue();
		System.out.println("Set on black and press button");
		Button.waitForAnyPress();
		black = ls.getLightValue();
	}
	
	public void followWall(){
		distance = us.getDistance();
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
		}
	}
	
	public void forward() {
		Motor.C.forward();
		Motor.A.forward();
		Motor.C.setSpeed(v);
		Motor.A.setSpeed(v);
	}
	
	public void backward() {
		Motor.C.backward();
		Motor.A.backward();
		Motor.C.setSpeed(v);
		Motor.A.setSpeed(v);
	}
	
	public void followLine(){
		correction = (white + black) / 2;
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
	
	public void turnRight() {
		Motor.A.rotate(-720);
		Motor.C.rotate(-720);
		Motor.A.rotate((int) (-(0.25f*5.5f)*180));
		Motor.C.rotate((int) ((0.25f*5.5f)*180));
		}
	public void turnRight2() throws InterruptedException{
		Motor.A.setSpeed(360);
		Motor.C.setSpeed(360);
		Motor.A.backward();
		Motor.C.backward();
		try{
			Thread.sleep(2000);	
		} catch(Exception e){
			
		}
		
		Motor.A.backward();
		Motor.C.forward();
		Motor.A.setSpeed((0.25f*5.5f)*180);
		Motor.C.setSpeed((0.25f*5.5f)*180);
		try{
			Thread.sleep(1000);	
		} catch(Exception e){
			
		}
	}
		
	
	public void findLine() {
		while (ls.getLightValue() != black) {
			followWall();
		}
		
	}
	
	public alles() {
		ls = new LightSensor(SensorPort.S4);
		ts = new TouchSensor(SensorPort.S1);
		us = new UltrasonicSensor(SensorPort.S2);
		Button.waitForAnyPress();
	}


	public static void main(String[] args) throws InterruptedException {
		
		alles a = new alles();
		a.turnRight2();

		
	}

}
