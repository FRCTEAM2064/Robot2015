package org.usfirst.frc.team2064.robot.subsystems;

//import org.usfirst.frc.team2064.robot.Robot;
import org.usfirst.frc.team2064.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	 private RobotDrive mdrive;
	 //private Talon rightCIM, leftCIM, rightRoller, leftRoller;
	 private AnalogInput SonicChannel;
	 private int FL, RL, FR, RR;
	 private Gyro gyro;

	 public DriveTrain(){
		 FL = 1;
		 RL = 3;
		 FR = 0;
		 RR = 2;
		 mdrive = new RobotDrive(FL, RL, FR, RR);
		 mdrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		 mdrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
		 mdrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
		 mdrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		 //change to mdrive
		 
		 //rightCIM = new Talon(5);
		 //leftCIM = new Talon(6);
		 //rightRoller = new Talon(7);
		 //leftRoller = new Talon(8);
		 //drive = new RobotDrive(leftCIM, rightCIM);
		 //SonicChannel = new AnalogInput(1);
		 gyro = new Gyro(0);
	 }
	 
	 /*public double ultrasonicDistance(){
	    double range = SonicChannel.getAverageVoltage();
	    double Distance = 512.0 * range / 5.0;
        return Distance;
     }*/
	 
	 public void resetGyro(){
		 gyro.reset();
	 }
	 
	 public double gyroAngle(){
		 if(gyro.getAngle() > 360 || gyro.getAngle() < -360)
			 gyro.reset();
		 
		 if(gyro.getAngle() < 0)
			 return 360 + gyro.getAngle();
		 else 
			 return gyro.getAngle();
	 }
	 
	 /*public String pickUpTote(){
	   	if(ultrasonicDistance() <= 8)
    		return "Go!";
	   	return "Stop!";
	 }*/
	 
	 public void mecDrive(double x, double y, double z){
		 mdrive.mecanumDrive_Cartesian(x, -y, -z, 0);
	 }
	 
	 public void driveTrain(double leftJoy, double rightJoy) {
	     mdrive.setLeftRightMotorOutputs(leftJoy, rightJoy);
	 }
	 
	 public void tankDrive(Joystick leftJoy, Joystick rightJoy){
		 mdrive.tankDrive(leftJoy, rightJoy);
	 }
	 
	 public void drive(double speed){
		 mdrive.drive(speed, 0.0);
	 }
	 
	 public void stop() {
		 //drive.tankDrive(0, 0);
		 mdrive.setLeftRightMotorOutputs(0.0, 0.0);
	 }

	 /*public void rollersForward(){
		 rightRoller.set(-0.7);
		 leftRoller.set(-0.7);
	 }
	 
	 public void rollersBack(){
		 rightRoller.set(0.7);
		 leftRoller.set(0.7);
	 }
	 
	 public void rollersStop(){
		 rightRoller.set(0.0);
		 leftRoller.set(0.0);
	 }*/
	 
     public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
     }
}

