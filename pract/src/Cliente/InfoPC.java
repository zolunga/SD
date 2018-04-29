
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class InfoPC {
    private String IP;
    private String NumeroJugador;
    private String Hora;
    private DataInputStream Entrada;
    private DataOutputStream Salida;
    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getNumeroJugador() {
        return NumeroJugador;
    }

    public void setNumeroJugador(String NumeroJugador) {
        this.NumeroJugador = NumeroJugador;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    
    
    public InfoPC()
    {
        
    }
    
}
