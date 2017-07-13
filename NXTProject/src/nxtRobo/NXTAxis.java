package nxtRobo;

import lejos.nxt.MotorPort;

public class NXTAxis {
	
	public static final NXTWheel rightWheel = new NXTWheel(MotorPort.A);	//deklaration und initialisierung des rechten Rads
	public static final NXTWheel leftWheel = new NXTWheel(MotorPort.C);		//deklaration und initialisierung des linken Rads
	
	public NXTAxis(){
		
	}
	
	public void correctCurve(int correctionRightWheel, int correctionLeftWheel){	//Methode zur Korrektur der Richtung
		rightWheel.setSpeed(rightWheel.normalVelocity + correctionRightWheel);		//Anpassung der Geschwindigkeit des rechten Rads
		leftWheel.setSpeed(leftWheel.normalVelocity + correctionLeftWheel);			//Anpassung der Geschwindigkeit des linken Rads
		rightWheel.forward();		//aktivierung des linken Rads in Richtug vorwärts
		leftWheel.forward();		//aktivierung des rechten Radsin Richtug vorwärts
	}
	
	public void backAndTurnRight(){		//Methode um von einer Wands orthogonal wegzufahren und sich zu drehen
		rightWheel.stop();				//stopp des rechten Rads
		leftWheel.stop();				//stopp des linken Rads
		rightWheel.setSpeed(180);		//Geschwindigkeit des rechten Rads auf 0,5 rounds/min
		leftWheel.setSpeed(180);		//Geschwindigkeit des rechten Rads auf 0,5 rounds/min
		rightWheel.backward();			//aktivierung des linken Rads in Richtug rückwärts
		leftWheel.backward();			//aktivierung des linken Rads in Richtug rückwärts
		try{							
			Thread.sleep(4000);			//4000ms warten, also 4s
		} catch(Exception e){
			System.err.println("Thread.sleep() fehlgeschlagen");
		}
		/*Der Mindstorms soll sich um 90° nach rechts drehen
		 *11cm ist der Radabstand, 5cm ist der Raddurchmesser
		 *1/4 steht für den Viertelkreis, da sich der Mindstorms um 90° drehen soll
		 *U=pi*d
		 *11cm*pi*1/4=5cm*pi*X  |/pi |/5
		 *11/(5*4)=X
		 *es erbigt sich als Bogenmaß 11/(5*4)*360
		 */
		rightWheel.rotate((int) (-11f / (5*4) * 360), true);	//das rechte Rad soll soll um -(11 / (5*4) * 360) rad drehen,true , damit die Methode die Rückgabe gibt vor Abblauf der Rotation
		leftWheel.rotate((int) (11f / (5*4) * 360));			//das linke Rad soll soll um 11 / (5*4) * 360 rad drehen
	}
}