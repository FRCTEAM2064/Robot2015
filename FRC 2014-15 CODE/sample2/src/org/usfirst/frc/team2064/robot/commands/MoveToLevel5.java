package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveToLevel5 extends Command {
	int elevatorPos;
	
    public MoveToLevel5() {
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevatorPos = Robot.elevator.elevatorAboveorBelow(Robot.atLevel, 5);
		Robot.elevator.runElevator(elevatorPos);
		System.out.println(Robot.atLevel);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double distance = Robot.elevator.encoder().getDistance();
		if(elevatorPos < 0 && distance >= 5120){ 
			Robot.atLevel = 5;
			return true; 
		}	
		else if(elevatorPos > 0 && distance <= 5120){ 
			Robot.atLevel = 5;
			return true;
		}	
		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stopMotor();
		System.out.println(Robot.atLevel);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
