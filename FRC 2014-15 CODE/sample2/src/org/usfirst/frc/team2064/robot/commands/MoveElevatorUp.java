package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorUp extends Command {

    public MoveElevatorUp() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.runMotorUp();
    	double distance = Robot.elevator.encoder().getDistance();
    	Robot.atLevel = (int) (distance/2400);
    	System.out.println(Robot.atLevel);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.elevator.encoder().getDistance() < 0)
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.stopMotor();
    }
}
