/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reloj.vista;

import com.reloj.conexion.Cliente;
import com.reloj.logica.Reloj;

/**
 *
 * @author Letty
 */
public class VistaRelojPC1 extends javax.swing.JFrame implements Runnable {

    public static Reloj r1;
    private Thread h1, h2;
    private int[] horaMod;

    /**
     * Creates new form VistaRelojPC1
     */
    public VistaRelojPC1() {
        initComponents();
        r1 = new Reloj();
        horaMod = new int[3];

        h1 = new Thread(this);
        h2 = new Thread(this);

        h1.start();
        h2.start();

    }

    public void iniciarReloj() {
        hora1.setText(r1.imprimeHora());
    }

    @Override
    public void run() {

        Thread hiloActual = Thread.currentThread();
        iniciarReloj();

        while (hiloActual == h1 && !h1.isInterrupted()) {
            r1.pasarTiempo();
            hora1.setText(r1.imprimeHora());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        while (hiloActual == h2 && !h2.isInterrupted()) {
            System.out.println("Conectando con el servidor...");
            try {
                Cliente cli = new Cliente(); //Se crea el cliente
                System.out.println("Iniciando cliente\n");
                jlblIP.setText(cli.getIP());
                cli.startClient(); //Se inicia el cliente
                //System.out.println("");
                hora1.setText(cli.getHoraModificada());
                horaMod = cli.getHoraMinSeg();
                if (horaMod[0] == -1) {

                } else {
                    r1.modificarHora(horaMod[0], horaMod[1], horaMod[2]);
                }

            } catch (Exception e) {
                System.out.println("No se ha conectado con el servidor " + e.getMessage());
            }
        }

    }

    public void formatoHora() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelReloj1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hora1 = new javax.swing.JLabel();
        jlblIP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Reloj 1");

        hora1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        hora1.setText("jLabel5");
        hora1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hora1MouseClicked(evt);
            }
        });

        jlblIP.setText("IP");

        javax.swing.GroupLayout jPanelReloj1Layout = new javax.swing.GroupLayout(jPanelReloj1);
        jPanelReloj1.setLayout(jPanelReloj1Layout);
        jPanelReloj1Layout.setHorizontalGroup(
            jPanelReloj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj1Layout.createSequentialGroup()
                .addGroup(jPanelReloj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReloj1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(jPanelReloj1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(hora1))
                    .addGroup(jPanelReloj1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jlblIP)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanelReloj1Layout.setVerticalGroup(
            jPanelReloj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(hora1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jlblIP)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jPanelReloj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(33, 33, 33)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jPanelReloj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(53, 53, 53)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hora1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hora1MouseClicked

    }//GEN-LAST:event_hora1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VistaRelojPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRelojPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRelojPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRelojPC1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRelojPC1().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel hora1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelReloj1;
    private javax.swing.JLabel jlblIP;
    // End of variables declaration//GEN-END:variables

}
