package org.usfirst.frc.team2340.robot;


import org.usfirst.frc.team2340.robot.commands.AcquateCommand;
import org.usfirst.frc.team2340.robot.commands.AcquisitionNotificationCommand;
import org.usfirst.frc.team2340.robot.commands.DriverNotificationCommand;
import org.usfirst.frc.team2340.robot.commands.LeadScrewDownCommand;
import org.usfirst.frc.team2340.robot.commands.LeadScrewUpCommand;

import toolkit.Direction;
import toolkit.LogitechF310;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	 LogitechF310 driveController = new LogitechF310("Drive Controller",
	            RobotMap.DRIVE_PORT);
	    
	    LogitechF310 acquistionController = new LogitechF310("Shooter Controller",
	            RobotMap.ACQUISITION_PORT);
	    
	      public OI() {
	      System.out.println(" IO Created");
	      //    checkacquistionController();
	      //    checkDriverController();

	         

	    }
	    public void checkForDriverInput() {
	    	checkacquistionController();
	    	checkDriverController();
	    }
	    private void checkacquistionController(){
	    	acquistionController.getStartButton().whenPressed(new AcquisitionNotificationCommand());
	    	acquistionController.getYButton().whenPressed(new LeadScrewUpCommand());
	    	acquistionController.getAButton().whenPressed(new LeadScrewDownCommand());
	    	acquistionController.getBButton().whenPressed(new AcquateCommand());
	    	/*
	        acquistionController.getStartButton().whenPressed();
	       
	        acquistionController.getXButton().whenPressed( );
	        acquistionController.getYButton().whenPressed();
	        
	        acquistionController.getBButton().whenPressed();
	        acquistionController.getAButton().whenPressed();
	        
	        acquistionController.getRBButton().whenPressed();
	        acquistionController.getRTButton().whenPressed();
	        
	        acquistionController.getLBButton().whenPressed();
	        acquistionController.getLTButton().whenPressed();
	          */
	                }
	    private void checkDriverController(){    
	    	driveController.getStartButton().whenPressed(new DriverNotificationCommand());
	        //driveController.getStartButton().whenPressed());
	        
	        //driveController.getXButton().whenPressed(new LowerArm() );
	        //driveController.getYButton().whenPressed(new RaiseArm());
	        
	       // driveController.getBButton().whenPressed(new AcquireBallCommand());
	       // driveController.getAButton().whenPressed(new RepelBallCommand());
	        
	        //driveController.getRBButton().whenPressed(new ShootBall());
	        
	       // driveController.getLBButton().whenPressed(new LookUp());
	      //  driveController.getLTButton().whenPressed(new LookDown());
	      
	      
	    }
	    
	    public double getRightStickY() {
	        return driveController.getRightStick().getY();
	    }
	    
	    public double getLeftStickY() {
	        return driveController.getLeftStick().getY();
	    }
	    
	    public Direction getRightStick() {
	        return driveController.getRightStick();
	    }
	    
	    public LogitechF310 getDriveController() {
	        return driveController;
	    }


}

