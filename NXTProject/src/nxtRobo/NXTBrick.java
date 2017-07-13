package nxtRobo;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;

public class NXTBrick {			
	public static final NXTAxis ax = new NXTAxis();								//Deklaration und Initialisierung der Achsen
	public static final NXTUltrasonicS us = new NXTUltrasonicS(SensorPort.S1);	//Deklaration und Initialisierung des Ultraschallsensors
	public static final NXTLightSensor ls = new NXTLightSensor(SensorPort.S2);	//Deklaration und Initialisierung des Farbsensors
	public static final TouchSensor ts = new TouchSensor(SensorPort.S3);		//Deklaration und Initialisierung des Berührungssensor

	public NXTBrick() {

		ls.newLine();							//Aufrufen der Methode newLine() der Klasse LightSensor
		followLine(ls.getCorrection());				//Aufrufen der Methode followLine() mit dem Parameter int correction
		
		ax.backAndTurnRight();					//Aufrufen der Methode backAndTurnRight() aus der Klasse NXTAxis
		us.setOptimalDistance();				//Aufrufen der Methode setOptimalDistance() aus der Klasse UltrasonicSensor
		followWall(us.getOptimalDistance());	//Aufrufen der Methode folowWall() mit dem Parameter int getOptimalDistance

	}

	public void followLine(int correction) {				//Methode, um den Mindstorms eine Linie entlangfahren zu lassen
		while (true) {
			System.out.println("actual lightvalue: " + ls.getLightValue());	//Ausgabe des aktuellen Lichtwerts
			if (ls.getLightValue() < correction) {			//1. Möglicheit: Wenn der eingelesene Lichtwert kleiner als vorher gemessene Richtert ist,
				ax.correctCurve(50, -50);					//dann wird der rechte Motor um 50 rounds/min beschleunit und der linke Motor um 50 rounds/min abgebremst
			}
			if (ls.getLightValue() > correction) {			//2. Möglicheit: Wenn der eingelesene Lichtwert größer als vorher gemessene Richtert ist,
				ax.correctCurve(-50, 50);					//dann wird der rechte Motor um 50 rounds/min abgebremst und der linke Motor um 50 rounds/min beschleunigt
			}
			if (ls.getLightValue() == correction) {			//2. Möglicheit: Wenn der eingelesene Lichtwert gleich dem vorher gemessenen Richtert ist,
				ax.correctCurve(0, 0);						//dann wird der bleibt die Gschwindigkeit beider Motoren gleich
			}
			if (ts.isPressed()) {							//Sobald der Berührungssensor gedrückt ist, wird die Schleife abgebrochen
				Sound.buzz();
				break;
			}
			LCD.clear();									//Das Display wird geleert
		}
	}

	public void followWall(int optimalDistance) {			//Mehtode, um den Mindstorms an einer  Wand links von ihm entlangfahren zu lassen
		while (true) {
			System.out.println("actual distance: " + us.getDistance());	//Ausgabe der aktuellen Entfernung zur Wand
			if (us.getDistance() > optimalDistance) {		//1. Möglichkeit: Wenn der aktuell gemessene Abstand größer als der Richtwert ist, dann wird
				ax.correctCurve(20, -20);					//der rechte Motor um 20 rounds/min beschleunigt und der linke Motor um 20 rounds/min abgebremst.
			}
			if (us.getDistance() < optimalDistance) {		//1. Möglichkeit: Wenn der aktuell gemessene Abstand kleiner als der Richtwert ist, dann wird
				ax.correctCurve(-20, 20);					//der rechte Motor um 20 rounds/min abgebremst und der linke Motor um 20 rounds/min beschleunigt.
			}
			if (us.getDistance()  == optimalDistance){		//1. Möglichkeit: Wenn der aktuell gemessene Abstand gleich dem Richtwert ist, dann wird
				ax.correctCurve(0, 0);						//der rechte Motor um 20 rounds/min abgebremst und der linke Motor um 20 rounds/min beschleunigt
			}
			if (ts.isPressed()) {							//sobald der Berührungssensor gedrückt wird, wird die Schleife abgebrochen.
				Sound.buzz();
				break;
			}
			LCD.clear();									//das Display wird geleert
		}
	}

	public static void main(String[] args) {
		
		NXTBrick brain = new NXTBrick();					//Erschaffen des Objekts brain 	
		
	}
}