package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveToHome extends Command {
	int elevatorPos;
	
    public MoveToHome() {
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//elevatorPos = Robot.elevator.elevatorAboveorBelow(Robot.atLevel, 0);
		//Robot.elevator.runElevator(elevatorPos);
		//System.out.println(Robot.atLevel);
    	Robot.elevator.goHome();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.elevator.returnHome() == false){
    		Robot.atLevel = 0;
    		Robot.elevator.encoder().reset();
    		System.out.println(Robot.elevator.encoder().getDistance());
    		return true;
    	}	
		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stopMotor();
    	Robot.elevator.encoder().reset();
		System.out.println(Robot.atLevel);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}