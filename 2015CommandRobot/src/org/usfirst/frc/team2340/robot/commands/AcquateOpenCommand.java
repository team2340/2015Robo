package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AcquateOpenCommand extends Command {
	
	 public AcquateOpenCommand() {
		// TODO Auto-generated constructor stub
		 requires(Robot.acquisition);
		 
	}

	@Override
	protected void initialize() {
		Robot.acquisition.close();
		
		Robot.acquisition.open2();
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
