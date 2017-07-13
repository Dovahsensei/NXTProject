package nxtRobo;

import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.TachoMotorPort;

public class NXTWheel extends NXTRegulatedMotor{S
	
	final int normalVelocity = 150; //Geschwindigkeit in rad/min
	
	public NXTWheel(TachoMotorPort port){
		super(port);
	}
}
