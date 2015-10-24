/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.GuiaPrecio;
import java.util.ArrayList;

/**
 *
 * @author nahuel
 */
public interface IGuiaPrecioDAO {
    
    public void crearGuiaPrecio(GuiaPrecio guiaPrecio);
    public ArrayList<GuiaPrecio> getGuias();
}
