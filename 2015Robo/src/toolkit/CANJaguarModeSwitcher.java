/*Z
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toolkit;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team2340.TritonDefinitions;

/**
 *
 * @author Team2340
 */
public class CANJaguarModeSwitcher {
    
    public CANJaguarModeSwitcher() {
        
    }
    
        public CANJaguar initializeCloseLoop(int id, int clicksPerRev, CANJaguar.ControlMode mode) {
        CANJaguar canJag = CANJaguarFactory.getInstance().get(id, mode);
        try {
            //logger.log("initialize driveJag", id);

            canJag.configEncoderCodesPerRev(clicksPerRev);
            updatePID(canJag, id);
            canJag.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            canJag.changeControlMode(CANJaguar.ControlMode.kPosition);
            canJag.enableControl();   
            canJag.configNeutralMode(CANJaguar.NeutralMode.kBrake);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return canJag;
        }
        
        public CANJaguar initializeOpenLoop(int id) {
        System.out.println("In initializeOpenLoop");
            CANJaguar canJag = CANJaguarFactory.getInstance().get(id);
       try {
           System.out.println("Got jaguar : " + canJag.getFaults());
             
            canJag.disableControl();
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
            return canJag;       
        }
        
         public void updatePID(CANJaguar jag, int id) {
        try {
            double newP = SmartDashboard.getNumber(String.valueOf(id) + TritonDefinitions.DRIVE_PROPORTIONAL);
            double newI = SmartDashboard.getNumber(String.valueOf(id) + TritonDefinitions.DRIVE_INTEGRAL);
            double newD = SmartDashboard.getNumber(String.valueOf(id) + TritonDefinitions.DRIVE_DIFFERENTIAL);
            double lowVoltage = SmartDashboard.getNumber(String.valueOf(id) + TritonDefinitions.JAG_LOWVOLTAGE);
            jag.configMaxOutputVoltage(lowVoltage);
            jag.setPID(newP, newI, newD);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
