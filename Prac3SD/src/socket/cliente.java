
package socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import socket.conexion;

public class cliente extends conexion
{
    public cliente() throws IOException {super("cliente");}
    public void starClient()
    {
        try
        {
            dis = new DataInputStream(sock.getInputStream());
            salidaServidor = new DataOutputStream(sock.getOutputStream());
            salidaServidor.writeUTF("Probando conexion");
            salidaServidor.writeUTF("Probando conexion");
            salidaServidor.writeUTF("Probando conexion");
            System.out.println(dis);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public String SolicitarHora()
    {
        String Hora = "";
        return Hora;
    }
}
