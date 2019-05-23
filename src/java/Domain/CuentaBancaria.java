/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author geile
 */
public abstract class CuentaBancaria implements IEntity {

    private int codigoCliente;
    private double saldo;
    private double cantidadRetiros;

    public CuentaBancaria() {
    }

    public CuentaBancaria(double saldo, double cantidadRetiros) {
        this.saldo = saldo;
        this.cantidadRetiros = cantidadRetiros;
    }

    public abstract String Crear();

    public abstract String Consignar(double valor, String ciudad, Date fecha);

    public abstract String Retirar(double valor, String ciudad, Date fecha);

    public abstract String Consultar();

    public abstract int getCodigo() ;

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the cantidadRetiros
     */
    public double getCantidadRetiros() {
        return cantidadRetiros;
    }

    /**
     * @return the codigoCliente
     */
    public int getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

}
