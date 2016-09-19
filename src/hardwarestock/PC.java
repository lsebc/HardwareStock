/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardwarestock;

/**
 *
 * @author ls
 */
public class PC {
    private String pcName = "";
    private String mem = "";
    private String storage = "";
    private String mobo =  "";
    private String netCard = "";
    private String gpu = "";
    private String cpu = "";
    
    public PC (String nName){
        pcName = nName;
    }
    
    public String getName (){
        return pcName;
    }
    
    @Override
    public String toString(){
     return pcName;   
    }
    
}
