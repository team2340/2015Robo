package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;

import toolkit.LogitechF310;
import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCommand extends Command {
    private LogitechF310 controller;
    
public TankDriveCommand() {
    requires(Robot.drive);
    controller = Robot.oi.getDriveController();
}
protected void initialize() {}

protected void execute() { 
  Robot.drive.setTankSpeed(controller.getLeftStick(), controller.getRightStick());
     
}

protected boolean isFinished() { return false; }

protected void end() {  }

protected void interrupted() {  }

}
