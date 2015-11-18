package org.usfirst.frc.team2064.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2064.robot.commands.ArmsBendDown;
//import org.usfirst.frc.team2064.robot.commands.ArmsBendUp;
import org.usfirst.frc.team2064.robot.commands.ArmsExtend;
import org.usfirst.frc.team2064.robot.commands.ArmsRetract;
import org.usfirst.frc.team2064.robot.commands.ForksDown;
//import org.usfirst.frc.team2064.robot.commands.ForksUp;
//import org.usfirst.frc.team2064.robot.commands.RetractTelescope;
import org.usfirst.frc.team2064.robot.commands.Telescope;
import org.usfirst.frc.team2064.robot.commands.MoveElevatorDown;
import org.usfirst.frc.team2064.robot.commands.MoveElevatorUp;
import org.usfirst.frc.team2064.robot.commands.MoveToHome;
import org.usfirst.frc.team2064.robot.commands.MoveToLevel1;
import org.usfirst.frc.team2064.robot.commands.MoveToLevel2;
import org.usfirst.frc.team2064.robot.commands.MoveToLevel3;
import org.usfirst.frc.team2064.robot.commands.MoveToLevel4;
//import org.usfirst.frc.team2064.robot.commands.MoveToLevel5;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public Joystick operatorJoy = new Joystick(0);
	//public Joystick driverStation = new Joystick (3);
	public Joystick driveLeftJoy = new Joystick(1);
	public Joystick driveRightJoy = new Joystick(2);
	
	private Button lvl1 = new JoystickButton(operatorJoy, 1),
				   lvl2 = new JoystickButton(operatorJoy, 2),
				   lvl3 = new JoystickButton(operatorJoy, 3),
				   lvl4 = new JoystickButton(operatorJoy, 4),
				   //lvl5 = new JoystickButton(operatorJoy, 5),
				   home = new JoystickButton(operatorJoy, 5),
				   up = new JoystickButton(operatorJoy, 6),
				   down = new JoystickButton(operatorJoy, 7),
				   forksDown = new JoystickButton(operatorJoy, 8),
				   //forksUp = new JoystickButton(operatorJoy, 9),
				   bendArmsDown = new JoystickButton(operatorJoy, 9),
				   //bendArmsUp = new JoystickButton(operatorJoy, 11),
				   telescope = new JoystickButton(operatorJoy, 10),
				   //retractTelescope = new JoystickButton(operatorJoy, 13),
				   
				   extendArms = new JoystickButton(driveLeftJoy, 1),
				   retractArms = new JoystickButton(driveRightJoy, 1);
				   //runRollersForward = new JoystickButton(driveRightJoy, 2),
				   //runRollersReverse = new JoystickButton(driveRightJoy, 3);
				   //lowGear = new JoystickButton(driveLeftJoy, 4);
	
	public OI(){
		lvl1.whenPressed(new MoveToLevel1());
		lvl2.whenPressed(new MoveToLevel2());
		lvl3.whenPressed(new MoveToLevel3());
		lvl4.whenPressed(new MoveToLevel4());
		//lvl5.whenPressed(new MoveToLevel5());
		home.whenPressed(new MoveToHome());
		up.whileHeld(new MoveElevatorUp());
		down.whileHeld(new MoveElevatorDown());
		//runRollersForward.whileHeld(new RollersForward());
		//runRollersReverse.whileHeld(new RollersReverse());
		telescope.whenPressed(new Telescope());
		//retractTelescope.whenPressed(new RetractTelescope());
		forksDown.whenPressed(new ForksDown());
		//forksUp.whenPressed(new ForksUp());
		extendArms.whenPressed(new ArmsExtend());
		retractArms.whenPressed(new ArmsRetract());
		bendArmsDown.whenPressed(new ArmsBendDown());
		//bendArmsUp.whenPressed(new ArmsBendUp());
		//lowGear.whileHeld(new LowGear());
		
		SmartDashboard.putData("Move To Home   ", new MoveToHome());
		SmartDashboard.putData("Move To Level 1", new MoveToLevel1());
		SmartDashboard.putData("Move To Level 2", new MoveToLevel2());
		SmartDashboard.putData("Move To Level 3", new MoveToLevel3());
		SmartDashboard.putData("Move To Level 4", new MoveToLevel4());
		//SmartDashboard.putData("Move To Level 5", new MoveToLevel5());
	}
	
	public Joystick getLeftJoystick() {
        return driveLeftJoy;
    }
	
	public Joystick getRightJoystick() {
        return driveRightJoy;
    }
}

