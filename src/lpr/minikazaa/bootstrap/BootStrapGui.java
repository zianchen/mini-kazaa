/*
 * BootStrapGui.java
 *
 * Created on 11 settembre 2008, 14.54
 */
package lpr.minikazaa.bootstrap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lpr.minikazaa.minikazaaclient.SupernodeList;

/**
 *
 * @author  giovine
 */
public class BootStrapGui extends javax.swing.JFrame {
    SupernodeList sn_list;
    /** Creates new form BootStrapGui */
    public BootStrapGui(SupernodeList list) {
               
        this.sn_list = list;
        
        initComponents();
        
        close_item.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                });
                
         about_item.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        BootStrapAboutFrame about = new BootStrapAboutFrame();
                        //Frame appears in the center of the screen
                        about.setLocationRelativeTo(null);
                        about.setVisible(true);
                    }
                });
                
        
    }
    
    /**
     * This methods are writed by authors to extend form possibilities.
     */
    public void setWhatAppensLine(String s){
        wh.append(s);
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
        wh = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        close_item = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        faq_menu = new javax.swing.JMenu();
        about_item = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiniKazaa - Bootstrap Server");
        setResizable(false);

        wh.setColumns(20);
        wh.setRows(5);
        jScrollPane1.setViewportView(wh);

        jLabel1.setText("What happens:");

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/file_icon.png"))); // NOI18N
        jMenuItem2.setText("File");
        jMenu1.add(jMenuItem2);

        close_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        close_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/close_icon.png"))); // NOI18N
        close_item.setLabel("Close");
        jMenu1.add(close_item);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/config_icon.png"))); // NOI18N
        jMenuItem3.setText("Configuration");
        jMenuItem3.setName("Configuration"); // NOI18N
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        faq_menu.setText("?");

        about_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/about_icon.png"))); // NOI18N
        about_item.setText("About");
        faq_menu.add(about_item);

        jMenuBar1.add(faq_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about_item;
    private javax.swing.JMenuItem close_item;
    private javax.swing.JMenu faq_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea wh;
    // End of variables declaration//GEN-END:variables
}
