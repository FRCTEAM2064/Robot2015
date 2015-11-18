package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Telescope extends Command {

    public Telescope() {
        requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pneumatics.Telescope();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.operatorJoy.getRawButton(10) == false)
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatics.retractTelescope();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
