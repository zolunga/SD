
package Servidor;

import BaseDatos.BD;
import Cliente.InfoPC;
import entity.TiempoEquipos;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
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
    BD con;
    List Resultado;
    String tem;
    public Server() 
    {
        con = new BD();
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
        jLabel_res = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_res2 = new javax.swing.JLabel();
        jLabel_Res3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_Lamport.setText("Sincronizar");
        jButton_Lamport.setToolTipText("");
        jButton_Lamport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LamportActionPerformed(evt);
            }
        });

        jLabel_res.setText("-");

        jButton1.setText("Ver Ultimos Registros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel_res2.setText("-");

        jLabel_Res3.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_res, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_res2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Res3, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_Lamport, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel_res)
                .addGap(13, 13, 13)
                .addComponent(jLabel_res2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Res3)
                .addGap(52, 52, 52)
                .addComponent(jButton_Lamport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LamportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LamportActionPerformed
        iniciar_lamp = 1;
        
        
    }//GEN-LAST:event_jButton_LamportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Resultado = con.lista();
        int i, j;
        String tem[] = new String[3];
        for (i = Resultado.size()-3, j = 0; i < Resultado.size(); i++, j++) 
        {
            tem[j] = "";
            tem[j] += (((TiempoEquipos)Resultado.get(i)).getCequipo()) +" Tiempo:"+(((TiempoEquipos)Resultado.get(i)).getCmensaje()) + " Siguiente:" + (((TiempoEquipos)Resultado.get(i)).getEquiposByIdEquipoNext().getNombre());          
        }
        jLabel_res.setText(tem[0]);
        jLabel_res2.setText(tem[1]);
        jLabel_Res3.setText(tem[2]);
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Lamport;
    private javax.swing.JLabel jLabel_Res3;
    private javax.swing.JLabel jLabel_res;
    private javax.swing.JLabel jLabel_res2;
    // End of variables declaration//GEN-END:variables
}
