/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import java.util.Hashtable;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Team 2340
 */
public class CANJaguarFactory {
    
    private static CANJaguarFactory instance;
    
    private static Hashtable canJagMap;
    
    private CANJaguarFactory() {
        canJagMap = new Hashtable();
    }
    
    public static CANJaguarFactory getInstance()
    {
        if(instance == null)
        {
            instance = new CANJaguarFactory();
        }
        return instance;
    }
    
    public CANJaguar get(int _id)
    {
        Integer id = Integer.valueOf(_id);
        boolean exists = canJagMap.containsKey(id);   
        CANJaguar canJag = null;
        if(exists) {
            canJag = (CANJaguar)canJagMap.get(id);
        }
        else {
            try {
                canJag = new CANJaguar(_id);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
            canJagMap.put(id, canJag);
        }
        return canJag;
    }
    
    public CANJaguar get(int _id, CANJaguar.ControlMode _controlMode)
    {
        Integer id = Integer.valueOf(_id);
        boolean exists = canJagMap.containsKey(id);   
        CANJaguar canJag = null;
        if(exists) {
            canJag = (CANJaguar)canJagMap.get(id);
            try {
                canJag.changeControlMode(_controlMode);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
        }
        else {
            try {
                canJag = new CANJaguar(_id, _controlMode);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
            canJagMap.put(id, canJag);
        }
        return canJag;
    }  
}
