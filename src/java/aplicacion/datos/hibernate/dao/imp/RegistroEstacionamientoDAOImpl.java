/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IRegistroEstacionamientoDAO;
import aplicacion.modelo.dominio.RegistroEstacionamiento;
import java.io.Serializable;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author nahuel
 */
public class RegistroEstacionamientoDAOImpl extends HibernateDaoSupport implements IRegistroEstacionamientoDAO, Serializable{

    @Override
    @Transactional
    public void guardarRegistro(RegistroEstacionamiento registroEstacionamiento) {
        getHibernateTemplate().save(registroEstacionamiento);
    }
    
    @Override
    @Transactional
    public void actualizarRegistro(RegistroEstacionamiento registroEstacionamiento){
        System.out.println("Actualiza registro de estacionamiento");
        System.out.println(registroEstacionamiento.getCodigo());
        System.out.println(registroEstacionamiento.getPatente());
        getHibernateTemplate().update(registroEstacionamiento);
        
    }

    @Override
    public ArrayList<RegistroEstacionamiento> getRegistrosEntrada() {
        DetachedCriteria criteria = DetachedCriteria.forClass(RegistroEstacionamiento.class);
        return (ArrayList)getHibernateTemplate().findByCriteria(criteria);
    }
}
