/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Repository.RepositoryCuenta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author geile
 */
public abstract class CuentaBancaria implements IEntity {

    private int codigoCliente;
    private double saldo;
    private double cantidadRetiros;
    private RepositoryCuenta repositoryCuenta;

    public CuentaBancaria(RepositoryCuenta repositoryCuenta) {
        this.repositoryCuenta = repositoryCuenta;
    }

    public CuentaBancaria(int codigoCliente, double saldo, double cantidadRetiros, RepositoryCuenta repositoryCuenta) {
        this.codigoCliente = codigoCliente;
        this.saldo = saldo;
        this.cantidadRetiros = cantidadRetiros;
        this.repositoryCuenta = repositoryCuenta;
    }

    public CuentaBancaria(double saldo, double cantidadRetiros) {
        this.saldo = saldo;
        this.cantidadRetiros = cantidadRetiros;
    }

    public abstract CuentaBancariaResponse Crear();

    public abstract CuentaBancariaResponse Consignar(double valor, String ciudad, Date fecha);

    public abstract CuentaBancariaResponse Retirar(double valor, String ciudad, Date fecha);

    public abstract CuentaBancariaResponse Consultar();

    public abstract int getIndex();

    public abstract int getCodigo();

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

    public void setCantidadRetiros(double cantidadRetiros) {
        this.cantidadRetiros = cantidadRetiros;
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

    /**
     * @return the repositoryCuenta
     */
    public RepositoryCuenta getRepositoryCuenta() {
        return repositoryCuenta;
    }

    /**
     * @param repositoryCuenta the repositoryCuenta to set
     */
    public void setRepositoryCuenta(RepositoryCuenta repositoryCuenta) {
        this.repositoryCuenta = repositoryCuenta;
    }

}
