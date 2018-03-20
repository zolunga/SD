package Sockets;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;


public class SockServidor 
{

    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }
    
    private int PUERTO; //Puerto para la conexión
    private String HOST; //Host para la conexión
    protected ServerSocket ss; //Socket del servidor
    protected Socket sock;
    BufferedReader entrada;
    DataOutputStream salida;
    public SockServidor()
    {
        String msj;
        try
        {
            HOST = InetAddress.getLocalHost().getHostAddress();
            PUERTO = 3060;
            
        }
        catch (IOException e) 
        {
            System.out.println("Error de entrada/salida.");
        }
    }
    public void iniciar()
    {
        try
        {
            ss = new ServerSocket(PUERTO);
            System.out.println("Esperando Conexion");            
        }
        catch (IOException e) 
        {
            System.out.println("Error de entrada/salida.");
        }
        
    }
    public void aceptar()
    {
        try
        {
            sock = ss.accept();
            System.out.println("accept");
        
            entrada = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
            salida = new DataOutputStream(sock.getOutputStream());
            System.out.println(entrada.readLine()); //Cliente Conectado
            
            System.out.println("EnviandoHora");
            salida.writeUTF("Enviando Hora");
            System.out.println("Termino de comunicacion");
            
        }
        catch (IOException e) 
        {
            System.out.println("Error de entrada/salida.");
        }
    }
}
