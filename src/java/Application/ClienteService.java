/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Domain.Cliente;
import Domain.ClienteResponse;
import Domain.CuentaAhorro;
import Domain.CuentaBancaria;
import Domain.CuentaBancariaResponse;
import Repository.RepositoryCliente;
import Repository.RepositoryCuenta;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author geile
 */
@WebServlet(name = "ClienteService", urlPatterns = {"/ClienteService"})
public class ClienteService extends HttpServlet {

    private RepositoryCliente repositoryCliente = new RepositoryCliente();
    private RepositoryCuenta repositoryCuenta = new RepositoryCuenta();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("Accion");
        if (null != accion) {
            switch (accion) {
                case "Registrar":
                    Registrar(response, request);
                    break;
                case "Consultar":
                    Consultar(response, request);
                    break;
                case "ObtenerTodos":
                    ObtenerTodos(response);
                    break;
                case "Editar":
                    break;
                case "Eliminar":
                    break;
                case "RegistrarCuentaBancariaAhorro":
                    RegistrarCuentaBancariaAhorro(response, request);
                    break;
                case "RegistrarCuentaBancariaCorriente":
                    RegistrarCuentaBancariaCorriente(response, request);
                    break;
                case "ConsultarCuenta":
                    ConsultarCuenta(response, request);
                    break;
                case "Consignar":
                    Consignar(response, request);
                    break;
                case "ObtenerTodasCuentas":
                    ObtenerTodasCuentas(response);
                    break;
                case "EditarCuenta":
                    break;
                case "EliminarCuenta":
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void RegistrarCuentaBancariaAhorro(HttpServletResponse response, HttpServletRequest request) throws IOException {
        try (PrintWriter out = response.getWriter()) {

            int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
            double saldo = Double.parseDouble(request.getParameter("saldo"));
            int numeroTarjeta = Integer.parseInt(request.getParameter("numeroTarjeta"));
            String fecha = request.getParameter("fechaVencimiento");
            Date fechaVencimiento = null;
            try {
                SimpleDateFormat fe = new SimpleDateFormat("yyyy-MM-dd");
                fechaVencimiento = fe.parse(fecha);
            } catch (ParseException e) {
                System.out.println("No se pudo convertir" + e.getMessage());
            }

            Gson gson = new Gson();
            CuentaBancariaResponse respuesta;
            if (null != repositoryCliente.Find(codigoCliente)) {
                CuentaBancaria cuenta = repositoryCuenta.Find(numeroTarjeta);
                if (cuenta == null) {
                    CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroTarjeta, fechaVencimiento, codigoCliente, saldo, repositoryCuenta);
                    respuesta = cuentaAhorro.Crear();
                } else {
                    respuesta = new CuentaBancariaResponse("La cuenta ya se encuentra registrada", false);
                }

            } else {
                respuesta = new CuentaBancariaResponse("El cliente no se encuentra registrado", false);
            }
            out.println(gson.toJson(respuesta));
        }
    }

    private void RegistrarCuentaBancariaCorriente(HttpServletResponse response, HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ConsultarCuenta(HttpServletResponse response, HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ObtenerTodasCuentas(HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Consultar(HttpServletResponse response, HttpServletRequest request) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            int codigo = Integer.parseInt(request.getParameter("Identificacion"));

            // out.println("Identificacion: " + codigo);
            Gson gson = new Gson();
            Cliente cliente = repositoryCliente.Find(codigo);
            cliente.setRepositoryCliente(null);
            ClienteResponse respuesta = new ClienteResponse();
            if (cliente != null) {
                respuesta.setMensaje("Consulta correcto");
                respuesta.setEstado(true);

            } else {
                respuesta.setMensaje("Cliente no registrado");
                respuesta.setEstado(false);
            }
            out.println("[" + gson.toJson(cliente) + "," + gson.toJson(respuesta) + "]");
            //          out.println("respuesta");
        }
    }

    private void ObtenerTodos(HttpServletResponse response) throws IOException {
        String tableBody = "";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int i = 0;
            for (Cliente c : repositoryCliente.GetAll()) {
                tableBody += "<tr>"
                        + "<th scope='row'>" + ++i + "</th>"
                        + "<td>" + c.getCodigo() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "</tr>";
            }
            out.println(tableBody);
        }
    }

    private void Registrar(HttpServletResponse response, HttpServletRequest request) throws NumberFormatException, IOException {
        try (PrintWriter out = response.getWriter()) {
            int codigo = Integer.parseInt(request.getParameter("Identificacion"));
            String nombre = request.getParameter("Nombre");

            Gson gson = new Gson();
            ClienteResponse respuesta;
            Cliente cliente = repositoryCliente.Find(codigo);
            if (cliente == null) {
                cliente = new Cliente(codigo, nombre, repositoryCliente);
                respuesta = cliente.Registrar();
            } else {
                respuesta = new ClienteResponse("El cliente ya se encuentra registrado", false);
            }

            out.println(gson.toJson(respuesta));
        }
    }

    private void Consignar(HttpServletResponse response, HttpServletRequest request) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
            int codigoCuenta = Integer.parseInt(request.getParameter("codigoCuenta"));
            int valor = Integer.parseInt(request.getParameter("valor"));

            Gson gson = new Gson();
            ClienteResponse respuesta ;
            Cliente cliente = repositoryCliente.Find(codigoCliente);
            CuentaBancaria cuentaBancaria = repositoryCuenta.Find(codigoCliente);

            if (cliente != null) {
                if (cuentaBancaria != null) {

                    if (cuentaBancaria.getClass() == CuentaAhorro.class) {
                        respuesta = new ClienteResponse("La cuenta es de ahorro", false);

                    }else{
                        respuesta = new ClienteResponse("algo esta mal", false);

                    }
                    // respuesta = new ClienteResponse("El cliente ya se encuentra registrado", false);
                } else {
                    respuesta = new ClienteResponse("La cuenta no se encuentra registrada", false);
                }
            } else {
                respuesta = new ClienteResponse("El cliente no se encuentra registrado", false);
            }

            out.println(gson.toJson(respuesta));
        }
    }

}
