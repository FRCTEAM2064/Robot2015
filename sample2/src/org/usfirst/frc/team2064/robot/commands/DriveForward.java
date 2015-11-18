package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

    public DriveForward() {
        requires(Robot.driveTrain);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {;
    	for(int i = 0; i <= 160; i++){
    		Robot.driveTrain.driveTrain(-0.4, -0.4);
    		Timer.delay(0.01);
    	}
    	Robot.stop = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.stop == true)
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.stop = false;
    	Robot.driveTrain.stop();
    	Timer.delay(0.5);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
