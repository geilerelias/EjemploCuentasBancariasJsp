/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author geile
 */
public class NewClass {

    public static void main(String[] args) {
        Date fechaVencimiento = null;
        String fecha = "2019-03-04";
        try {
            SimpleDateFormat fe = new SimpleDateFormat("yyyy-MM-dd");

            fechaVencimiento = fe.parse(fecha);
        } catch (ParseException e) {
            System.out.println("No se pudo convertir" + e.getMessage());
        }
        System.out.println("feccha"+fechaVencimiento);
        
        
        fecha= new SimpleDateFormat("yyyy-MM-dd").format(fechaVencimiento);
        System.out.println("fecha normal "+fecha);
    }
}
