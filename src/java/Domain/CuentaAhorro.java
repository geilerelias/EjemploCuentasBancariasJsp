/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Repository.RepositoryCuenta;
import Repository.RepositoryCliente;
import java.util.Date;

/**
 *
 * @author geile
 */
public class CuentaAhorro extends CuentaBancaria {

    private int numeroTarjeta;
    private double saldoMaximo;
    private Date fechaVencimiento;
    public static RepositoryCuenta repositoryCuenta = RepositoryCuenta.getRepositoryCuenta();

    public CuentaAhorro() {
    }

    public CuentaAhorro(int numeroTarjeta, double saldoMaximo, Date fechaVencimiento, double saldo, double cantidadRetiros) {
        super(saldo, cantidadRetiros);
        this.numeroTarjeta = numeroTarjeta;
        this.saldoMaximo = saldoMaximo;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String Consignar(double valor, String ciudad, Date fecha) {
        
        return "mundo";
    }

    @Override
    public String Retirar(double valor, String ciudad, Date fecha) {
        return "";
    }

    @Override
    public String Crear() {
        if (this.getSaldo() <= 0) {
            return "El saldo incial debe ser mayor a cero";
        }
        if (repositoryCuenta.add(this)) {
            return "Registro Exitoso";
        }
        return "No registrado";
    }
  
    @Override
    public CuentaAhorro Consultar(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templat

    /**
     * @return the numeroTarjeta
     */
    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @return the saldoMaximo
     */
    public double getSaldoMaximo() {
        return saldoMaximo;
    }

    /**
     * @param saldoMaximo the saldoMaximo to set
     */
    public void setSaldoMaximo(double saldoMaximo) {
        this.saldoMaximo = saldoMaximo;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
