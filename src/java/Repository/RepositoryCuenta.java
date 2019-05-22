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

    private ArrayList<CuentaBancaria> arrayList;
    private static RepositoryCuenta repositoryCuenta;

    public static RepositoryCuenta getRepositoryCuenta() {
        if (repositoryCuenta == null) {
            repositoryCuenta = new RepositoryCuenta();
        }
        return repositoryCuenta;
    }

    private RepositoryCuenta() {
        arrayList = new ArrayList<>();
    }

    public boolean add(CuentaBancaria cuenta) {
        getArrayList().add(cuenta);
        return true;
    }

    public boolean actualizar(ArrayList<CuentaBancaria> arrayList) {
        this.setArrayList(arrayList);
        return true;
    }

    public ArrayList<CuentaBancaria> getAll() {
        return getArrayList();
    }

    /**
     * @return the arrayList
     */
    public ArrayList<CuentaBancaria> getArrayList() {
        return arrayList;
    }

    /**
     * @param arrayList the arrayList to set
     */
    public void setArrayList(ArrayList<CuentaBancaria> arrayList) {
        this.arrayList = arrayList;
    }

}
