package org.usfirst.frc.team2064.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arduino extends Subsystem {
    public static Arduino instance = null;
    private static DigitalOutput d1, d2;

    public Arduino(){
    	d1 = new DigitalOutput(3); //Arduino - 8
    	d2 = new DigitalOutput(4); //Arduino - 9
    	//d3 = new DigitalOutput(5); //Arduino - 10
    }

    public static Arduino getInstance(){
    	if(instance == null)
    		instance = new Arduino();
    	return instance;
    }
    
    public static void elevatorDown(){
    	d1.set(false);
    	d2.set(true);
        //d3.set(false);
    }
    
    public static void defaultLEDs(){
    	d1.set(false);
    	d2.set(false);
    	//d3.set(true);
    }
    
    public static void elevatorUp(){
    	d1.set(true);
    	d2.set(false);
    	//d3.set(false);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

