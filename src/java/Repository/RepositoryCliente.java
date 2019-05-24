/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Domain.Cliente;
import java.util.ArrayList;

/**
 *
 * @author geile
 */
public class RepositoryCliente{

    ArrayList<Cliente> list;

    public RepositoryCliente() {
        list = new ArrayList<>();
    }

    public ArrayList<Cliente> GetAll() {
        return list;
    }

    public Cliente Find(int identificacion) {
        for (Cliente cliente : list) {
            if (identificacion == cliente.getCodigo()) {
                return cliente;
            }
        }
        return null;
    }

    public boolean Add(Cliente cliente) {
        return list.add(cliente);
    }

    public boolean Delete(Cliente cliente) {
        return list.remove(cliente);
    }

    public Cliente Edit(int index, Cliente cliente) {
        return list.set(index, cliente);
    }
}
