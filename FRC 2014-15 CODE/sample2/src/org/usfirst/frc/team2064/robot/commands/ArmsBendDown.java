package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmsBendDown extends Command {

    public ArmsBendDown() {
    	requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if(Robot.arms == false)
    		Robot.pneumatics.bendArmsDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.operatorJoy.getRawButton(9) == false)
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatics.bendArmsUp();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
