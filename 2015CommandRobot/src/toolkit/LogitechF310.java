/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

/**
 *
 * @author NAZareX Robotics
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.usfirst.frc.team2340.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import team2340.RobotMap;

/**
 *
 * @author NAZareX Robotics
 */
public class LogitechF310 implements Runnable {

    int port;
    Joystick joystick;
    Button buttonX;
    Button buttonY;
    Button buttonA;
    Button buttonB;
    Button buttonLB;
    Button buttonRB;
    Button buttonLT;
    Button buttonRT;
    Button buttonBack;
    Button buttonStart;
    double min = 0.04;
    private String buttonPressed = "NO";
    // logger;
    
    String name;

    Thread runner;
    
    public LogitechF310(String name, int port) {
        this.port = port;
        this.name = name;
        joystick = new Joystick(port);
        buttonX = new JoystickButton(joystick, RobotMap.BUTTON_X);
        buttonY = new JoystickButton(joystick, RobotMap.BUTTON_Y);
        buttonA = new JoystickButton(joystick, RobotMap.BUTTON_A);
        buttonB = new JoystickButton(joystick, RobotMap.BUTTON_B);
        buttonLB = new JoystickButton(joystick, RobotMap.BUTTON_LB);
        buttonRB = new JoystickButton(joystick, RobotMap.BUTTON_RB);
        buttonLT = new JoystickButton(joystick, RobotMap.BUTTON_LT);
        buttonRT = new JoystickButton(joystick, RobotMap.BUTTON_RT);
        buttonBack = new JoystickButton(joystick, RobotMap.BUTTON_BACK);
        buttonStart = new JoystickButton(joystick, RobotMap.BUTTON_START);

    }
    
    public void init() {
        runner.start();
    }

    public boolean getX() {
        return joystick.getRawButton(RobotMap.BUTTON_X);

    }

    public Button getXButton() {
        return buttonX;
    }
    
    public boolean getY() {
        return joystick.getRawButton(RobotMap.BUTTON_Y);
    }
    
    public Button getYButton() {
        return buttonY;
    }

    public boolean getA() {
        return joystick.getRawButton(RobotMap.BUTTON_A);
    }
    
    public Button getAButton() {
        return buttonA;
    }

    public boolean getB() {
        return joystick.getRawButton(RobotMap.BUTTON_B);
    }

    public Button getBButton() {
        return buttonB;
    }
    
    public boolean getLB() {
        return joystick.getRawButton(RobotMap.BUTTON_LB);
    }

    public Button getLBButton() {
        return buttonLB;
    }
    
    public boolean getRB() {
        return joystick.getRawButton(RobotMap.BUTTON_RB);
    }

    public Button getRBButton() {
        return buttonRB;
    }
    
    public boolean getLT() {
        return joystick.getRawButton(RobotMap.BUTTON_LT);
    }

    public Button getLTButton() {
        return buttonLT;
    }
    
    public boolean getRT() {
        return joystick.getRawButton(RobotMap.BUTTON_RT);
    }
    
    public Button getRTButton() {
        return buttonRT;
    }

    public boolean getBack() {
        return joystick.getRawButton(RobotMap.BUTTON_BACK);
    }

    public Button getBackButton() {
        return buttonBack;
    }
    
    public boolean getStart() {
        return joystick.getRawButton(RobotMap.BUTTON_START);
    }
    
    public Button getStartButton() {
        return buttonStart;
    }

    public Direction getDPad() {
        if(joystick == null)
        {
            System.out.println("joystick is null");
        }
        return new Direction(limit(joystick.getRawAxis(5)),
                (-1 * limit(joystick.getRawAxis(6))));

    }

    public Direction getLeftStick() {
        return new Direction((joystick.getRawAxis(1)),
                (-1 * (joystick.getRawAxis(2))));
    }
    
    public double getMag() {
        return joystick.getMagnitude();
    }
    
    public double getDeg() {
        return joystick.getDirectionDegrees();
    }

    public Direction getRightStick() {
        return new Direction((joystick.getRawAxis(3)),
                (-1 * (joystick.getRawAxis(4))));
    }

    private double limit(double value) {
        if ((value > 0 && value < 0.04) || 
                (value < 0 && value > -0.04)) {
            return 0.0;
        }
        return value;
    }
    
    

    public void printState() {
        if (getX()) {
            System.out.println("F310 on " + port + " - X is pushed");
           
        }
        if (getY()) {
            System.out.println("F310 on " + port + " - Y is pushed");
        }
    //    Watchdog.getInstance().feed();
        if (getA()) {
            System.out.println("F310 on " + port + " - A is pushed");
        }
        if (getB()) {
            System.out.println("F310 on " + port + " - B is pushed");
        }
        if (getLB()) {
            System.out.println("F310 on " + port + " - LB is pushed");
        }
        if (getRB()) {
            System.out.println("F310 on " + port + " - RB is pushed");
        }
        if (getLT()) {
            System.out.println("F310 on " + port + " - LT is pushed");
        }
   //     Watchdog.getInstance().feed();
        if (getRT()) {
            System.out.println("F310 on " + port + " - RT is pushed");
        }
     //   Watchdog.getInstance().feed();
        if (getBack()) {
            System.out.println("F310 on " + port + " - Back is pushed");
        }
  //      Watchdog.getInstance().feed();
        if (getStart()) {
            System.out.println("F310 on " + port + " - Start is pushed");
        }
  //      Watchdog.getInstance().feed();
        Direction dPadDir = getDPad();
        if (dPadDir.getX() != 0 || dPadDir.getY() != 0) {
            System.out.println("F310 on " + port + " - DPad x=" + dPadDir.getX() + ", y=" + dPadDir.getY());
        }
   //     Watchdog.getInstance().feed();
        Direction leftDir = getLeftStick();
        if (leftDir.getX() != 0 || leftDir.getY() != 0) {
            System.out.println("F310 on " + port + " - left stick x=" + leftDir.getX() + ", y=" + leftDir.getY());
        }
    //    Watchdog.getInstance().feed();
        Direction rightDir = getRightStick();
        if (rightDir.getX() != 0 || rightDir.getY() != 0) {
            System.out.println("F310 on " + port + " - right stick x=" + rightDir.getX() + ", y=" + rightDir.getY());
        }
    }

   

    public String getTargetButtons() {
       //buttonPressed = "NO";
        if (getA())
            buttonPressed = "A";
        else if (getB())
            buttonPressed = "B";
        else if (getX())
            buttonPressed = "X";
        else if (getY())
            buttonPressed = "Y";
//        else
//            buttonPressed = "NO";
        return buttonPressed;
            
    }

    public void run() {
        while(runner != null && runner.isAlive()) {
            try {
                if(getLT())
                {
                    SmartDashboard.putBoolean(name, true);
                }
                else {
                    SmartDashboard.putBoolean(name, false);
                }
                runner.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}