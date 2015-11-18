package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {

	public DriveWithJoystick() {
		requires(Robot.driveTrain);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		//Robot.driveTrain.driveTrain(Robot.oi.getLeftJoystick().getY(), Robot.oi.getRightJoystick().getY());
		Robot.driveTrain.mecDrive(Robot.oi.getLeftJoystick().getX(), Robot.oi.getRightJoystick().getX(), Robot.oi.getLeftJoystick().getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.operatorJoy.getRawButton(12) == true)
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.driveTrain.driveTrain(Robot.oi.getLeftJoystick().getY()/2, Robot.oi.getRightJoystick().getY()/2);
    	Robot.driveTrain.mecDrive(Robot.oi.getLeftJoystick().getX()/2, Robot.oi.getRightJoystick().getX()/2, Robot.oi.getLeftJoystick().getY()/2);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
