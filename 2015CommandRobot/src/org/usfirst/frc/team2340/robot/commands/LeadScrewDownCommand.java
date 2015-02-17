package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LeadScrewDownCommand extends Command {
	public LeadScrewDownCommand() {
		requires(Robot.lead);
		setTimeout(0.5);
		
	}

	@Override
	protected void initialize() {
		Robot.lead.driveDown();
	}

	@Override
	protected void execute() {
		

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.lead.stop();

	}

	@Override
	protected void interrupted() {
		Robot.lead.stop();

	}

}
