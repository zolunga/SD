
package Servidor;

import Cliente.InfoPC;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends javax.swing.JFrame implements Runnable
{
    Thread HServidor;
    Thread HLamport;
    clase_server ser;
    int Jugador = 0;
    int iniciar_lamp = 0;
    InfoPC equipos[] = new InfoPC[20];
    public Server() 
    {
        try 
        {
            ser = new clase_server();
            ser.iniciar();
        } catch (Exception e) {}
        
        initComponents();
        setTitle("Servidor");
        setLocationRelativeTo(null);
        setVisible(true);
        
        HServidor = new Thread(this);
        HLamport =  new Thread(this);
        
        HLamport.start();
        HServidor.start();
        try {
            System.out.println("Servidor en funcionamiento en: " +InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(clase_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() 
    {
        Thread hilo = Thread.currentThread();
        while (hilo == HServidor)
        {
            //equipos[Jugador].setNumero(Jugador);
            //ser.aceptar(equipos[Jugador]);
            equipos[Jugador]=ser.aceptar(Jugador);
            Jugador++;
        }
        while (hilo == HLamport)
        {
            try {Thread.sleep(1000);}
            catch (InterruptedException e){}
            if (iniciar_lamp ==  1) {
                System.out.println("llamando LAMPORT");
                ser.Lamport(equipos);
                iniciar_lamp = 0;
            }
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Lamport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_Lamport.setText("jButton1");
        jButton_Lamport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LamportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jButton_Lamport, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addComponent(jButton_Lamport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LamportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LamportActionPerformed
        iniciar_lamp = 1;
        
    }//GEN-LAST:event_jButton_LamportActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Lamport;
    // End of variables declaration//GEN-END:variables
}
