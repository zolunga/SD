package Servidor;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class clase_server {
    private int PUERTO; //Puerto para la conexión
    private String HOST; //Host para la conexión
    protected ServerSocket ss; //Socket del servidor
    protected Socket sock;
    DataInputStream entrada;
    DataInputStream ms;
    DataOutputStream salida;

    public clase_server() {
        String msj;
        PUERTO = 3060;
    }

    public void iniciar() 
    {      
        try 
        {
            ss = new ServerSocket(PUERTO);
            ms = new DataInputStream(sock.getInputStream());         
            System.out.println("Esperando Conexion");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public void aceptar(int jugador) 
    {
        try 
        {
            System.out.println("accept");
            sock = ss.accept();
            entrada = new DataInputStream(sock.getInputStream());
            salida = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
        System.out.println(recibirMSJ());
        enviarMSJ(Integer.toString(jugador));

    }
    public void Lamport()
    {
        System.out.println("INICIANDO FUNCION LAMPORT ");
        enviarMSJ("Chambear");
    }
    
    private void enviarMSJ(String buffer)
    {
        try 
        {
            salida.writeUTF(buffer);
        }
        catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }
    
    private String recibirMSJ()
    {
        String buffer = "";
        try 
        {
            buffer = entrada.readUTF();
        }
        catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
        return buffer;
    }
    
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
}
