package org.usfirst.frc.team2064.robot.subsystems;

import org.usfirst.frc.team2064.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Pneumatics subsystem contains the compressor
 */
public class Pneumatics extends Subsystem {
    
    private Compressor compressor;
    private DoubleSolenoid piston1, piston3, piston2, piston4;
    //private Solenoid piston3;

    public Pneumatics() {
		compressor = new Compressor();
		piston1 = new DoubleSolenoid(2, 3);
		piston2 = new DoubleSolenoid(0, 1);
		piston3 = new DoubleSolenoid(4, 5);
		//piston3 = new Solenoid(5);
		piston4 = new DoubleSolenoid(6, 7);
    }
	
    public void Telescope(){
    	piston2.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void retractTelescope(){
    	piston2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void forksDown(){
    	piston3.set(DoubleSolenoid.Value.kForward);
    	//piston3.set(true);
    	Robot.forks = true;
    }
    
    public void forksUp(){
    	piston3.set(DoubleSolenoid.Value.kReverse);
    	//piston3.set(false);
    	Robot.forks = false;
    }
    
    public void extendArms(){
    	piston1.set(DoubleSolenoid.Value.kForward);
    	Robot.arms = true;
    }
    
    public void retractArms(){
    	piston1.set(DoubleSolenoid.Value.kReverse);
    	Robot.arms = false;
    }
    
    public void bendArmsDown(){
    	piston4.set(DoubleSolenoid.Value.kForward);
    	Robot.forksBent = true;
    }
    
    public void bendArmsUp(){
    	piston4.set(DoubleSolenoid.Value.kReverse);
    	Robot.forksBent = false;
    }
    
    public void startCmp() {
		compressor.start();
	}
    
    public void stopCmp(){
    	compressor.stop();
    }
    
    /**
	 * @return Whether or not the system is fully pressurized.
	 */
	public boolean isPressurized() {
		if(compressor.getPressureSwitchValue() == false)
			return false;
		return true; 
	}
	
    public void initDefaultCommand() {
 
    }
}

