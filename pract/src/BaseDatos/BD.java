
package BaseDatos;

import entity.Equipos;
import entity.HibernateUtil;
import entity.Lamportcentral;
import entity.Tiempoequipos;
import java.util.List;
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
        Lamportcentral x;
        x = (Lamportcentral) session.get(Lamportcentral.class, 1);
        if (x == null) 
        {
            x = new Lamportcentral();
            x.setIdCentral(1);
            x.setContLocal(1);
            x.setContNuevo(1);
            Transaction t = session.beginTransaction();
            session.save(x);
            t.commit();
        }     
    }
    
    public void AgregarTiempos( int Actual, int siguiente, String Mensaje, String equipo)
    {
        Lamportcentral x = (Lamportcentral) session.get(Lamportcentral.class, 1);
        Equipos ObActual = (Equipos) session.get(Equipos.class, Actual);
        Equipos ObSiguiente = (Equipos) session.get(Equipos.class, siguiente);
        Tiempoequipos tiempo = new Tiempoequipos(ObActual, ObSiguiente, x, equipo, Mensaje);
        Transaction t = session.beginTransaction();
        session.save(tiempo);
        t.commit();       
        
    }
    public void limpiar()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = String.format("delete from equipos");
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }
    
    public List lista ()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Query consulta = session.createQuery("from Tiempoequipos");
        List lista = consulta.list();   
        return lista;
    }
}
