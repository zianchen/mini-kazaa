/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr.minikazaa.minikazaaclient.supernode;

import lpr.minikazaa.minikazaaclient.NodeConfig;
import lpr.minikazaa.minikazaaclient.SupernodeList;


/**
 *
 * @author Andrea Di Grazia, Massimiliano Giovine
 * @date 17-set-2008
 * @file SupernodeEngine.java
 */
public class SupernodeEngine implements Runnable {

    NodeConfig my_conf;
    
    public SupernodeEngine(NodeConfig conf) {
        this.my_conf = conf;
    }

    public void run() {
        System.out.println("Thread Super node engine init.");
        SupernodeList sn_list = new SupernodeList();
        
        
        
        //Init RMI manager Thread.
        SupernodeRMIManager sn_rmi = new SupernodeRMIManager(my_conf,sn_list);
        Thread rmi_manager = new Thread(sn_rmi);
        rmi_manager.start();
        
        SupernodeMainGui main_gui = new SupernodeMainGui(my_conf,sn_list);
        main_gui.setLocationRelativeTo(null);
        main_gui.setVisible(true);
        
        SupernodeGuiEngine gui_engine = new SupernodeGuiEngine(main_gui, my_conf, sn_list);
        Thread gui_engine_thread = new Thread(gui_engine);
        gui_engine_thread.start();
        
    }
}
