package org.usfirst.frc.team2340.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public final static int BUTTON_X =1;
	public final static int BUTTON_Y = 4;
	public final static int BUTTON_A = 2;
	public final static int BUTTON_B = 3;
	public final static int BUTTON_LB = 5;
	public final static int BUTTON_RB = 6;
	public final static int BUTTON_LT = 7;
	public final static int BUTTON_RT = 8;
	public final static int BUTTON_BACK = 9;
	public final static int BUTTON_START = 10;
	public static final int DRIVE_PORT = 1;
	public static final int ACQUISITION_PORT = 2;
	public static final int FRONT_LEFT_JAG_ID = 4;
	public static final int BACK_LEFT_JAG_ID = 5;
	public static final int FRONT_RIGHT_JAG_ID = 3;
	public static final int BACK_RIGHT_JAG_ID = 2;
	public static final int LEAD_SCREW_ONE_ID = 6;
	public static final int LEAD_SCREW_TWO_ID = 7;
}
