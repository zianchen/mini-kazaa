/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr.minikazaa.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;
import lpr.minikazaa.minikazaaclient.MainGui;
import lpr.minikazaa.minikazaaclient.NodeConfig;
import lpr.minikazaa.minikazaaclient.Query;

/**
 *
 * @author Andrea Di Grazia, Massimiliano Giovine
 * @date 10-ott-2008
 * @file MainTest.java
 */
public class MainTest {

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception ex) {
        }
        //TableTest.main_function();
        //Prova_grafica.main_function();
        //main1();
        main2();
    }

    public static void main1() {
        Scanner s = new Scanner(System.in);

        ArrayList<String> test_list = new ArrayList();
        test_list.add("mamma ciao");
        test_list.add("ciao mamma");
        test_list.add("ciao papà");
        System.out.println("Enter regex: ");
        Pattern pattern = Pattern.compile(s.nextLine());
        
        Query q = new Query();
        assert q.getClass().equals("lpr.minikazaa.minikazaaclient.Query");

        boolean found = false;
        for (String sc : test_list) {
            Matcher matcher = pattern.matcher(sc);


            while (matcher.find()) {
                System.out.println("Elemento trovato: " + sc);
                found = true;
            }


        }

        if (!found) {
            System.out.println("Non ho trovato niente.");
        }
    }
    
    public static void main2(){
        NodeConfig conf = new NodeConfig();
        conf.setIsSN(false);
        MainGui mg = new MainGui(conf);
        mg.setVisible(true);
       
       
    }
}
