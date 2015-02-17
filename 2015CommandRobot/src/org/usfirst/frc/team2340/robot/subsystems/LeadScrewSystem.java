package org.usfirst.frc.team2340.robot.subsystems;

import org.usfirst.frc.team2340.robot.RobotMap;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LeadScrewSystem extends Subsystem {
	
	static private LeadScrewSystem subsystem;
	
	 CANTalon leadScrew;
	 CANTalon followScrew;

	@Override
	protected void initDefaultCommand() {
	}

	
    static public LeadScrewSystem getInstance() {
        System.out.println(" Drive Subsystem get instance");
        if (subsystem == null) {
            subsystem = new LeadScrewSystem();
        }
        return subsystem;
    }



    private LeadScrewSystem() {
	
        System.out.println("2015 Lead Screw Subsystem created");
        try {
        leadScrew = new CANTalon(RobotMap.LEAD_SCREW_ONE_ID);
        followScrew = new CANTalon(RobotMap.LEAD_SCREW_TWO_ID);
        followScrew.changeControlMode(CANTalon.ControlMode.Follower);
    	followScrew.set(RobotMap.LEAD_SCREW_ONE_ID);
       
        } catch (Exception ex) {
        	System.out.println("CAN Talon Exception");
        }
        
       
    }
    
    public void driveUp() {
    	leadScrew.set(1);
    	
    }
    
    public void driveDown() {
    	leadScrew.set(-1);
    	
    }
    public void stop(){
    	leadScrew.set(0.0);
    }
}
