package org.usfirst.frc.team2064.robot.commands;

import org.usfirst.frc.team2064.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnRightDF extends Command {

    public TurnRightDF() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for(int i = 0; i <= 200; i++){
    		Robot.driveTrain.driveTrain(0.4, -0.4);
    		Timer.delay(0.01);
    	}
    	/*Robot.driveTrain.resetGyro();
    	while(Robot.driveTrain.gyroAngle() < 90)
    		Robot.driveTrain.driveTrain(-0.7, 0.7);*/
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
    	double speed = 0;
    	for(int j = 1; j <= 240; j++){
    		if(j <= 50)
    			speed = 0.4;
            else if (j >= 200)
            	speed = 0.4;
            else
                speed = 0.6;
    		Robot.driveTrain.driveTrain(speed, speed); 
            Timer.delay(0.01); 
    	}
    	Timer.delay(0.5);
    	for(int i = 0; i <= 200; i++){
    		Robot.driveTrain.driveTrain(0.4, -0.4);
    		Timer.delay(0.01);
    	}
    	//Robot.pneumatics.extendArms();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}