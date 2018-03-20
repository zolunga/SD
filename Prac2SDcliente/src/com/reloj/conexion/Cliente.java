package com.reloj.conexion;

import com.reloj.conexion.Conexion;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Conexion {

    private Scanner entrada;
    private String mensaje;
    private String horaModificada;
    private int horas[];

    public Cliente() throws IOException {
        super("cliente");
        horaModificada = "";
        horas = new int[3];
    } //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try {
            dis = new DataInputStream(cs.getInputStream());
            
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
//            salidaCliente.writeUTF("Soy el cliente 1 dame hora");
//            salidaServidor.writeUTF("Soy el cliente 1 deme una orden _/");
             salidaServidor.write(1);

            for (int i = 0; i < 3; i++) {
                horas[i] = dis.read();
            }

            for (int i = 0; i < 3; i++) {
                System.out.println("Recibido: " + horas[i]);
            }
            
            horaModificada = horas[0] + " : " + horas[1] + " : " + horas[2];
            //Se escribe en el servidor usando su flujo de datos
            salidaServidor.writeUTF("Recibida la hora correctamente " + horaModificada);

            cs.close();//Fin de la conexión

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getHoraModificada() {
        return this.horaModificada;
    }
    
    public int[] getHoraMinSeg(){
        return this.horas;
    }
    
    public String getIP(){
        return "" + cs.getInetAddress();
    } 
}
