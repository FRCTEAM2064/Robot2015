package org.usfirst.frc.team2064.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Only Recycle Bin
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	addSequential(new LiftAuto());
    	//addSequential(new DriveForward());
    	addSequential(new ClampAuto());
    	addSequential(new TurnAndDriveForward());
    	//addSequential(new MoveToHome());
    }
}
