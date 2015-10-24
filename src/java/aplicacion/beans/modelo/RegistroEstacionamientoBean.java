/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.modelo;

import aplicacion.datos.hibernate.dao.IRegistroEstacionamientoDAO;
import aplicacion.modelo.dominio.GuiaPrecio;
import aplicacion.modelo.dominio.RegistroEstacionamiento;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author nahuel
 */
@ManagedBean
@ViewScoped
public class RegistroEstacionamientoBean implements Serializable{
    @ManagedProperty(value = "#{registroEstacionamiento}")
    private RegistroEstacionamiento registroEstacionamiento;
    @ManagedProperty(value = "#{registroEstacionamientoDAO}")
    private IRegistroEstacionamientoDAO registroEstacionamientoDAO;
    /**
     * Creates a new instance of RegistroEstacionamientoBean
     */
    public RegistroEstacionamientoBean() {
        registroEstacionamiento = new RegistroEstacionamiento();
        registroEstacionamiento.setGuiaPrecio(new GuiaPrecio());
    }
    /**
     * @return the registroEstacionamiento
     */
    public RegistroEstacionamiento getRegistroEstacionamiento() {
        return registroEstacionamiento;
    }

    /**
     * @param registroEstacionamiento the registroEstacionamiento to set
     */
    public void setRegistroEstacionamiento(RegistroEstacionamiento registroEstacionamiento) {
        this.registroEstacionamiento = registroEstacionamiento;
    }
    
    public IRegistroEstacionamientoDAO getRegistroEstacionamientoDAO() {
        return registroEstacionamientoDAO;
    }

    public void setRegistroEstacionamientoDAO(IRegistroEstacionamientoDAO registroEstacionamientoDAO) {
        this.registroEstacionamientoDAO = registroEstacionamientoDAO;
    }
}
