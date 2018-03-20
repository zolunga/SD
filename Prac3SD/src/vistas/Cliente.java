package vistas;
import reloj.reloj;
import socket.cliente;
import socket.server;
import static vistas.Servidor.rel;

public class Cliente extends javax.swing.JFrame implements Runnable
{
    protected static reloj relS1 = new reloj();
    protected static reloj relS2 = new reloj();
    Thread R1, R2; // hilos reloj
    //Thread Cliente1, Cliente2; // hilos socket
    
    public Cliente() {
        initComponents();
        R1 = new Thread(this);
        R2 = new Thread(this);
        //Cliente1 = new Thread(this);
        //Cliente2 = new Thread(this);
        R1.start();
        R2.start();
        //Cliente1.start();
        //Cliente2.start();
        setTitle("Cliente Hora");
        setLocationRelativeTo(null);
        setVisible(true);
        System.out.println("inicio");
    }

    @Override
    public void run() 
    {
        Thread hilo = Thread.currentThread();
        while(hilo == R1)
        {
            relS1.pasarTiempo();
            Hora1.setText(relS1.imprimeHora());
            try 
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}
        }
        
        while(hilo == R2)
        {
            relS2.pasarTiempo();
            Hora2.setText(relS2.imprimeHora());
            try 
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}
        }
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Hora1 = new javax.swing.JLabel();
        Hora2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Hora1.setText("jLabel1");

        Hora2.setText("jLabel2");

        jButton1.setText("Servidor1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Servidor2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Hora1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Hora2)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hora1)
                    .addComponent(Hora2))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        Hora1.getAccessibleContext().setAccessibleName("Hora1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("Solicitando hora a servidor 2" );
        try 
        {
            System.out.println("Iniciando Cliente");
            cliente client = new cliente();
            client.starClient();
        } 
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Solicitando hora a servidor 1" );
        try 
        {
            System.out.println("Iniciando Cliente");
            cliente client = new cliente();
            client.starClient();
        } 
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hora1;
    private javax.swing.JLabel Hora2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
