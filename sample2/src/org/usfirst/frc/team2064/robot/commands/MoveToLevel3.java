package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveToLevel3 extends Command {
	int elevatorPos;
	
    public MoveToLevel3() {
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevatorPos = Robot.elevator.elevatorAboveorBelow(Robot.atLevel, 3);
		Robot.elevator.runElevator(elevatorPos);
		System.out.println(Robot.atLevel);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double d;
    	double distance = Robot.elevator.encoder().getDistance();
    	
    	if(Robot.elevator.speed() == 0.6)
			d = 6900;
		else
			d = 6800;
    	
		if(elevatorPos < 0 && distance >= d){ 
			Robot.atLevel = 3;
			return true; 
		}	
		else if(elevatorPos > 0 && distance <= d){ 
			Robot.atLevel = 3;
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
