package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AcquateClose2Command extends Command {
	public AcquateClose2Command(){
		requires(Robot.acquisition);
		setTimeout(0.25);
		
	}

	@Override
	protected void initialize() {
		Robot.acquisition.close2();
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
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
