/*
 * MainGui.java
 *
 * Created on 12 novembre 2008, 10.00
 */
package lpr.minikazaa.minikazaaclient;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import lpr.minikazaa.GUI.AboutFrame;
import lpr.minikazaa.GUI.AboutFrameIta;
import lpr.minikazaa.GUI.NetMonitorPanel;
import lpr.minikazaa.GUI.NodeInfoFrame;
import lpr.minikazaa.GUI.SearchPanel;
import lpr.minikazaa.GUI.SharedFilesPanel;
import lpr.minikazaa.GUI.TransferPanel;
import lpr.minikazaa.bootstrap.BootstrapRMIWrapper;
import lpr.minikazaa.bootstrap.NodeInfo;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeDownloadMonitor;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeFiles;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeQuestionsList;
import lpr.minikazaa.util.FileUtil;
import lpr.minikazaa.util.NetUtil;

/**
 *
 * @author Andrea Di Grazia, Massimiliano Giovine
 */
public class MainGui extends javax.swing.JFrame implements WindowListener, WindowFocusListener, WindowStateListener {

    private NodeConfig my_conf;
    private OrdinarynodeFiles my_files;
    private Socket ordinarynode_sn_reference;
    private OrdinarynodeQuestionsList searches_list;
    private SupernodeList sn_list;
    private NodeInfo my_infos;
    private OrdinarynodeDownloadMonitor my_monitor;
    private BootstrapRMIWrapper rmi_stub;

    /** Creates new form MainGui */
    public MainGui(
            NodeConfig conf,
            OrdinarynodeFiles file_list,
            Socket sock,
            OrdinarynodeQuestionsList src_list,
            SupernodeList sn_list,
            NodeInfo info,
            OrdinarynodeDownloadMonitor monitor,
            BootstrapRMIWrapper rmi) {

        this.my_files = file_list;
        this.my_conf = conf;
        this.ordinarynode_sn_reference = sock;
        this.searches_list = src_list;
        this.sn_list = sn_list;
        this.my_infos = info;
        this.my_monitor = monitor;
        this.rmi_stub = rmi;
        initComponents();

        if (!this.my_conf.getIsSN()) {
            //Unable to watch net monitor
            this.net_bt.setEnabled(false);
        }

        //Listeners to our window
        addWindowListener(this);
        addWindowFocusListener(this);
        addWindowStateListener(this);

        try {
            InetAddress temp_infos = NetUtil.getAddress();
            this.connection_status.setText("Address: " + temp_infos.toString().substring(1));
            this.my_conf.setMyAddress(temp_infos.toString().substring(1));
        } catch (SocketException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Bottom left status bar.
        if (this.my_conf.getIsSN()) {
            this.kind_label.setText("Super node mode.");
        } else {
            this.kind_label.setText("Ordinary node mode.");
        }
    }

    private void closeActions() {
        FileUtil.saveMySharedFiles(my_files);

        XMLEncoder config_xml;
        try {

            config_xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("config.xml")));
            config_xml.writeObject((Object) this.my_conf);
            config_xml.flush();
            config_xml.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error while saving configuration on config.xml.");
        }

        try {
            if (this.my_conf.getIsSN()) {
                System.out.println(this.rmi_stub.toString());
                this.rmi_stub.getStub().removeSuperNode(my_infos);
            }
            else{
                this.rmi_stub.getStub().removeOrdinaryNode(my_infos);
            }
        } catch (RemoteException ex) {
            System.err.println("Unable to remove me from bootstrap server.");
        }
        System.exit(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tool_bar = new javax.swing.JToolBar();
        connect_bt = new javax.swing.JButton();
        disconnect_bt = new javax.swing.JButton();
        search_bt = new javax.swing.JButton();
        transfer_bt = new javax.swing.JButton();
        shared_bt = new javax.swing.JButton();
        net_bt = new javax.swing.JButton();
        close_tab_bt = new javax.swing.JButton();
        shut_down_bt = new javax.swing.JButton();
        connection_status = new javax.swing.JLabel();
        main_tab = new javax.swing.JTabbedPane();
        kind_label = new javax.swing.JLabel();
        main_menu_bar1 = new javax.swing.JMenuBar();
        file_menu = new javax.swing.JMenu();
        close_item = new javax.swing.JMenuItem();
        edit_menu = new javax.swing.JMenu();
        configuration_item = new javax.swing.JMenuItem();
        infos_item = new javax.swing.JMenuItem();
        help_menu = new javax.swing.JMenu();
        about_item = new javax.swing.JMenuItem();
        ita_about_item = new javax.swing.JMenuItem();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("MiNi-KaZaA");
        setIconImage(new ImageIcon(getClass().getResource("/lpr/minikazaa/icons/mini_kazaa_main_icon.png")).getImage());

        tool_bar.setRollover(true);

        connect_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/connections_icon.png"))); // NOI18N
        connect_bt.setText("Connect");
        connect_bt.setFocusable(false);
        connect_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        connect_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tool_bar.add(connect_bt);

        disconnect_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/discconnections_icon.png"))); // NOI18N
        disconnect_bt.setText("Disconnect");
        disconnect_bt.setFocusable(false);
        disconnect_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        disconnect_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tool_bar.add(disconnect_bt);

        search_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/search_icon.png"))); // NOI18N
        search_bt.setText("Search");
        search_bt.setFocusable(false);
        search_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        search_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        search_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btActionPerformed(evt);
            }
        });
        tool_bar.add(search_bt);

        transfer_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/transfer_icon.png"))); // NOI18N
        transfer_bt.setText("File Transfer");
        transfer_bt.setFocusable(false);
        transfer_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        transfer_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        transfer_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfer_btActionPerformed(evt);
            }
        });
        tool_bar.add(transfer_bt);

        shared_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/shared_files_icon.png"))); // NOI18N
        shared_bt.setText("Shared Files");
        shared_bt.setFocusable(false);
        shared_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shared_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shared_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shared_btActionPerformed(evt);
            }
        });
        tool_bar.add(shared_bt);

        net_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/network_icon.png"))); // NOI18N
        net_bt.setText("Net Monitor");
        net_bt.setFocusable(false);
        net_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        net_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        net_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                net_btActionPerformed(evt);
            }
        });
        tool_bar.add(net_bt);

        close_tab_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/close_tab_icon.png"))); // NOI18N
        close_tab_bt.setText("Close Tab");
        close_tab_bt.setFocusable(false);
        close_tab_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        close_tab_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        close_tab_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_tab_btActionPerformed(evt);
            }
        });
        tool_bar.add(close_tab_bt);

        shut_down_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/shut_down_icon.png"))); // NOI18N
        shut_down_bt.setText("Shut Down");
        shut_down_bt.setFocusable(false);
        shut_down_bt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shut_down_bt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shut_down_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shut_down_btActionPerformed(evt);
            }
        });
        tool_bar.add(shut_down_bt);

        connection_status.setText("jLabel2");

        kind_label.setText("jLabel1");

        file_menu.setText("File");

        close_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        close_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/close_icon.png"))); // NOI18N
        close_item.setText("Shut down");
        close_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_itemActionPerformed(evt);
            }
        });
        file_menu.add(close_item);

        main_menu_bar1.add(file_menu);

        edit_menu.setText("Edit");

        configuration_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        configuration_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/config_icon.png"))); // NOI18N
        configuration_item.setText("Configuration");
        edit_menu.add(configuration_item);

        infos_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        infos_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/info_icon.png"))); // NOI18N
        infos_item.setText("Infos");
        infos_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infos_itemActionPerformed(evt);
            }
        });
        edit_menu.add(infos_item);

        main_menu_bar1.add(edit_menu);

        help_menu.setText("Help");

        about_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        about_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/about_icon.png"))); // NOI18N
        about_item.setText("About");
        about_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_itemActionPerformed(evt);
            }
        });
        help_menu.add(about_item);

        ita_about_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/italian_about_icon.png"))); // NOI18N
        ita_about_item.setText("Crediti (ita)");
        ita_about_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ita_about_itemActionPerformed(evt);
            }
        });
        help_menu.add(ita_about_item);

        main_menu_bar1.add(help_menu);

        setJMenuBar(main_menu_bar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tool_bar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(kind_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 680, Short.MAX_VALUE)
                .addComponent(connection_status)
                .addContainerGap())
            .addComponent(main_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tool_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main_tab, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connection_status)
                    .addComponent(kind_label)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void search_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btActionPerformed
    ImageIcon icon = new ImageIcon(getClass().getResource("/lpr/minikazaa/icons/mini_search_icon.png"));
    SearchPanel search_panel = new SearchPanel(this.my_infos, this.my_conf, this.searches_list, this.sn_list, this.my_monitor);
    this.main_tab.addTab("Search", icon, search_panel, "Search files in the network.");
}//GEN-LAST:event_search_btActionPerformed

private void transfer_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transfer_btActionPerformed
    int index = 0;

    try {
        String s = null;
        while (true) {
            s = this.main_tab.getTitleAt(index);

            if (s.equals("Transfer")) {
                return;
            }
            index++;
        }
    } catch (IndexOutOfBoundsException ex) {

        ImageIcon icon = new ImageIcon(getClass().getResource("/lpr/minikazaa/icons/mini_transfer_icon.png"));
        this.main_tab.addTab("Transfer", icon, new TransferPanel(), "Monitor your transfert.");

        return;
    }
}//GEN-LAST:event_transfer_btActionPerformed

private void close_tab_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_tab_btActionPerformed

    int tab_to_remove = this.main_tab.getSelectedIndex();
    this.main_tab.remove(tab_to_remove);
}//GEN-LAST:event_close_tab_btActionPerformed

private void shared_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shared_btActionPerformed
    //Call a new panel to view, add or remove files to share with other users.

    int index = 0;

    try {
        String s = null;
        while (true) {
            s = this.main_tab.getTitleAt(index);

            if (s.equals("Shared Files")) {
                return;
            }
            index++;
        }
    } catch (IndexOutOfBoundsException ex) {

        SharedFilesPanel shared_files_panel = new SharedFilesPanel(this.my_files);
        ImageIcon icon = new ImageIcon(getClass().getResource("/lpr/minikazaa/icons/mini_shared_files_icon.png"));
        this.main_tab.addTab("Shared Files", icon, shared_files_panel, "Manage your sharings.");

        return;
    }

}//GEN-LAST:event_shared_btActionPerformed

private void shut_down_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shut_down_btActionPerformed
    this.closeActions();
}//GEN-LAST:event_shut_down_btActionPerformed

private void close_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_itemActionPerformed
    this.closeActions();
}//GEN-LAST:event_close_itemActionPerformed

private void net_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_net_btActionPerformed
    //Call a new panel to view and modify overlay network of mini-kazaa

    int index = 0;

    try {
        String s = null;
        while (true) {
            s = this.main_tab.getTitleAt(index);

            if (s.equals("Net Monitor")) {
                return;
            }
            index++;
        }
    } catch (IndexOutOfBoundsException ex) {

        NetMonitorPanel shared_files_panel = new NetMonitorPanel(this.sn_list);
        ImageIcon icon = new ImageIcon(getClass().getResource("/lpr/minikazaa/icons/mini_network_icon.png"));
        this.main_tab.addTab("Net Monitor", icon, shared_files_panel, "Manage your sharings.");

        return;
    }
}//GEN-LAST:event_net_btActionPerformed

private void about_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_itemActionPerformed
    //Launch about form
    AboutFrame about = new AboutFrame();
    about.setLocationRelativeTo(null);
    about.setVisible(true);
}//GEN-LAST:event_about_itemActionPerformed

private void ita_about_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ita_about_itemActionPerformed
    //Launch italian about form
    AboutFrameIta about = new AboutFrameIta();
    about.setLocationRelativeTo(null);
    about.setVisible(true);
}//GEN-LAST:event_ita_about_itemActionPerformed

private void infos_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infos_itemActionPerformed
    NodeInfoFrame infos = new NodeInfoFrame(this.my_infos);
    infos.setLocationRelativeTo(null);
    infos.setVisible(true);
}//GEN-LAST:event_infos_itemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about_item;
    private javax.swing.JMenuItem close_item;
    private javax.swing.JButton close_tab_bt;
    private javax.swing.JMenuItem configuration_item;
    private javax.swing.JButton connect_bt;
    private javax.swing.JLabel connection_status;
    private javax.swing.JButton disconnect_bt;
    private javax.swing.JMenu edit_menu;
    private javax.swing.JMenu file_menu;
    private javax.swing.JMenu help_menu;
    private javax.swing.JMenuItem infos_item;
    private javax.swing.JMenuItem ita_about_item;
    private javax.swing.JLabel kind_label;
    private javax.swing.JMenuBar main_menu_bar1;
    private javax.swing.JTabbedPane main_tab;
    private javax.swing.JButton net_bt;
    private javax.swing.JButton search_bt;
    private javax.swing.JButton shared_bt;
    private javax.swing.JButton shut_down_bt;
    private javax.swing.JToolBar tool_bar;
    private javax.swing.JButton transfer_bt;
    // End of variables declaration//GEN-END:variables

    public void windowOpened(WindowEvent arg0) {
        //Do nothing
    }

    public void windowClosed(WindowEvent arg0) {
        //Do nothing.
    }

    public void windowIconified(WindowEvent arg0) {
        //Do nothing
    }

    public void windowDeiconified(WindowEvent arg0) {
        //Do nothing
    }

    public void windowActivated(WindowEvent arg0) {
        //Do nothing
    }

    public void windowDeactivated(WindowEvent arg0) {
        //Do nothing
    }

    /**
     *
     *
     * @param e event that handle windows closing operation.
     */
    public void windowClosing(WindowEvent e) {
        this.closeActions();
    }

    public void windowGainedFocus(WindowEvent arg0) {
        //Do nothing
    }

    public void windowLostFocus(WindowEvent arg0) {
        //Do nothing
    }

    public void windowStateChanged(WindowEvent arg0) {
        //Do nothing
    }
}
