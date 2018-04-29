
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
    private String jugador;

    
    DataOutputStream salida;
    DataInputStream Entrada;
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

    public void iniciar() {
        try {
            System.out.println(IP);
            enviarMSJ("Mi IP es:" + IP);  //Envia IP
            System.out.println("Numero de jugador: "+Entrada.readUTF()); //Recibe Numero asignado por el servidor
            
            salida.writeUTF("Mihora es:");
            
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }

    }    
    
    public void EnEspera()
    {
        String temporal;
        try {
            while (true){
                temporal = Entrada.readUTF();
                System.out.println("hilo de espera:"+temporal);
                if(temporal.equals("Chambear"))
                {
                    System.out.println("WORK");
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error de entrada/salida.");
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
    
    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
}
