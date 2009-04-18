/*
 * GenericWarningFrame.java
 *
 * Created on 7 ottobre 2008, 9.31
 */

package lpr.minikazaa.minikazaaclient;

/**
 *
 * @author  giovine
 */
public class GenericWarningFrame extends javax.swing.JFrame {
    
    /** Creates new form GenericWarningFrame */
    public GenericWarningFrame(final String warning_message) {
        initComponents();
        this.warning_message.setText(warning_message);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ok_bt = new javax.swing.JButton();
        warning_message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini-KaZaA - Warning");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 24));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Warning");

        ok_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/ok_icon.png"))); // NOI18N
        ok_bt.setText("Ok");
        ok_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_btActionPerformed(evt);
            }
        });

        warning_message.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lpr/minikazaa/icons/warning_icon.png"))); // NOI18N
        warning_message.setText("qui ci andrà il messaggio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(ok_bt)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(warning_message)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(warning_message)
                .addGap(21, 21, 21)
                .addComponent(ok_bt)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void ok_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_btActionPerformed
    dispose();
}//GEN-LAST:event_ok_btActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton ok_bt;
    private javax.swing.JLabel warning_message;
    // End of variables declaration//GEN-END:variables

}