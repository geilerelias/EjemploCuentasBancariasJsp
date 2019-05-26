/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author geile
 */
public class CuentaBancariaResponse {

    private String mensaje;
    private boolean estado;
    private CuentaBancaria cuenta;

    public CuentaBancariaResponse() {
    }

    public CuentaBancariaResponse(String mensaje, boolean estado) {
        this.mensaje = mensaje;
        this.estado = estado;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the cuenta
     */
    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    


}
