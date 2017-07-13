package nxtRobo;

import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.TachoMotorPort;

public class NXTWheel extends NXTRegulatedMotor{	//Tochterklasse von NXTRegulatedMotor um diese zu erweitern
	
	final int normalVelocity = 150;	//Grundgeschwindigkeit den das Rad jeweils haben soll
	
	public NXTWheel(TachoMotorPort port){	//Konstruktor mit portzuweisung im Konstruktorkopf
		super(port);						//standart Konstruktor von UltrasonicSensor
	}
}
