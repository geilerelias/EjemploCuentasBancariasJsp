/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Repository.RepositoryCuenta;
import java.util.Date;

/**
 *
 * @author geile
 */
public class CuentaAhorro extends CuentaBancaria {

    private int numeroTarjeta;
    private double saldoMaximo;
    private Date fechaVencimiento;

    public CuentaAhorro(RepositoryCuenta repositoryCuenta) {
        super(repositoryCuenta);
    }

    public CuentaAhorro(int numeroTarjeta, Date fechaVencimiento, int codigoCliente, double saldo, double cantidadRetiros, RepositoryCuenta repositoryCuenta) {
        super(codigoCliente, saldo, cantidadRetiros, repositoryCuenta);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public CuentaBancariaResponse Consignar(double valor, String ciudad, Date fecha) {

        return new CuentaBancariaResponse();
    }

    @Override
    public CuentaBancariaResponse Retirar(double valor, String ciudad, Date fecha) {
        return new CuentaBancariaResponse();
    }

    @Override
    public CuentaBancariaResponse Crear() {
        if (this.getSaldo() <= 0) {
            return  new CuentaBancariaResponse("El saldo incial debe ser mayor a cero",false);
        }
//        if (.add(this)) {
//            return "Registro Exitoso";
//        }
        return new CuentaBancariaResponse("No registrado",false);
    }

    @Override
    public CuentaBancariaResponse Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
