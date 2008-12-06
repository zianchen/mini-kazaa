/*
 * SharedFilesPanel.java
 *
 * Created on 24 novembre 2008, 13.05
 */

package lpr.minikazaa.GUI;

import java.io.File;
import javax.swing.JFileChooser;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeFiles;
import lpr.minikazaa.util.FileUtil;
import lpr.minikazaa.util.MKFileDescriptor;

/**
 *
 * @author  giovine
 */
public class SharedFilesPanel extends javax.swing.JPanel {
    private OrdinarynodeFiles my_files;
    /** Creates new form SharedFilesPanel */
    public SharedFilesPanel(OrdinarynodeFiles files) {
        this.my_files = files;
        initComponents();
        this.my_files.addObserver((SharedFilesTable)this.files_table);
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
        files_table = new javax.swing.JTable();
        add_bt = new javax.swing.JButton();
        remove_bt = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Shared files panel"));

        files_table = new SharedFilesTable(this.my_files);
        /*
        files_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Size", "MD5", "Path"
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
        jScrollPane1.setViewportView(files_table);

        add_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/add_icon.png"))); // NOI18N
        add_bt.setText("Add");
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });

        remove_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/remove_icon.png"))); // NOI18N
        remove_bt.setText("Remove");
        remove_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(remove_bt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(add_bt)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_bt)
                    .addComponent(remove_bt))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btActionPerformed
        //Invoke new panel to select a folder.
        JFileChooser choose_shared_dir = new JFileChooser(new File("./"));
        choose_shared_dir.setDialogTitle("Mini-Kazaa - Select your shared files");
        choose_shared_dir.setApproveButtonText("Ok");
        choose_shared_dir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        choose_shared_dir.setMultiSelectionEnabled(true);
        int value = choose_shared_dir.showOpenDialog(null);

        if(value == JFileChooser.APPROVE_OPTION){
            File [] selected_file = choose_shared_dir.getSelectedFiles();

            this.my_files.addFiles(FileUtil.transformFileToMKFile(selected_file));
        }

         
    }//GEN-LAST:event_add_btActionPerformed

    private void remove_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_btActionPerformed
        //We have to call the proper function to remove shared files.
        int [] selected_rows = this.files_table.getSelectedRows();
        
        MKFileDescriptor [] files_to_remove = new MKFileDescriptor[selected_rows.length];

        for(int i = 0; i < selected_rows.length; i++){

            String file_name = (String) this.files_table.getValueAt(selected_rows[i], 0);
            System.out.println(file_name);
            String md5 = (String) this.files_table.getValueAt(selected_rows[i], 2);
            System.out.println(md5);
            String abs_path = (String) this.files_table.getValueAt(selected_rows[i], 3);
            System.out.println(abs_path);
            files_to_remove[i] = new MKFileDescriptor(file_name,md5,0,abs_path);
        }

        this.my_files.removeFiles(files_to_remove);
    }//GEN-LAST:event_remove_btActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_bt;
    private javax.swing.JTable files_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove_bt;
    // End of variables declaration//GEN-END:variables

}