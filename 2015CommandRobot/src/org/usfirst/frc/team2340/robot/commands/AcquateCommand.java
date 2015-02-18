package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
	
public class AcquateCommand extends Command {
	public AcquateCommand() {
		requires(Robot.acquisition);
		setTimeout(0.5);
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		System.out.println(" Test Execute");
		Robot.acquisition.close();
		
		Robot.acquisition.open2();

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		System.out.println(" End Execute");
		Robot.acquisition.close2();
		Robot.acquisition.open();
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
