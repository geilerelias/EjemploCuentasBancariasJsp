/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Domain.Cliente;
import Repository.RepositoryCliente;
import com.google.gson.Gson;
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
                default:
                    break;
            }
        }

        //repositoryCliente
    }

    private void Consultar(HttpServletResponse response, HttpServletRequest request) throws NumberFormatException, IOException {
        try (PrintWriter out = response.getWriter()) {
            int codigo = Integer.parseInt(request.getParameter("Identificacion"));
            Gson gson = new Gson();
            Cliente cliente = repositoryCliente.Find(codigo);
            ClienteResponse respuesta = new ClienteResponse();
            if (cliente != null) {
                respuesta.setMensaje("Consulta correcto");
                respuesta.setEstado(true);

            } else {
                respuesta.setMensaje("Cliente no registrado");
                respuesta.setEstado(false);
            }
            out.println("[" + gson.toJson(cliente) + "," + gson.toJson(respuesta) + "]");
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
            ClienteResponse respuesta = new ClienteResponse();
            Cliente cliente = repositoryCliente.Find(codigo);
            if (cliente == null) {
                cliente = new Cliente(codigo, nombre);
                if (repositoryCliente.Add(cliente)) {
                    respuesta.setMensaje("Registro correcto");
                    respuesta.setEstado(true);
                } else {
                    respuesta.setMensaje("Error en el registro");
                    respuesta.setEstado(false);
                }

            } else {
                respuesta.setMensaje("El cliente ya se encuentra registrado");
                respuesta.setEstado(false);
            }

            out.println(gson.toJson(respuesta));
        }
    }

}

class ClienteResponse {

    private String mensaje;
    private boolean estado;

    public ClienteResponse() {
    }

    public ClienteResponse(String mensaje, boolean estado) {
        this.mensaje = mensaje;
        this.estado = estado;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the estado
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * @param b the estado to set
     */
    public void setEstado(boolean b) {
        this.estado = b;
    }

}
