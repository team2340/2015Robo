package org.usfirst.frc.team2340.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AcquisitionSubsystem extends Subsystem {
	
	static private AcquisitionSubsystem subsystem;
	private Compressor compressor;
	private Solenoid festioSolenoid;
	private Solenoid festioSolenoid2;
	
	private AcquisitionSubsystem () {
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		
		festioSolenoid = new Solenoid(9, 0);
		festioSolenoid2 = new Solenoid(9, 1);
		System.out.println("acquisition Subsystem created");
		
	}

	public static AcquisitionSubsystem getInstance() {
		if (subsystem == null) {
			subsystem = new AcquisitionSubsystem() ;
		}
		return subsystem;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	

	}

	public void open(){
		System.out.println("Open command");
		festioSolenoid.set(true);
	}
	public void close(){
		System.out.println("Close command");
		festioSolenoid.set(false);
	}
	public void open2(){
		festioSolenoid2.set(true);
	}
	public void close2(){
		festioSolenoid2.set(false);
	}
	
}
