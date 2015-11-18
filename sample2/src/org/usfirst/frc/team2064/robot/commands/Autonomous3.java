package org.usfirst.frc.team2064.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drive Forward Only
 */
public class Autonomous3 extends CommandGroup {

    public Autonomous3() {
    	addSequential(new DriveForward());
    }
}
