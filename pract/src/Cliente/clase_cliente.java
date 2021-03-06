
package Cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import Cliente.Cliente; 

public class clase_cliente 
{
 private Socket sock;
    private static String HOST = "10.100.72.14";
    private static int PUERTO = 8691;
    private String HoraServidor;
    private String IP;
    private int jugador;
    private int Intervalo = 500;
    private String NuevaHora;
    DataOutputStream salida; // enviar mensajes
    DataInputStream Entrada; //recibir mensajes



    public clase_cliente() {
        try {
            sock = new Socket(HOST, PUERTO);
            salida = new DataOutputStream(sock.getOutputStream());
            IP = InetAddress.getLocalHost().getHostAddress();
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            System.out.println(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public clase_cliente(String host, int puerto) {
        try {
            System.out.println(host + ": "+ puerto);
            sock = new Socket(host, puerto);
            Entrada = new DataInputStream(sock.getInputStream());
            salida = new DataOutputStream(sock.getOutputStream());          
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public String iniciar() 
    {           
        IP = HOST;
        System.out.println(IP);
        enviarMSJ(IP);  //Envia IP
        jugador = Integer.parseInt(recibirMSJ());
        Intervalo = Integer.parseInt(recibirMSJ());
        System.out.println("Numero de jugador: "+jugador); //Recibe Numero asignado por el servidor
        System.out.println("Intervalo"+Intervalo);
        return "Jugador"+jugador+":"+Intervalo;
    }    
    
    public void EnEspera()
    {
        String temporal;
        String division [];
        int segundos=0;
        while (true)
        {
            temporal = recibirMSJ();
            System.out.println("hilo de espera:"+temporal);
            if(temporal.equals("Lamport"))
            {   
                temporal = Cliente.rel.imprimeHora();
                System.out.println(temporal);
                enviarMSJ(temporal);
                temporal = recibirMSJ();
                segundos = Integer.valueOf(temporal);
                for (int i = 0; i < segundos; i++) {
                    Cliente.rel.pasarTiempo();
                }
                System.out.println("Cambio +" + temporal);               
            }
        }
    }
    
    private void enviarMSJ(String buffer)
    {
        try {
            salida.writeUTF(buffer);
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }
    
    private String recibirMSJ() 
    {
        String buffer = "";
        try {
            buffer = Entrada.readUTF();
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
        return buffer;
    }
    
    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }
    
    public int getIntervalo() {
        return Intervalo;
    }

    public void setIntervalo(int Intervalo) {
        this.Intervalo = Intervalo;
    }
    
    public String getNuevaHora() {
        return NuevaHora;
    }

    public void setNuevaHora(String NuevaHora) {
        this.NuevaHora = NuevaHora;
    }

}
