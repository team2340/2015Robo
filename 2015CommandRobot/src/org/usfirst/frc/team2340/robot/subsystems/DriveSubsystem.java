package org.usfirst.frc.team2340.robot.subsystems;

import org.usfirst.frc.team2340.robot.RobotMap;
import org.usfirst.frc.team2340.robot.commands.TankDriveCommand;

import toolkit.Direction;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {


    static private DriveSubsystem subsystem;
   
    CANTalon frontLeft;
    CANTalon backLeft;
    
    CANTalon backRight;
    CANTalon frontRight;
    
    RobotDrive tankDrive;
    
   // LiveWindow lw;
    
  

    static public DriveSubsystem getInstance() {
        System.out.println(" Drive Subsystem get instance");
        if (subsystem == null) {
            subsystem = new DriveSubsystem();
        }
        return subsystem;
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TankDriveCommand());
    }

    private DriveSubsystem() {

        createLeftSide();
        createRightSide();
        
        System.out.println(" Talon Drive System Setup ");
        tankDrive = new RobotDrive(frontLeft, frontRight);
        System.out.println(" Robot Drive created");
       
    }
    
    private void createLeftSide() {
    	try{
    	frontLeft = new CANTalon(RobotMap.FRONT_LEFT_JAG_ID);
    	backLeft = new CANTalon(RobotMap.BACK_LEFT_JAG_ID);
    	backLeft.changeControlMode(CANTalon.ControlMode.Follower);
    	backLeft.set(RobotMap.FRONT_LEFT_JAG_ID);
    	
    	} catch (Exception ex) {
    		System.out.println(" crateLeftSide FAILED");
    	}
    }
    private void createRightSide() {
    	try {
    	frontRight = new CANTalon(RobotMap.FRONT_RIGHT_JAG_ID);
    	
    	backRight = new CANTalon(RobotMap.BACK_RIGHT_JAG_ID);
    	backRight.changeControlMode(CANTalon.ControlMode.Follower);
    	backRight.set(RobotMap.FRONT_RIGHT_JAG_ID);
    	
    	} catch (Exception ex) {
    		System.out.println(" createRightSide FAILED");
    	}
    }
    
    public void setTankSpeedFull(Direction leftDirection, Direction rightDirection){
    	tankDrive.tankDrive(-1 * leftDirection.x, -1 * rightDirection.x, true);
    	
    }
    public void setTankSpeedHalf(Direction leftDirection, Direction rightDirection){
    	tankDrive.tankDrive( -1 * leftDirection.x * RobotMap.TANK_DRIVE_HALF_SPEED, -1 * rightDirection.x*RobotMap.TANK_DRIVE_HALF_SPEED, true);
    }
    public void setTankSpeedThreeQuarters(Direction leftDirection, Direction rightDirection){
    	tankDrive.tankDrive(-1 * leftDirection.x * RobotMap.TANK_DRIVE_THREE_QUARTER_SPEED, -1 * rightDirection.x*RobotMap.TANK_DRIVE_THREE_QUARTER_SPEED, true);

    }
    public void setTankSpeedOneThird(Direction leftDirection, Direction rightDirection){
    	
    	tankDrive.tankDrive(-1 * leftDirection.x * RobotMap.TANK_DRIVE_THIRD_SPEED, -1 * rightDirection.x* RobotMap.TANK_DRIVE_THIRD_SPEED, true);
    	SmartDashboard.putNumber("leftTank", frontRight.get());
    	SmartDashboard.putNumber("rightTank", frontLeft.get());
    }
}

