package entity;
// Generated Apr 28, 2018 6:01:06 PM by Hibernate Tools 4.3.1



/**
 * Tiempoequipos generated by hbm2java
 */
public class Tiempoequipos  implements java.io.Serializable {


     private int idTiempoEq;
     private Equipos equiposByIdEquipo;
     private Equipos equiposByIdEquipoNext;
     private Lamportcentral lamportcentral;
     private String cequipo;
     private String cmensaje;

    public Tiempoequipos() {
    }

	
    public Tiempoequipos(int idTiempoEq) {
        this.idTiempoEq = idTiempoEq;
    }
    public Tiempoequipos(int idTiempoEq, Equipos equiposByIdEquipo, Equipos equiposByIdEquipoNext, Lamportcentral lamportcentral, String cequipo, String cmensaje) {
       this.idTiempoEq = idTiempoEq;
       this.equiposByIdEquipo = equiposByIdEquipo;
       this.equiposByIdEquipoNext = equiposByIdEquipoNext;
       this.lamportcentral = lamportcentral;
       this.cequipo = cequipo;
       this.cmensaje = cmensaje;
    }
   
    public int getIdTiempoEq() {
        return this.idTiempoEq;
    }
    
    public void setIdTiempoEq(int idTiempoEq) {
        this.idTiempoEq = idTiempoEq;
    }
    public Equipos getEquiposByIdEquipo() {
        return this.equiposByIdEquipo;
    }
    
    public void setEquiposByIdEquipo(Equipos equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }
    public Equipos getEquiposByIdEquipoNext() {
        return this.equiposByIdEquipoNext;
    }
    
    public void setEquiposByIdEquipoNext(Equipos equiposByIdEquipoNext) {
        this.equiposByIdEquipoNext = equiposByIdEquipoNext;
    }
    public Lamportcentral getLamportcentral() {
        return this.lamportcentral;
    }
    
    public void setLamportcentral(Lamportcentral lamportcentral) {
        this.lamportcentral = lamportcentral;
    }
    public String getCequipo() {
        return this.cequipo;
    }
    
    public void setCequipo(String cequipo) {
        this.cequipo = cequipo;
    }
    public String getCmensaje() {
        return this.cmensaje;
    }
    
    public void setCmensaje(String cmensaje) {
        this.cmensaje = cmensaje;
    }




}


