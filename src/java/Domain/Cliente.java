/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author geile
 */
public class Cliente {
    private int codigo;
    private String nombre;
    private ArrayList<CuentaBancaria> lista;

    public Cliente() {
    }

    public Cliente(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        lista= new ArrayList<>();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the lista
     */
    public ArrayList<CuentaBancaria> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<CuentaBancaria> lista) {
        this.lista = lista;
    }
    
    
}
