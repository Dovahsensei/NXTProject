package nxtRobo;

import lejos.nxt.ADSensorPort;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;

public class NXTLightSensor extends LightSensor {	//Tochterklasse von LightSensor um diese zu erweitern

	private int black;	//Lichtwertangabe des "weißen" Untergrunds, deklaration
	private int white;	//Lichtwertangabe der "schwarzen" Linie, deklaration
	private int correction;		//Mittelwert zwischen black und white, deklaration

	public NXTLightSensor(ADSensorPort port) {	//Konstruktor mit portzuweisung im Konstruktorkopf
		super(port);							//standart Konstruktor von UltrasonicSensor
	}

	public void newLine() {										//Methode um eine neue zu verfolgende Linie zu "erstellen"
		System.out.println("Set on ground and press button");	//Graphische Hilfestellung
		Button.waitForAnyPress();								//Knopfdruck zum Festlegen von white
		white = getLightValue();								//initialisierung von white über Lichtwert den der Sensor scannt
		System.out.println("Set on line and press button");		//Graphische Hilfestellung
		Button.waitForAnyPress();								//Knopfdruck zum Festlegen von black
		black = getLightValue();								//initialisierung von black über Lichtwert den der Sensor scannt
		correction = (white + black) / 2;						//initialisierung von correction
	}
	
	public int getCorrection() {
		return correction;
	}
}
