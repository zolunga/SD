package Cliente;

import Reloj.reloj;

public class Cliente extends javax.swing.JFrame implements Runnable 
{
    public static reloj rel = new reloj();
    Thread Hcliente;
    Thread HReloj;
    String numero;
    String [] tem;
    clase_cliente clien;
    int interClien = 500;
    public Cliente() {
        initComponents();
        setTitle("Cliente");
        setLocationRelativeTo(null);
        setVisible(true);
        Hcliente = new Thread(this);
        HReloj = new Thread(this);
        HReloj.start();
        
    }
    @Override
    public void run() 
    {
        Thread hilo = Thread.currentThread();  
        while(hilo == Hcliente)
        {
            clien.EnEspera();
        }
        while(hilo == HReloj)
        {
            rel.pasarTiempo();
            jLabel_Reloj.setText(rel.imprimeHora());
            try {Thread.sleep(interClien);}
            catch (InterruptedException e){}
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Reloj = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_IP = new javax.swing.JTextField();
        jTextField_Puerto = new javax.swing.JTextField();
        jButtonConectar = new javax.swing.JButton();
        jLabel_jugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_Reloj.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel_Reloj.setText("jLabel1");

        jLabel2.setText("IP");

        jLabel3.setText("Puerto");

        jButtonConectar.setText("Conectar");
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });

        jLabel_jugador.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_Reloj, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jLabel_jugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Puerto)
                            .addComponent(jTextField_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel_Reloj)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jButtonConectar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel_jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel_jugador.getAccessibleContext().setAccessibleName("jLabel_jugador_intervalo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed
        if(jTextField_IP.getText() == null)
<<<<<<< Updated upstream
            clien = new clase_cliente("localhost", 3060);
        else
            clien = new clase_cliente(jTextField_IP.getText(),Integer.parseInt(jTextField_Puerto.getText().toString()));
=======
            clien = new clase_cliente("127.0.0.1", 3060);
        else
            clien = new clase_cliente(jTextField_IP.getText().toString(),Integer.parseInt(jTextField_Puerto.getText().toString()));
>>>>>>> Stashed changes
        jLabel_jugador.setText(clien.iniciar());
        interClien = clien.getIntervalo();
        Hcliente.start();
        jButtonConectar.setEnabled(false);
        jButtonConectar.setVisible(false);
    }//GEN-LAST:event_jButtonConectarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Reloj;
    private javax.swing.JLabel jLabel_jugador;
    private javax.swing.JTextField jTextField_IP;
    private javax.swing.JTextField jTextField_Puerto;
    // End of variables declaration//GEN-END:variables
}
