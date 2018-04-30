
package BaseDatos;

import entity.Equipos;
import entity.HibernateUtil;
import entity.Lamportcentral;
import entity.Tiempoequipos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BD {
    Session session;
    public BD()
    {
        
    }
    public void clear()
    {
        String stringQuery = "DELETE FROM Equipos";
        Query query = session.createQuery(stringQuery);
        query.executeUpdate();
    }
    
    public void Insertar(String IP, String Nombre, int intervalo)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Equipos x = new Equipos();
        //x.setIdEquipos(Integer.valueOf(Nombre));
        x.setIp(IP);
        x.setNombre(Nombre);
        x.setIntervalo(intervalo);
        Transaction t = session.beginTransaction();
        session.save(x);
        t.commit();
    }
    
    public void LamportN()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Lamportcentral x = new Lamportcentral();
        x.setContLocal(1);
        x.setContNuevo(1);
        Transaction t = session.beginTransaction();
        session.save(x);
        t.commit();
        
    }
    
    public void AgregarTiempos()
    {
        Lamportcentral l = new Lamportcentral();
        Tiempoequipos x = new Tiempoequipos();
        
        
    }
    public void limpiar()
    {
        
    }
}
