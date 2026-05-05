package Vista;

import Reglas.Cuenta;
import Reglas.CuentaAhorros;
import javax.swing.JOptionPane;
import Reglas.CuentaCorriente;

public class frmTransacciones extends javax.swing.JFrame {
    // Elimina o comenta esta línea, ya no la necesitas:
    //CuentaCorriente ctaCrr = new CuentaCorriente();

    Cuenta cuenta; // Puede ser CuentaCorriente o CuentaAhorros

    public frmTransacciones() {
        initComponents();
        setSize(600, 400);
        cuenta = new CuentaCorriente();
        // Si quieres probar con ahorros: cuenta = new CuentaAhorros();
        txtDps.setText("0");
        txtRetiro.setText("0");
        txtSaldo.setText("0");
        txtHistorico.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDps = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRetiro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        btnDepositar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Valor a Depositar: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 50, 110, 16);

        txtDps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDpsActionPerformed(evt);
            }
        });
        getContentPane().add(txtDps);
        txtDps.setBounds(130, 50, 72, 25);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Valor a Retirar:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 80, 100, 16);
        getContentPane().add(txtRetiro);
        txtRetiro.setBounds(130, 80, 72, 25);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Balance:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 110, 110, 20);

        txtSaldo.setEditable(false);
        getContentPane().add(txtSaldo);
        txtSaldo.setBounds(130, 110, 72, 25);

        btnDepositar.setText("Depositar");
        btnDepositar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDepositarMouseClicked(evt);
            }
        });
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDepositar);
        btnDepositar.setBounds(20, 150, 90, 30);

        btnRetirar.setText("Retirar");
        btnRetirar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetirarMouseClicked(evt);
            }
        });
        getContentPane().add(btnRetirar);
        btnRetirar.setBounds(120, 150, 90, 30);

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Transacciones Bancarias");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 10, 137, 14);

        txtHistorico.setColumns(20);
        txtHistorico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtHistorico.setRows(5);
        jScrollPane3.setViewportView(txtHistorico);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(220, 90, 250, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void limpiar(){
        txtDps.setText("0");
        txtRetiro.setText("0");        
    }
    
    public void consultar(){
        // Muestra el saldo actual de la cuenta corriente usando el método de instancia
        txtSaldo.setText(String.valueOf(cuenta.getSaldo()));
    }
    
    private void btnDepositarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositarMouseClicked
        try {
            double cantidad = Double.parseDouble(txtDps.getText());
            if (cantidad <= 0) {
                txtHistorico.setText("Debe ingresar un valor positivo para depositar\n" + txtHistorico.getText());
                return;
            }
            cuenta.depositar(cantidad);
            txtHistorico.setText("Dep: " + cantidad + "\n" + txtHistorico.getText());
            consultar();
        } catch (NumberFormatException ex) {
            txtHistorico.setText("Ingrese un valor numérico válido\n" + txtHistorico.getText());
        }
        limpiar();
    }//GEN-LAST:event_btnDepositarMouseClicked

    private void btnRetirarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetirarMouseClicked
        try {
            double cantidad = Double.parseDouble(txtRetiro.getText());
            if (cantidad <= 0) {
                txtHistorico.setText("Debe ingresar un valor positivo para retirar\n" + txtHistorico.getText());
                return;
            }
            if (cuenta.retirar(cantidad)) {
                txtHistorico.setText("Ret: " + cantidad + "\n" + txtHistorico.getText());
            } else {
                txtHistorico.setText("No tiene saldo suficiente\n" + txtHistorico.getText());
            }
            consultar();
        } catch (NumberFormatException ex) {
            txtHistorico.setText("Ingrese un valor numérico válido\n" + txtHistorico.getText());
        }
        limpiar();
        
    }//GEN-LAST:event_btnRetirarMouseClicked

    private void txtDpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpsActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDepositarActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTransacciones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtDps;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JTextField txtRetiro;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
