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
public class ClienteResponse {

    private String mensaje;
    private boolean estado;

    public ClienteResponse() {
    }

    public ClienteResponse(String mensaje, boolean estado) {
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
    public boolean getEstado() {
        return estado;
    }

    /**
     * @param b the estado to set
     */
    public void setEstado(boolean b) {
        this.estado = b;
    }

}
