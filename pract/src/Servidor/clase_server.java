package Servidor;
import BaseDatos.BD;
import Cliente.InfoPC;
import entity.Equipos;
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
    private int JugadorAtendido;
    BD con;

    public clase_server() {
        PUERTO = 3060;
        con = new BD();
    }

    public void iniciar() 
    {      
        //con.clear();
        try 
        {
            ss = new ServerSocket(PUERTO);
            ms = new DataInputStream(sock.getInputStream());         
            System.out.println("Esperando Conexion");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public InfoPC aceptar(int jugador) 
    {   
        InfoPC JugadorNuevo = new InfoPC();
        String tem;
        int numero = ((int) (Math.random() * 10) + 1) * 500;
        try 
        {
            System.out.println("accept");
            sock = ss.accept();
            entrada = new DataInputStream(sock.getInputStream());
            salida = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
        tem = recibirMSJ(); // recibe IP
        System.out.println(tem);  
        
        enviarMSJ(Integer.toString(jugador));
        enviarMSJ(Integer.toString(numero));
        con.Insertar(tem,Integer.toString(jugador), numero);
        JugadorNuevo.setNumero(jugador);
        JugadorNuevo.setEntrada(entrada);
        JugadorNuevo.setSalida(salida);
        return JugadorNuevo;
    }
    public void Lamport(InfoPC [] equiposC)
    {
        String Horas[] = new String[3];
        String Tem [][] = new String [3][];
        int comparador = 0;
        int ResultadoComparacion = 0;
        System.out.println("INICIANDO FUNCION LAMPORT ");
        for (int i = 0; i < 3; i++) 
        {
            entrada = equiposC[i].getEntrada();
            salida = equiposC[i].getSalida();
            enviarMSJ("Lamport");
            Horas[i] = recibirMSJ();
            System.out.println(equiposC[i].getNumero() + ": :" +Horas[i]);
            Tem[i] = Horas[i].split(":");
        }
        if ( (Integer.valueOf(Tem[0][0]) == Integer.valueOf(Tem[1][0])) && (Integer.valueOf(Tem[1][0]) == Integer.valueOf(Tem[2][0])) )
        {
            if ( (Integer.valueOf(Tem[0][1]) == Integer.valueOf(Tem[1][1])) && (Integer.valueOf(Tem[1][1]) == Integer.valueOf(Tem[2][1])) )
            {
                for (int i = 0; i < 3; i++) 
                {
                    if(Integer.valueOf(Tem[i][2]) > comparador) // segundos
                    {
                        System.out.println("Comparacion en segundos");
                        System.out.println(Integer.valueOf(Tem[i][2]) +">"+comparador);
                        comparador = Integer.valueOf(Tem[i][2]);
                        ResultadoComparacion = i;
                    }
                }
            }
            else
            {
                for (int i = 0; i < 3; i++) 
                {
                    if(Integer.valueOf(Tem[i][1]) > comparador) // minutos
                    {
                        System.out.println("Comparacion en Minutos");
                        System.out.println(Integer.valueOf(Tem[i][1]) +">"+comparador);
                        comparador = Integer.valueOf(Tem[i][1]);
                        ResultadoComparacion = i;
                    }
                }
            }            
        }
        else
        {
            for (int i = 0; i < 3; i++) 
            {
                if(Integer.valueOf(Tem[i][0]) > comparador) // horas
                {
                    System.out.println("Comparacion en Horas");
                    System.out.println(Integer.valueOf(Tem[i][0]) +">"+comparador);
                    comparador = Integer.valueOf(Tem[i][0]);
                    ResultadoComparacion = i;
                }
            }
        }
        for (int i = 0; i < 3; i++) 
        {
            entrada = equiposC[i].getEntrada();
            salida = equiposC[i].getSalida();
            enviarMSJ(Horas[ResultadoComparacion]);                         
        }
        System.out.println("Resultado Lamport: " + ResultadoComparacion);
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
