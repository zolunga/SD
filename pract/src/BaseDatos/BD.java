
package BaseDatos;

import entity.Equipos;
import entity.HibernateUtil;
import entity.LamportCentral;
import entity.TiempoEquipos;
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
        LamportCentral x;
        x = (LamportCentral) session.get(LamportCentral.class, 1);
        if (x == null) 
        {
            x = new LamportCentral();
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
        LamportCentral x = (LamportCentral) session.get(LamportCentral.class, 1);
        Equipos ObActual = (Equipos) session.get(Equipos.class, Actual);
        Equipos ObSiguiente = (Equipos) session.get(Equipos.class, siguiente);
        TiempoEquipos tiempo = new TiempoEquipos(ObActual, ObSiguiente, x, equipo, Mensaje);
        Transaction t = session.beginTransaction();
        session.save(tiempo);
        t.commit();       
        
    }
    public void limpiar()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = String.format("delete from Equipos");
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }
    
    public List lista ()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Query consulta = session.createQuery("from TiempoEquipos");
        List lista = consulta.list();   
        return lista;
    }
}
