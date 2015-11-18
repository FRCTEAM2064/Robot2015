package org.usfirst.frc.team2064.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Tote
 */
public class Autonomous2 extends CommandGroup {

    public Autonomous2() {
    	//addSequential(new LiftAuto());
    	//addSequential(new DriveForward());
    	addSequential(new ClampAuto());
    	addSequential(new TurnRightDF());
    }
}
