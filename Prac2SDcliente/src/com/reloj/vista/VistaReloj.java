/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reloj.vista;

import com.reloj.logica.Reloj;
import java.util.Arrays;

/**
 *
 * @author geoge
 */
public class VistaReloj extends javax.swing.JFrame implements Runnable {

    protected static Reloj r1, r2, r3, r4;
    protected static Boolean[] stoph;
    protected static Thread h1, h2, h3, h4;
    protected static int numHilo;

    /**
     * Creates new form VistaReloj
     */
    public VistaReloj() {
        initComponents();
        stoph = new Boolean[4];
        Arrays.fill(stoph, false);
        numHilo = 0;

        r1 = new Reloj();
        r2 = new Reloj();
        r3 = new Reloj();
        r4 = new Reloj();

        h1 = new Thread(this);
        h2 = new Thread(this);
        h3 = new Thread(this);
        h4 = new Thread(this);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }

    //CODIGO DE HILO
    public void iniciarRelojes() {
        hora1.setText(r1.imprimeHora());
        hora2.setText(r2.imprimeHora());
        hora3.setText(r3.imprimeHora());
        hora4.setText(r4.imprimeHora());
    }

    @Override
    public void run() {

        Thread hiloActual = Thread.currentThread();
        iniciarRelojes();

        while (hiloActual == h1 && !h1.isInterrupted()) {
            r1.pasarTiempo();
            hora1.setText(r1.imprimeHora());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }

        }
        while (hiloActual == h2 && !h2.isInterrupted()) {
            r2.pasarTiempo();
            hora2.setText(r2.imprimeHora());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }

        }
        while (hiloActual == h3 && !h3.isInterrupted()) {
            r3.pasarTiempo();
            hora3.setText(r3.imprimeHora());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        while (hiloActual == h4 && !h4.isInterrupted()) {
            r4.pasarTiempo();
            hora4.setText(r4.imprimeHora());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }

//        while (!stoph[0]) {
//            r1.pasarTiempo();
//            hora1.setText(r1.imprimeHora());
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//
//            }
//        }
//
//        while (!h2.isInterrupted()) {
//            r2.pasarTiempo();
//            hora2.setText(r2.imprimeHora());
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//
//            }
//        }
//
//        while (!stoph[2]) {
//            r3.pasarTiempo();
//            hora3.setText(r3.imprimeHora());
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//
//            }
//        }
//
//        while (!stoph[3]) {
//            r4.pasarTiempo();
//            hora4.setText(r4.imprimeHora());
//
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//
//            }
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelReloj2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        hora2 = new javax.swing.JLabel();
        jPanelReloj3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        hora3 = new javax.swing.JLabel();
        jPanelReloj4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hora4 = new javax.swing.JLabel();
        jPanelReloj1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hora1 = new javax.swing.JLabel();
        jBtnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Reloj 2");

        hora2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        hora2.setText("jLabel5");
        hora2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hora2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelReloj2Layout = new javax.swing.GroupLayout(jPanelReloj2);
        jPanelReloj2.setLayout(jPanelReloj2Layout);
        jPanelReloj2Layout.setHorizontalGroup(
            jPanelReloj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel2)
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(jPanelReloj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelReloj2Layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(hora2)
                    .addContainerGap(125, Short.MAX_VALUE)))
        );
        jPanelReloj2Layout.setVerticalGroup(
            jPanelReloj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(jPanelReloj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelReloj2Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(hora2)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );

        jLabel3.setText("Reloj 3");

        hora3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        hora3.setText("jLabel5");
        hora3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hora3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelReloj3Layout = new javax.swing.GroupLayout(jPanelReloj3);
        jPanelReloj3.setLayout(jPanelReloj3Layout);
        jPanelReloj3Layout.setHorizontalGroup(
            jPanelReloj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj3Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel3)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(jPanelReloj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelReloj3Layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(hora3)
                    .addContainerGap(126, Short.MAX_VALUE)))
        );
        jPanelReloj3Layout.setVerticalGroup(
            jPanelReloj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(jPanelReloj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelReloj3Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(hora3)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );

        jLabel4.setText("Reloj 4");

        hora4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        hora4.setText("jLabel5");
        hora4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hora4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelReloj4Layout = new javax.swing.GroupLayout(jPanelReloj4);
        jPanelReloj4.setLayout(jPanelReloj4Layout);
        jPanelReloj4Layout.setHorizontalGroup(
            jPanelReloj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj4Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel4)
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(jPanelReloj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelReloj4Layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(hora4)
                    .addContainerGap(125, Short.MAX_VALUE)))
        );
        jPanelReloj4Layout.setVerticalGroup(
            jPanelReloj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(jPanelReloj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelReloj4Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(hora4)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );

        jLabel1.setText("Reloj 1");

        hora1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        hora1.setText("jLabel5");
        hora1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hora1MouseClicked(evt);
            }
        });

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
                        .addComponent(hora1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelReloj1Layout.setVerticalGroup(
            jPanelReloj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReloj1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(hora1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnModificar.setText("Modificar Hora");
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelReloj3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelReloj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelReloj2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelReloj4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jBtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelReloj2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelReloj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelReloj3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelReloj4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jBtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hora2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hora2MouseClicked

        stoph[1] = true;
        h2.interrupt();
        numHilo = 2;
        h2 = new Thread(this);

        VistaModificacion modificar = new VistaModificacion();
        modificar.setVisible(true);
    }//GEN-LAST:event_hora2MouseClicked

    private void hora3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hora3MouseClicked

        stoph[2] = true;
        h3.interrupt();
        numHilo = 3;
        h3 = new Thread(this);

        VistaModificacion modificar = new VistaModificacion();
        modificar.setVisible(true);
    }//GEN-LAST:event_hora3MouseClicked

    private void hora4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hora4MouseClicked

        stoph[3] = true;
        h4.interrupt();
        numHilo = 4;
        h4 = new Thread(this);

        VistaModificacion modificar = new VistaModificacion();
        modificar.setVisible(true);
    }//GEN-LAST:event_hora4MouseClicked

    private void hora1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hora1MouseClicked

        stoph[0] = true;
        h1.interrupt();
        numHilo = 1;
        h1 = new Thread(this);

        VistaModificacion modificar = new VistaModificacion();
        modificar.setVisible(true);

    }//GEN-LAST:event_hora1MouseClicked

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed


    }//GEN-LAST:event_jBtnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaReloj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel hora1;
    private javax.swing.JLabel hora2;
    private javax.swing.JLabel hora3;
    private javax.swing.JLabel hora4;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelReloj1;
    private javax.swing.JPanel jPanelReloj2;
    private javax.swing.JPanel jPanelReloj3;
    private javax.swing.JPanel jPanelReloj4;
    // End of variables declaration//GEN-END:variables

}
