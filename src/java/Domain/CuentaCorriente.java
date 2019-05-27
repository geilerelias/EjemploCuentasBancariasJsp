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
public class CuentaCorriente extends CuentaBancaria {

    private int numeroChequera;
    private double valorMinimo;

    public CuentaCorriente(RepositoryCuenta repositoryCuenta) {
        super(repositoryCuenta);
    }

    public CuentaCorriente(int numeroChequera, double valorMinimo, int codigoCliente, double saldo, RepositoryCuenta repositoryCuenta) {
        super(codigoCliente, saldo, repositoryCuenta);
        this.numeroChequera = numeroChequera;
        this.valorMinimo = valorMinimo;
    }

    @Override
    public CuentaBancariaResponse Crear() {
        if (this.getSaldo() <= 0) {
            return new CuentaBancariaResponse("El saldo incial debe ser mayor a cero", false);
        }
        if (getRepositoryCuenta().Add(this)) {
            return new CuentaBancariaResponse("Registro realizado con exito", true);
        }
        return new CuentaBancariaResponse("No registrado", false);
    }

    @Override
    public boolean ValidarCliente(int codigoCliente) {
        return codigoCliente == getCodigoCliente();
    }

    @Override
    public CuentaBancariaResponse Consignar(double valor) {
        setSaldo(getSaldo() + valor);
        CuentaBancaria cuenta = getRepositoryCuenta().Find(this.getNumeroChequera());
        getRepositoryCuenta().Edit(getIndex(), cuenta);
        return new CuentaBancariaResponse("Consignacion correcta.<br>Su nuevo saldo es de <b>$"+getSaldo(), true);
    }

    @Override
    public CuentaBancariaResponse Retirar(double valor) {
        if (getSaldo() == valorMinimo) {
            return new CuentaBancariaResponse("No hay Fondos sufiecientes", false);
        }

        if (getSaldo() - valor * 1.10 < valorMinimo) {
            return new CuentaBancariaResponse("No hay Fondos sufiecientes<br>Tus fondos superan el valor minimo de <b>$"+valorMinimo, false);
        }

        if (getCantidadRetiros() >= 4) {
            setSaldo(getSaldo() - valor * 1.10);
            getRepositoryCuenta().Edit(getIndex(), this);
            return new CuentaBancariaResponse("Retiro realizado con exito, con un costo de<b> $" + (valor * 0.10)+"</b><br>Su nuevo saldo es de <b>$"+getSaldo() , true);
        } else {
            setSaldo(getSaldo() - valor);
            getRepositoryCuenta().Edit(getIndex(), this);
            setCantidadRetiros(getCantidadRetiros()+1);
            return new CuentaBancariaResponse("Retiro realizado con exito, operacion sin consto<br>Su nuevo saldo es de <b>$"+getSaldo(), true);
        }
    }

    @Override
    public CuentaBancariaResponse Consultar() {
        CuentaBancariaResponse response = new CuentaBancariaResponse();
        response.setCuenta(getRepositoryCuenta().Find(getNumeroChequera()));
        return response;
    }

    @Override
    public int getCodigo() {
        return getNumeroChequera();
    }

    @Override
    public int getIndex() {
        return getRepositoryCuenta().getIndex(getNumeroChequera());
    }

    /**
     * @return the numeroChequera
     */
    public int getNumeroChequera() {
        return numeroChequera;
    }

    /**
     * @param numeroChequera the numeroChequera to set
     */
    public void setNumeroChequera(int numeroChequera) {
        this.numeroChequera = numeroChequera;
    }

    /**
     * @return the valorMinimo
     */
    public double getValorMinimo() {
        return valorMinimo;
    }

    /**
     * @param valorMinimo the valorMinimo to set
     */
    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }
}
