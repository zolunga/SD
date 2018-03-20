
package Vistas;

import Reloj.reloj;
import Sockets.SockServidor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaServidor extends javax.swing.JFrame implements Runnable{
    protected static reloj rel = new reloj();
    Thread h1, hserver;
    SockServidor ser;
    static String NuevoHora="0";
    static String NuevoMin="0";
    static String NuevoSeg="0";
    public VistaServidor() {
        initComponents();
        
        
        try {
            ser = new SockServidor();
            ser.iniciar();

        } catch (Exception e) {}
        
        setTitle("Servidor Hora");
        setLocationRelativeTo(null);
        setVisible(true);
        ip_puerto.setText(ser.getHOST() +":" +ser.getPUERTO());
        
        h1 = new Thread(this);
        hserver = new Thread(this);
        h1.start();
        hserver.start();
        
    }
    @Override
    public void run() 
    {
        Thread hilo = Thread.currentThread();
        while(hilo == h1 && !h1.isInterrupted())
        {
            rel.pasarTiempo();
            Hora.setText(rel.imprimeHora() );
            try 
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}
        }
        while(hilo == hserver)
        {
            ser.aceptar();


        }
        
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Hora = new javax.swing.JLabel();
        ip_puerto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Hora.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Hora.setText("jLabel1");
        Hora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoraMouseClicked(evt);
            }
        });

        ip_puerto.setText("jLabel2");
        ip_puerto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ip_puertoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(ip_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(ip_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ip_puertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ip_puertoMouseClicked
        
    }//GEN-LAST:event_ip_puertoMouseClicked

    private void HoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoraMouseClicked
        h1.interrupt();
        VistaCambio nuevo = new VistaCambio();
        nuevo.setVisible(true);
    }//GEN-LAST:event_HoraMouseClicked


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hora;
    private javax.swing.JLabel ip_puerto;
    // End of variables declaration//GEN-END:variables
}
