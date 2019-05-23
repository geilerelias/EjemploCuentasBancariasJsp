/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Domain.Cliente;
import Repository.RepositoryCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author geile
 */
@WebServlet(name = "ClienteService", urlPatterns = {"/ClienteService"})
public class ClienteService extends HttpServlet {

    RepositoryCliente repositoryCliente = new RepositoryCliente();

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
        int codigo = Integer.parseInt(request.getParameter("Identificacion"));
        String nombre = request.getParameter("Nombre");
        Cliente cliente = new Cliente(codigo, nombre);
        repositoryCliente.Add(cliente);
        String tableBody = "";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            for (int i = 0; i < repositoryCliente.GetAll().size()-1; i++) {
//                tableBody += "<tr>"
//                        + "<th scope='row'>" + i + "</th>"
//                        + "<td>" + codigo + "</td>"
//                        + "<td>" + nombre + "</td>"
//                        + "</tr>";
//
//            }
            tableBody += "<tr>"
                        + "<th scope='row'>" + 1 + "</th>"
                        + "<td>" + codigo + "</td>"
                        + "<td>" + nombre + "</td>"
                        + "</tr>";
            out.println(tableBody);
        }
        //repositoryCliente

    }

}
