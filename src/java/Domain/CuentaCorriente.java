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

    int numeroChequera;
    double valorMinimo;

    public CuentaCorriente(RepositoryCuenta repositoryCuenta) {
        super(repositoryCuenta);
    }

    public CuentaCorriente(int numeroChequera, double valorMinimo, int codigoCliente, double saldo, double cantidadRetiros, RepositoryCuenta repositoryCuenta) {
        super(codigoCliente, saldo, cantidadRetiros, repositoryCuenta);
        this.numeroChequera = numeroChequera;
        this.valorMinimo = valorMinimo;
    }

    @Override
    public CuentaBancariaResponse Crear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CuentaBancariaResponse Consignar(double valor, String ciudad, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CuentaBancariaResponse Retirar(double valor, String ciudad, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CuentaBancariaResponse Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
