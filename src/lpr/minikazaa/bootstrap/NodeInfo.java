

package lpr.minikazaa.bootstrap;

import java.io.Serializable;
import java.net.InetAddress;
import lpr.minikazaa.minikazaaclient.supernode.SupernodeCallbacksInterface;

/**
 * 
 * @author Andrea Di Grazia, Massimiliano Giovine
 * @date 11-set-2008
 * @file NodeInfo.java
 */
public class NodeInfo implements Serializable {
    
    private InetAddress ia_node;
    private int door;
    private String id_node;
    private String username; //Useless mnemonic username
    private SupernodeCallbacksInterface stub;
    private long ping;
    private boolean is_sn;

    private int my_connection;
    private int my_files;
    
    public NodeInfo(){
        
        this.ping = 999;
        this.my_connection = 0;
        this.my_files = 0;
    }

    public void setInetAddress(InetAddress ia_node){this.ia_node = ia_node;}
    public void setDoor(int door){this.door = door;}
    public void setCallbacksInterface(SupernodeCallbacksInterface callback){this.stub = callback;}
    public void setId(String id){this.id_node = id;}
    public void setIsSn(boolean sn){this.is_sn = sn;}

    public InetAddress getIaNode(){
        return this.ia_node;
    }
    
    public int getDoor(){
        return this.door;
    }
    
    public String getId(){
        return this.id_node;
    }
    
    public SupernodeCallbacksInterface getCallbackInterface(){
        return this.stub;
    }
    
    public long getPing(){
        return this.ping;
    }
    
    public String getUsername(){
        return this.username;
    }

    public int getFiles(){
        return this.my_files;
    }

    public int getConnections(){
        return this.my_connection;
    }
    
    public void addFiles(int n_new_files){
        this.my_files = this.my_files + n_new_files;
    }
    public void removeFiles(int n_old_files){
        this.my_files = this.my_files - n_old_files;
    }
    
    
    public void addConnection(){
        this.my_connection ++;
    }
    public void removeConnection(){
        this.my_connection --;
    }
    
    //Set methods
    public void setPing(long fresh_ping){
        this.ping = fresh_ping;
    }
    public void setUsername(String name){
        this.username = name;
    }
    
    @Override
    public String toString(){
        return this.ia_node.toString();
    }
    
    @Override
    public boolean equals(Object obj){

        if(obj instanceof NodeInfo){
            NodeInfo n = (NodeInfo) obj;
            if(n.getId().equals(this.id_node))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id_node != null ? this.id_node.hashCode() : 0);
        return hash;
    }
    
    public String toTable(){
        return ""+this.ia_node.toString()+"\n"+this.my_files+"\n"+this.my_connection+"\n";
    }
    
    public boolean theSame(NodeInfo n){
        if(this.id_node.equals(n.id_node))
            return true;
        else
            return false;
    }

    public boolean isSN(){
        return this.is_sn;
    }
}
