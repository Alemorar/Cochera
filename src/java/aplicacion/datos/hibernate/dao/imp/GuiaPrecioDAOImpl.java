/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IGuiaPrecioDAO;
import aplicacion.modelo.dominio.GuiaPrecio;
import java.io.Serializable;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author nahuel
 */
public class GuiaPrecioDAOImpl extends HibernateDaoSupport implements IGuiaPrecioDAO, Serializable{
    @Override
    @Transactional
    public void crearGuiaPrecio(GuiaPrecio guiaPrecio){
        getHibernateTemplate().save(guiaPrecio);
    }
    
    public ArrayList<GuiaPrecio> getGuias(){
        DetachedCriteria criteria = DetachedCriteria.forClass(GuiaPrecio.class);
        return (ArrayList)getHibernateTemplate().findByCriteria(criteria);
//        GuiaPrecio g1 = new GuiaPrecio();
//        g1.setCodigo(1);
//        g1.setTipoVehiculo("Moto");
//        g1.setPrecio(11.4);
//        resultado.add(g1);
//        GuiaPrecio g2 = new GuiaPrecio();
//        g2.setCodigo(2);
//        g2.setTipoVehiculo("Auto");
//        g2.setPrecio(25);
//        resultado.add(g2);
        //return resultado;
    }
}
