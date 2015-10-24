package aplicacion.modelo.dominio;


//import java.time.LocalTime;
import java.time.LocalTime;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nahuel
 */
public class RegistroEstacionamiento {
    private int codigo;
    private Date fecha;
    private String patente;
    private Date hEntrada;
    private Date hSalida;
    private double precioTotal;
    private GuiaPrecio guiaPrecio;

    public RegistroEstacionamiento() {
    }
        
    public void registrarEntrada(String patente, String tipoVehiculo){
        
    }
    public double registrarSalida(String patente){
        return 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Date gethEntrada() {
        return hEntrada;
    }

    public void sethEntrada(Date hEntrada) {
        this.hEntrada = hEntrada;
    }

    public Date gethSalida() {
        return hSalida;
    }

    public void sethSalida(Date hSalida) {
        this.hSalida = hSalida;
    }
    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public GuiaPrecio getGuiaPrecio() {
        return guiaPrecio;
    }

    public void setGuiaPrecio(GuiaPrecio guiaPrecio) {
        this.guiaPrecio = guiaPrecio;
    }
}
