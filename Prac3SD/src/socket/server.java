package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import socket.conexion;

public class server extends conexion
{



    public void iniciarServer()
    {
        
        try
        {
            dis = new DataInputStream(sock.getInputStream());
            System.out.println("Esperando cliente...");
            sock = ss.accept();
            System.out.println("Cliente conectado...");
            salidaCliente = new DataOutputStream(sock.getOutputStream());
            salidaCliente.writeUTF("conexion exitosa");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            while(true)
            {
                System.out.println("esp");
                
                mensajeServidor = entrada.readLine();
                System.out.println("Algo: " + mensajeServidor);
                System.out.println(dis);
                if(mensajeServidor.equals("fin"))
                    break;
            }
            ss.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    public server() throws IOException
    {
        super("servidor");
    }
}
