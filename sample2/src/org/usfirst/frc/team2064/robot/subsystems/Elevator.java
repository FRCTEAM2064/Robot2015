package org.usfirst.frc.team2064.robot.subsystems;

import org.usfirst.frc.team2064.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private Victor t1;
    private DigitalInput lSwitch;
	public Encoder enc; //may need to change to private
	//private double distance; 
	
    public Elevator(){
    	t1 = new Victor(4);
    	lSwitch = new DigitalInput(2);
		enc = new Encoder(0, 1, false);
		enc.setDistancePerPulse(1);
    }
    
    public boolean returnHome(){
    	return lSwitch.get();
    }
    
    public double speed(){
    	if(Robot.oi.operatorJoy.getRawButton(11) == true)
    		return 1.0;
    	return 0.6;
    }
    
    public int elevatorAboveorBelow(int atLevel, int goToLevel){
		int elevatorPos = atLevel - goToLevel;
		return elevatorPos;
	}
	
	public void runElevator(int elevatorPos){
		if(elevatorPos > 0){
			t1.set(speed());
			Robot.isMotorStopped = false;
		}
		else if(elevatorPos < 0){
			t1.set(-speed());
			Robot.isMotorStopped = false;
		}
	}
	
	public void goHome(){
		t1.set(speed());
		Robot.isMotorStopped = false;
	}
	
	public Encoder encoder() {
		return enc;
	}
	
	public void runMotorDown(){
		t1.set(speed());
		Robot.isMotorStopped = false;
	}
	
	public void runMotorUp(){
		t1.set(-speed());
		Robot.isMotorStopped = false;
	}
	
	public void stopMotor(){
		t1.set(0.0);
		Robot.isMotorStopped = true;
	}
	
	public void elevatorOver(double stop){
		if(encoder().getDistance() > stop){
			t1.set(0.1);
			Robot.isMotorStopped = false;
		}	
		else{
			t1.set(0.0);
			Robot.isMotorStopped = true;
		}	
	}
	
	public void elevatorUnder(double stop){
		if(encoder().getDistance() < stop){
			t1.set(-0.1);
			Robot.isMotorStopped = false;
		}	
		else{
			t1.set(0.0);
			Robot.isMotorStopped = true;
		}	
	}
	
    public void initDefaultCommand() {

    }
}


