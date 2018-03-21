
package Sockets;

import Vistas.VistaCliente;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SockCliente 
{
    private Socket sock;
    private static String HOST = "localhost";
    private static int PUERTO = 3060;
    private String HoraServidor;
    DataOutputStream mensaje;
    BufferedReader Mensaje_Servidor;
    public SockCliente()
    {  
        try 
        {
            sock = new Socket(HOST, PUERTO);
            Mensaje_Servidor = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
            mensaje = new DataOutputStream(sock.getOutputStream());
            
                     
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }
    
    public SockCliente(String host, int puerto)
    {
        try 
        {
            sock = new Socket(host, puerto);
            Mensaje_Servidor = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
            mensaje = new DataOutputStream(sock.getOutputStream());
            
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }
    
    public void iniciar()
    {
        try 
        {
            System.out.println("En com");
            mensaje.writeUTF("Cliente conectado");
            System.out.println("Esperando...");
            //System.out.println(Mensaje_Servidor.readLine());
            VistaCliente.rel1.modificarHora(1, 1, 1);
            sock.close();
            System.out.println("fin");
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
        
        
    }
}
