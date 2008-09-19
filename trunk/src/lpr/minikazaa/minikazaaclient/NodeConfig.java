/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lpr.minikazaa.minikazaaclient;

import java.io.Serializable;

/**
 * @author giovine
 */
public class NodeConfig extends Object implements Serializable {

    private String user_name;
    private int port;
    private String bootstrap_address;
    private int max_conn;
    private int ttl;
    private boolean is_sn;
    private int max_sim_down;
    private int max_sim_up;
    
    
    //Get methods
    public String getUserName(){
        return user_name;
    }
    public int getPort(){
        return port;
    }
    public String getBootStrapAddress(){
        return bootstrap_address;
    }
    public int getMaxConnection(){
        return max_conn;
    }
    public int getTimeToLeave(){
        return ttl;
    }
    public boolean getIsSN(){
        return is_sn;
    }
    public int getMaxDown(){
        return max_sim_down;
    }
    public int getMaxUp(){
        return max_sim_up;
    }
    
    
    
    //Set methods
    public void setUserName(String un){
        this.user_name = un;
    }
    public void setPort(int p){
        this.port = p;
    }
    public void setBootStrapAddress(String bsa){
        this.bootstrap_address = bsa;
    }
    public void setMaxConnection(int max_c){
        this.max_conn = max_c;
    }
    public void setTimeToLeave(int time){
        this.ttl = time;
    }
    public void setIsSN(boolean value){
        this.is_sn = value;
    }
    public void setMaxDown(int n){
        this.max_sim_down = n;
    }
    public void setMaxUp(int n){
        this.max_sim_up = n;
    }
}
