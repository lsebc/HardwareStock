/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardwarestock;
import java.util.ArrayList;
/**
 *
 * @author ls
 */
public class RoomInventory {
    String pcName;
    ArrayList apc = new ArrayList();
    PC pc = new PC(pcName);
    
    public void addPC(){
        apc.add(pc);
    }
    
    public String getPcName(int n){
        String aName = apc.get(n).toString();
        return aName;
    }
    
    public void DisplayList(){
        System.out.println(apc);
    }
}
