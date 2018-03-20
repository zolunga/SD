package prac2sd;

import com.reloj.conexion.Cliente;
import java.io.IOException;

//Clase principal que hará uso del cliente
public class MainCliente {

    public static void main(String[] args) throws IOException {

        while (true) {
            try {
                Cliente cli = new Cliente(); //Se crea el cliente

                System.out.println("Iniciando cliente\n");
                cli.startClient(); //Se inicia el cliente
            } catch (Exception e) {
                System.out.println("No se ha conectado con el servidor " + e.getMessage());
            }
        }

    }
}
