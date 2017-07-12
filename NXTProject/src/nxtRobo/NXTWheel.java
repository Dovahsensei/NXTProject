package nxtRobo;

import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.TachoMotorPort;

public class NXTWheel extends NXTRegulatedMotor{
	
	final int normalVelocity = 150;
	
	public NXTWheel(TachoMotorPort port){
		super(port);
	}
	
	
}
