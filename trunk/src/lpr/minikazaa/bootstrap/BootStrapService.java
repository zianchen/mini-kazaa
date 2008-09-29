/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr.minikazaa.bootstrap;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.UIManager;
import lpr.minikazaa.minikazaaclient.supernode.SupernodeCallbacksImpl;
import lpr.minikazaa.minikazaaclient.supernode.SupernodeCallbacksInterface;

/**
 *
 * @author Andrea Di Grazia, Massimiliano Giovine
 * @date 11-set-2008
 * @file BootStrapService.java
 */
public class BootStrapService {

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception ex) {
        }
 
        try {
            Registry registry = LocateRegistry.createRegistry(2008);
            System.out.println("Registry init.");
            System.out.println(registry.toString());

            BootStrapGui g = new BootStrapGui();
            
            //Frame appears in the center of the screen
            g.setLocationRelativeTo(null);
            
            g.setVisible(true);

            BootStrapServer bss = new BootStrapServer(g);

            BootStrapServerInterface stub = (BootStrapServerInterface) UnicastRemoteObject.exportObject(bss, 0);
            SupernodeCallbacksImpl client_impl = new SupernodeCallbacksImpl();
            
            SupernodeCallbacksInterface client_stub = (SupernodeCallbacksInterface) UnicastRemoteObject.exportObject( client_impl,0);
            
            System.out.println("Ready to bind.");
            registry.bind("BootStrap", stub);
            registry.bind("Callback", client_stub);
            
            //List of remote interfaces
            String [] list = registry.list();
            for(String i : list){
                System.out.println("Interface:"+ i);
            }
            

        } catch (Exception e) {
            System.err.println("BootStrapService: " + e);
        }
    }
}