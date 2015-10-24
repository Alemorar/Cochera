/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.modelo;

import aplicacion.datos.hibernate.dao.IGuiaPrecioDAO;
import aplicacion.modelo.dominio.GuiaPrecio;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author nahuel
 */
@ManagedBean
@RequestScoped
public class GuiaPrecioBean implements Serializable{
    @ManagedProperty(value = "#{guiaPrecio}")
    private GuiaPrecio guiaPrecio;
    @ManagedProperty(value = "#{guiaPrecioDAO}")
    private IGuiaPrecioDAO precioDAO;
    

    public IGuiaPrecioDAO getPrecioDAO() {
        return precioDAO;
    }

    public void setPrecioDAO(IGuiaPrecioDAO precioDAO) {
        this.precioDAO = precioDAO;
    }
    /**
     * Creates a new instance of GuiaPrecioBean
     */
    public GuiaPrecioBean() {
        guiaPrecio = new GuiaPrecio();
    }

    public GuiaPrecio getGuiaPrecio() {
        return guiaPrecio;
    }

    public void setGuiaPrecio(GuiaPrecio guiaPrecio) {
        this.guiaPrecio = guiaPrecio;
    }
    
}
