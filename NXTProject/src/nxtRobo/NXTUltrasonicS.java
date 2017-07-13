package nxtRobo;

import lejos.nxt.I2CPort;
import lejos.nxt.UltrasonicSensor;

public class NXTUltrasonicS extends UltrasonicSensor{	//Tochterklasse von UltrasonicSensor um diese zu erweitern
	
	private int optimalDistance;	//private, um den Integer vor Eingriffen durch andere Klassen zu sch�tzen
	
	public NXTUltrasonicS(I2CPort port){	//Konstruktor mit portzuweisung im Konstruktorkopf
		super(port);						//standart Konstruktor von UltrasonicSensor
	}
	
	public int getOptimalDistance() {	//getter-Methode f�r optimalDistance, da dieser privat 
		return optimalDistance;
	}
	
	public void setOptimalDistance(){	//Methode um den gew�nschten Abstand des Mindstorms zur Wand festzulegen
		optimalDistance = getDistance();
	}
}
