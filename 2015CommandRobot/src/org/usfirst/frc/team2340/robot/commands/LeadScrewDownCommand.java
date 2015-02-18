package org.usfirst.frc.team2340.robot.commands;

import org.usfirst.frc.team2340.robot.Robot;
import org.usfirst.frc.team2340.robot.RobotMap;
import org.usfirst.frc.team2340.robot.subsystems.LeadScrewSystem;

import edu.wpi.first.wpilibj.command.Command;

public class LeadScrewDownCommand extends Command {
	public LeadScrewDownCommand() {
		requires(Robot.lead);
		setTimeout(RobotMap.LEAD_SCREW_DOWN_SPEED);
		
	}
	/*private void initializeLimits() {
        try {
        bottomLimit = !LeadScrewSystem.getReverseLimitOK();
        }
        catch (Exception ex) {
            System.out.println("initialLimits Exception");
        }
    }
        
    public boolean moveDown() {
        boolean limit = true;
        try {
            LeadScrewSystem.setX(BOX_DOWN_SPEED);
            limit = !LeadScrewSystem.getReverseLimitOK();
        } catch (CANTimeoutException ex) {
            System.out.println("Move Down Exception");
        }
        return limit;
    }*/

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
