package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;
import org.usfirst.frc.team2340.robot.RobotMap;
import org.usfirst.frc.team2340.robot.subsystems.LeadScrewSystem;

import edu.wpi.first.wpilibj.command.Command;

public class LeadScrewUpCommand extends Command {
	public LeadScrewUpCommand() {
		requires(Robot.lead);
		setTimeout(RobotMap.LEAD_SCREW_UP_SPEED);
		
	}
	

	@Override
	protected void initialize() {
		Robot.lead.driveUp();

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
