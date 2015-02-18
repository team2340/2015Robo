package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;

import toolkit.Direction;
import toolkit.LogitechF310;
import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCommand extends Command {
    private LogitechF310 controller;
	private Direction leftStick;
	private Direction rightStick;
	private Direction dpad;
	
    
public TankDriveCommand() {
    requires(Robot.drive);
    controller = Robot.oi.getDriveController();   
}

protected void initialize() {}

protected void execute() { 
	leftStick = controller.getLeftStick();
	rightStick = controller.getRightStick();
	
	dpad = controller.getDPad();
	
	if (controller.getLB() && controller.getRB()) {
		System.out.println(" Third Speed");
		Robot.drive.setTankSpeedOneThird(leftStick, rightStick);
	}
	else if (controller.getRB()) {
		System.out.println(" Three Quarter Speed");
		Robot.drive.setTankSpeedThreeQuarters(leftStick, rightStick);
	} else if (controller.getLB()) {
		System.out.println(" Half Speed ");
		Robot.drive.setTankSpeedHalf(leftStick, rightStick);
	}  else {
	Robot.drive.setTankSpeedFull(leftStick, rightStick);	
	}
	
}	



	protected boolean isFinished() { return false; }

	protected void end() { }

	protected void interrupted() {  }



private void controlWithJoySticks(){
	if (controller.getLB() && controller.getRB()) {
		System.out.println(" Third Speed");
		Robot.drive.setTankSpeedOneThird(leftStick, rightStick);
	}
	else if (controller.getRB()) {
		System.out.println(" Three Quarter Speed");
		Robot.drive.setTankSpeedThreeQuarters(leftStick, rightStick);
	} else if (controller.getLB()) {
		System.out.println(" Half Speed ");
		Robot.drive.setTankSpeedHalf(leftStick, rightStick);
	}  else {
	Robot.drive.setTankSpeedFull(leftStick, rightStick);	
	
	}
}
private void controlWithDpad() {
	if (controller.getLB() && controller.getRB()) {
		System.out.println(" Third Speed");
		Robot.drive.setTankSpeedOneThird(dpad, dpad);
	}
	else if (controller.getRB()) {
		System.out.println(" Three Quarter Speed");
		Robot.drive.setTankSpeedThreeQuarters(dpad, dpad);
	} else if (controller.getLB()) {
		System.out.println(" Half Speed ");
		Robot.drive.setTankSpeedHalf(dpad, dpad);
	}  else {
	Robot.drive.setTankSpeedFull(dpad, dpad);	
	
	}
	}

}


