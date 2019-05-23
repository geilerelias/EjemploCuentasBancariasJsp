/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;



import Domain.CuentaBancaria;
import java.util.ArrayList;

/**
 *
 * @author geile
 */
public class RepositoryCuenta {

    ArrayList<CuentaBancaria> list;

    public RepositoryCuenta() {
        list = new ArrayList<>();
    }

    public ArrayList<CuentaBancaria> GetAll() {
        return list;
    }

    public CuentaBancaria Find(int identificacion) {
        for (CuentaBancaria cuenta : list) {
            if (identificacion == cuenta.getCodigo()) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean Add(CuentaBancaria cuenta) {
        return list.add(cuenta);
    }

    public boolean Delete(CuentaBancaria cuenta) {
        return list.remove(cuenta);
    }

    public CuentaBancaria Edit(int index, CuentaBancaria cuenta) {
        return list.set(index, cuenta);
    }

}
