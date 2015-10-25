/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.forms;

import aplicacion.beans.modelo.RegistroEstacionamientoBean;
import aplicacion.modelo.dominio.RegistroEstacionamiento;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import static javassist.CtMethod.ConstParameter.integer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.context.RequestContext;

/**
 *
 * @author nahuel
 */
@ManagedBean
@ViewScoped
public class RegistroEstacionamientoFormBean implements Serializable{
    @ManagedProperty(value = "#{registroEstacionamientoBean}")
    private RegistroEstacionamientoBean registroEstacionamientoBean;
    /**
     * Creates a new instance of RegistroEstacionamientoFormBean
     */
    public RegistroEstacionamientoFormBean() {
    }
    
    public void mostrarConfirmacionRegistro(){
        RequestContext.getCurrentInstance().execute("PF('confirmaRegistrarEntrada').show()");
    }
    
    public void exportarPDF() throws JRException, IOException{
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/newReport.jasper"));
        JRBeanCollectionDataSource jRBeanCollectionDataSource = new JRBeanCollectionDataSource(this.getRegistrosEntradas());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), new HashMap(), jRBeanCollectionDataSource);
        
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Context-Disposition", "attachment; filename=reporte.pdf");
        ServletOutputStream stream = response.getOutputStream();
        
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
    }
    
    public ArrayList<RegistroEstacionamiento> getRegistrosEntradas(){
        //System.out.println("Cant reg: " + registroEstacionamientoBean.getRegistroEstacionamientoDAO().getRegistrosEntrada().size());
        return registroEstacionamientoBean.getRegistroEstacionamientoDAO().getRegistrosEntrada();
        
    } 
    
    public void actualizarHoraEntrada(){
        registroEstacionamientoBean.getRegistroEstacionamiento().sethEntrada(new Date(System.currentTimeMillis()));
    }
    
    public void establecerElegido(RegistroEstacionamiento registroEstacionamiento){
        System.out.println("paso ....");
        registroEstacionamientoBean.setRegistroEstacionamiento(registroEstacionamiento);
        System.out.println("Acutualizohorasalida");
        actualizarHoraSalida();
        System.out.println("Actualizopreciototal");
        actualizarPrecioTotal();
        RequestContext.getCurrentInstance().execute("PF('confirmaRegistrarSalida').show()");
        System.out.println(registroEstacionamientoBean.getRegistroEstacionamiento().getCodigo() + " " + registroEstacionamientoBean.getRegistroEstacionamiento().gethSalida());
    }
    
    public void actualizarHoraSalida(){
        registroEstacionamientoBean.getRegistroEstacionamiento().sethSalida(new Date(System.currentTimeMillis()));
    }
    
    public void actualizarPrecioTotal(){
        Calendar calendarEnt = Calendar.getInstance();
        Calendar calendarSal = Calendar.getInstance();
        calendarEnt.setTime(registroEstacionamientoBean.getRegistroEstacionamiento().gethEntrada());
        calendarSal.setTime(registroEstacionamientoBean.getRegistroEstacionamiento().gethSalida());
        if (calendarSal.get(Calendar.MINUTE) >= 11){
            calendarSal.add(Calendar.HOUR, 1);
        }
        long milis1 = calendarEnt.getTimeInMillis();
        long milis2 = calendarSal.getTimeInMillis();
        long diff = milis2 - milis1;
        System.out.println("diff" + diff);
        long diffHours = diff / (60 * 60 * 1000);
        System.out.println("diffHours" + diffHours);
        float totalHoras = (float) (diffHours * registroEstacionamientoBean.getRegistroEstacionamiento().getGuiaPrecio().getPrecio());
        System.out.println("totalHoras" + totalHoras);
        totalHoras = totalHoras * 100 / 100;
        System.out.println("totalHoras2" + totalHoras);
        registroEstacionamientoBean.getRegistroEstacionamiento().setPrecioTotal(totalHoras);
    }
    
    public void actualizarEstacionamiento(){
        System.out.println("entro al FormBean");
        registroEstacionamientoBean.getRegistroEstacionamientoDAO().actualizarRegistro(registroEstacionamientoBean.getRegistroEstacionamiento());
        System.out.println("aca debe cerrar el boton de confirmacion");
        RequestContext.getCurrentInstance().execute("PF('confirmaRegistrarSalida').hide()");
    }
    
    public void guardarEstacionamiento(){
        registroEstacionamientoBean.getRegistroEstacionamiento().setFecha(new Date());
        registroEstacionamientoBean.getRegistroEstacionamientoDAO().guardarRegistro(registroEstacionamientoBean.getRegistroEstacionamiento());
    }

    public RegistroEstacionamientoBean getRegistroEstacionamientoBean() {
        return registroEstacionamientoBean;
    }

    public void setRegistroEstacionamientoBean(RegistroEstacionamientoBean registroEstacionamientoBean) {
        this.registroEstacionamientoBean = registroEstacionamientoBean;
    }
    
}
