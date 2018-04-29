
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

public class clase_cliente 
{
 private Socket sock;
    private static String HOST = "localhost";
    private static int PUERTO = 3060;
    private String HoraServidor;
    private String IP;
    private int jugador;
    private int Intervalo = 500;
//    private Reloj.reloj RelojOperaciones;

    
    
    DataOutputStream salida; // enviar mensajes
    DataInputStream Entrada; //recibir mensajes
    BufferedReader Mensaje_Servidor;
    
    String [] horaMod;

    public clase_cliente() {
        try {
            sock = new Socket(HOST, PUERTO);
            Mensaje_Servidor = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            salida = new DataOutputStream(sock.getOutputStream());
            IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public clase_cliente(String host, int puerto) {
        try {
            sock = new Socket(host, puerto);
            Entrada = new DataInputStream(sock.getInputStream());
            salida = new DataOutputStream(sock.getOutputStream());          
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public void iniciar() 
    {           
        
        System.out.println(IP);
        enviarMSJ("Mi IP es:" + IP);  //Envia IP
        jugador = Integer.parseInt(recibirMSJ());
        System.out.println("Numero de jugador: "+jugador); //Recibe Numero asignado por el servidor
        Intervalo = Intervalo * jugador;
    }    
    
    public void EnEspera()
    {
        String temporal;     
        while (true)
        {
            temporal = recibirMSJ();
            System.out.println("hilo de espera:"+temporal);
            if(temporal.equals("Chambear"))
            {   
                temporal = Cliente.rel.imprimeHora();
                System.out.println(temporal);
                enviarMSJ(temporal);
                System.out.println("WORK");
                break;
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
}
