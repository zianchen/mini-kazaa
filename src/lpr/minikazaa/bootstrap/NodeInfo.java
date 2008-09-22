

package lpr.minikazaa.bootstrap;

import java.io.Serializable;
import java.net.InetAddress;
import lpr.minikazaa.minikazaaclient.supernode.SupernodeCallbacksInterface;

/**
 * Da commentare.
 * 
 * @author Andrea Di Grazia, Massimiliano Giovine
 * @date 11-set-2008
 * @file NodeInfo.java
 */
public class NodeInfo implements Serializable {
    
    private InetAddress ia_node;
    private int door;
    private String id_node;
    private SupernodeCallbacksInterface stub;
    
    public NodeInfo(InetAddress ia_node, int door){
        this.ia_node = ia_node;
        this.door = door;
        this.id_node = ia_node.getHostAddress()+":"+door;
    }
    
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
}