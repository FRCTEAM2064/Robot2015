
package org.usfirst.frc.team2064.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.CameraServer;
import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
//import com.ni.vision.NIVision.ShapeMode;

import org.usfirst.frc.team2064.robot.commands.Autonomous;
import org.usfirst.frc.team2064.robot.commands.Autonomous2;
import org.usfirst.frc.team2064.robot.commands.Autonomous3;
import org.usfirst.frc.team2064.robot.commands.MoveToHome;
import org.usfirst.frc.team2064.robot.subsystems.Arduino;
import org.usfirst.frc.team2064.robot.subsystems.Elevator;
import org.usfirst.frc.team2064.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2064.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Elevator elevator = new Elevator();
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Arduino led = new Arduino();
	public static OI oi;
	public static int atLevel = 0;
	public static double lvlHeight = 2400;
	public static double over, difference;
	public static boolean isMotorStopped;
	public static boolean forks, arms, forksBent = false;
	public static boolean stop = false;
	
	//CameraServer server;
	int session;
    Image frame;
	Command home;
    Command autonomousCommand, autonomousCommand2, autonomousCommand3;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		//Arduino.getInstance();
		
		//server = CameraServer.getInstance();
        //server.setQuality(50);
        //server.startAutomaticCapture("cam1");
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam0",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        
        // instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
        autonomousCommand2 = new Autonomous2();
        autonomousCommand3 = new Autonomous3();
        home = new MoveToHome();
        isMotorStopped = true;
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
		//Arduino.elevatorUp();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	if (autonomousCommand != null) 
    		if(oi.operatorJoy.getRawButton(9) == true && oi.operatorJoy.getRawButton(8) == false)
    			autonomousCommand.start();
    		else if(oi.operatorJoy.getRawButton(9) == false && oi.operatorJoy.getRawButton(8) == true)
    			autonomousCommand2.start();
    		else if(oi.operatorJoy.getRawButton(9) == true && oi.operatorJoy.getRawButton(8) == true)
    			autonomousCommand3.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	//Arduino.disabled();
    	//home.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        LiveWindow.run();
        NIVision.IMAQdxStartAcquisition(session);
        log();
        
        if(pneumatics.isPressurized() == true)
        	pneumatics.stopCmp();
        else
        	pneumatics.startCmp();
        
        if(elevator.returnHome() == false)
        	elevator.encoder().reset();
        
        if(oi.operatorJoy.getRawButton(6) == true)
        	Arduino.elevatorUp();
        else if(oi.operatorJoy.getRawButton(7) == true)
        	Arduino.elevatorDown();
        else
        	Arduino.defaultLEDs();

        /*if(isMotorStopped == true && atLevel != 0){
        	over = atLevel * lvlHeight;
        	difference = elevator.encoder().getDistance() - over;
        	if(difference > 0)
        		elevator.elevatorOver(over);
        	else if(difference < 0)
        		elevator.elevatorUnder(over);
        }*/	

        //Arduino.enabled();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        log();
    }
    
    @SuppressWarnings("deprecation")
	private void log(){
    	//SmartDashboard.putNumber("Elevator Level", atLevel);
    	LiveWindow.addSensor("encoder", "encValue", elevator.enc);
    	SmartDashboard.putNumber("Encoder Value ", elevator.encoder().getDistance());
    	//SmartDashboard.putDouble("Distance      ", driveTrain.ultrasonicDistance());
		//SmartDashboard.putString("Pickup Tote ", driveTrain.pickUpTote());
		//SmartDashboard.putDouble("Gyro Value", driveTrain.gyroAngle());
    }
}
