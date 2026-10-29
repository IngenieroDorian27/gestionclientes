/*
 * Clase cliente
 */
package Model;

import java.time.LocalDate;
import java.util.Map;

/**
 *

 */
public class Cliente {
    private LocalDate fecha = LocalDate.now();
    private String nombre;
    private String cedula;
    private String email;
    private String direccion;
    private String tipoPago;

    public Cliente(LocalDate fecha,String nombre, String cedula, String email, String direccion, String tipoPago) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.direccion = direccion;
        this.tipoPago = tipoPago;
    }    

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "\nCliente:\n" + "Fecha: " + fecha + "\nNombre: " + nombre + "\nCedula: " + cedula + "\nEmail: " + email 
                + "\nDireccion: " + direccion + "\nTipo De Pago: " + tipoPago + "\n";
    }
     
}
