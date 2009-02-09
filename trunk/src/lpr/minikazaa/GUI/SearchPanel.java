/*
 * SearchPanel.java
 *
 * Created on 14 novembre 2008, 13.00
 */
package lpr.minikazaa.GUI;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lpr.minikazaa.bootstrap.NodeInfo;
import lpr.minikazaa.minikazaaclient.NodeConfig;
import lpr.minikazaa.minikazaaclient.Query;
import lpr.minikazaa.minikazaaclient.SupernodeList;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeDownloadMonitor;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeFoundList;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeQuestionsList;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeRefSn;

/**
 *
 * @author  giovine
 */
public class SearchPanel extends javax.swing.JPanel {

    private NodeInfo my_infos;
    private NodeConfig my_conf;
    private OrdinarynodeQuestionsList searches_list;
    private SupernodeList sn_list;
    private OrdinarynodeDownloadMonitor my_monitor;
    private OrdinarynodeRefSn my_ref_sn;
    private int my_num;

    /** Creates new form SearchPanel */
    public SearchPanel(
            NodeInfo info,
            NodeConfig conf,
            OrdinarynodeQuestionsList src_list,
            SupernodeList sn_list,
            OrdinarynodeDownloadMonitor monitor,
            int num,
            OrdinarynodeRefSn ref) {

        this.my_infos = info;
        this.my_conf = conf;
        this.searches_list = src_list;
        this.sn_list = sn_list;
        this.my_monitor = monitor;
        this.my_num = num;
        this.my_ref_sn = ref;
        initComponents();

        OrdinarynodeFoundList found_list = new OrdinarynodeFoundList(this.my_num);
        this.searches_list.addFoundList(found_list);
        found_list.addObserver((SearchFileTable) this.search_table);
    }

    private void searchOperations() {
        System.out.println("DEBUG: searchOperations called.");

        if (this.my_conf.getIsSN()) {
            ArrayList<NodeInfo> sub_set = this.sn_list.getSubSet();
            Query q = new Query();
            q.setSender(this.my_infos);
            q.setOrigin(this.my_infos);
            q.setAskingQuery(this.search_tf.getText());

            for (NodeInfo peer : sub_set) {
                try {
                    q.setReceiver(peer);
                    Socket cli_sock = new Socket(peer.getIaNode(), peer.getDoor());
                    ObjectOutputStream output_stream = new ObjectOutputStream(cli_sock.getOutputStream());
                    output_stream.writeObject(q);
                    cli_sock.close();
                } catch (IOException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {

            Query q = new Query();
            q.setReceiver(this.my_ref_sn.getBestSn());
            q.setSender(this.my_infos);
            q.setOrigin(this.my_infos);
            q.setAskingQuery(this.search_tf.getText());



            this.my_ref_sn.increaseNumQuery();
            this.my_ref_sn.send(q);

            System.out.println("DEBUG: Query " + q.getBodyQ() + " sent.");




        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        search_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        search_tf = new javax.swing.JTextField();
        search_bt = new javax.swing.JButton();
        clean_bt = new javax.swing.JButton();
        download_bt = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Search Panel"));
        setNextFocusableComponent(search_tf);

        search_table = new SearchFileTable(this.my_num);
        /*
        search_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File name", "Size", "Owner", "MD5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        */
        jScrollPane1.setViewportView(search_table);

        jLabel1.setText("Search:");

        search_tf.setText("...type here your research parameters...");
        search_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_tfActionPerformed(evt);
            }
        });
        search_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_tfFocusGained(evt);
            }
        });

        search_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/mini_connect_icon.png"))); // NOI18N
        search_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btActionPerformed(evt);
            }
        });

        clean_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/mini_clean_icon.png"))); // NOI18N
        clean_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clean_btActionPerformed(evt);
            }
        });

        download_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/download_icon.png"))); // NOI18N
        download_bt.setText("Download");
        download_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                download_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_bt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clean_bt)
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(download_bt))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_bt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(clean_bt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(download_bt)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_tfActionPerformed
        this.searchOperations();
    }//GEN-LAST:event_search_tfActionPerformed

    private void search_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btActionPerformed
        this.searchOperations();
}//GEN-LAST:event_search_btActionPerformed

    private void clean_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clean_btActionPerformed
        this.search_tf.setText("");
}//GEN-LAST:event_clean_btActionPerformed

    private void search_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_tfFocusGained
        this.search_tf.selectAll();
    }//GEN-LAST:event_search_tfFocusGained

    private void download_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_download_btActionPerformed
}//GEN-LAST:event_download_btActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clean_bt;
    private javax.swing.JButton download_bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search_bt;
    private javax.swing.JTable search_table;
    private javax.swing.JTextField search_tf;
    // End of variables declaration//GEN-END:variables
}


