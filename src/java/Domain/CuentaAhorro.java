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
    private double saldoMaximo = 20000;
    private Date fechaVencimiento;

    public CuentaAhorro(RepositoryCuenta repositoryCuenta) {
        super(repositoryCuenta);
    }

    public CuentaAhorro(int numeroTarjeta, Date fechaVencimiento, int codigoCliente, double saldo, RepositoryCuenta repositoryCuenta) {
        super(codigoCliente, saldo, repositoryCuenta);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public CuentaBancariaResponse Consignar(double valor, String ciudad, Date fecha) {
        if (this.getFechaVencimiento().before(new Date())) {
            return new CuentaBancariaResponse("la cuenta de ahorro caduco", false);
        }
        if (getSaldo() + valor <= saldoMaximo) {
            setSaldo(getSaldo() + valor);
            CuentaBancaria cuenta = getRepositoryCuenta().Find(this.getNumeroTarjeta());
            getRepositoryCuenta().Edit(getIndex(), cuenta);
            return new CuentaBancariaResponse("Consignacion correcta", false);
        }
        return new CuentaBancariaResponse("el valor a consignar supera el monto maximo", false);
    }

    @Override
    public CuentaBancariaResponse Retirar(double valor, String ciudad, Date fecha) {
        if (this.getFechaVencimiento().before(new Date())) {
            return new CuentaBancariaResponse("la cuenta de ahorro caduco", false);
        }
        if (getSaldo() == 0) {
            return new CuentaBancariaResponse("No hay Fondos sufiecientes", false);
        }

        if (getSaldo() - valor < 0) {
            return new CuentaBancariaResponse("No hay Fondos sufiecientes", false);
        }

        if (getCantidadRetiros() > 3) {
            setSaldo(getSaldo() - valor * 1.05);
            getRepositoryCuenta().Edit(getIndex(), this);
            return new CuentaBancariaResponse("Retiro realizado con exito, con un ocsto de $" + (valor * .05), true);
        } else {
            setSaldo(getSaldo() - valor * 1.05);
            getRepositoryCuenta().Edit(getIndex(), this);
            double cont = getCantidadRetiros();
            setCantidadRetiros(cont++);
            return new CuentaBancariaResponse("Retiro realizado con exito, operacion sin consto", true);
        }
    }

    @Override
    public CuentaBancariaResponse Crear() {
        if (this.getSaldo() <= 0) {
            return new CuentaBancariaResponse("El saldo incial debe ser mayor a cero", false);
        }
        if (this.getFechaVencimiento().compareTo(new Date())<0) {
            return new CuentaBancariaResponse("la fecha de vencimiento no es valida", false);
        }

        if (getRepositoryCuenta().Add(this)) {
            return new CuentaBancariaResponse("Registro de la tarjeta "+getNumeroTarjeta()+" con exito", true);
        }
        return new CuentaBancariaResponse("No registrado", false);
    }

    @Override
    public CuentaBancariaResponse Consultar() {
        CuentaBancariaResponse response = new CuentaBancariaResponse();
        response.setCuenta(getRepositoryCuenta().Find(this.numeroTarjeta));
        return response;
    }

    @Override
    public int getCodigo() {
        return this.getNumeroTarjeta();
    }

    @Override
    public int getIndex() {
        return getRepositoryCuenta().getIndex(this.numeroTarjeta);
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
