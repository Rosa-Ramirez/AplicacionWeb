/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Clases.ClienteArray;
import Clases.ClientModell;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;


@WebServlet(urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {
    ClientModell client;
    ClienteArray registerClient;
    ClientModell[] registredClient;
//    ClientModell cliente;
//public List<ClientModell> clienteModell =  new ArrayList<ClientModell>();;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
                   if(request.getMethod().equals("POST") && request.getParameter("code")!= null ) {
                            client = new ClientModell(
                                    request.getParameter("code"),
                                    request.getParameter("name"),
                                    request.getParameter("address"),
                                    request.getParameter("email"),
                                    request.getParameter("phone")
                            );
                            
                            if(registerClient == null){
                                registerClient = new ClienteArray();
                            }

                            if(!request.getParameter("code").equals("")){
                                registerClient.saveClient(client);
                            }
                    }
                   
                   if(request.getParameter("position") != null){
                            String position = request.getParameter("position");
                            registerClient.deleteClient(position);
                   }
                   
                    registredClient = registerClient.getClient();

                     out.println("<!DOCTYPE html>");
                     out.println("<html><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n" +
                     "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>"
                     +"<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>"
                     +"<script src='js/script.js'></script>"
                     );
                     
                     out.println("<head>");
                     out.println("<title>Servlet ClienteController</title>");
                     out.println("</head>");
                     out.println("<body id=\"Table\">");
                     out.println("<div class=\"container\">");
                     out.println("<br><nav class=\"navbar navbar-light bg-light\">\n" +
                                 "            <form class=\"form-inline\">\n" +
                                 "                <br><a href=\"index.html\" class=\"btn btn-success\" >Volver a la página principal</a>\n" +
                                 "            </form>\n" +
                                 "            </nav><br>");

                     out.println(
                             "<table class=\"table\">\n" +
                             "  <thead class=\"thead-dark\">\n" +
                             "    <tr>\n" +
                             "      <th scope=\"col\">Código</th>\n" +
                             "      <th scope=\"col\">Nombre</th>\n" +
                             "      <th scope=\"col\">Dirección</th>\n" +
                             "      <th scope=\"col\">Correo</th>\n" +
                             "      <th scope=\"col\">Teléfono</th>\n" +
                             "    </tr>\n" +
                             "  </thead>\n" +
                             "  <tbody >\n"
                         );
                     for (int i = 0; i < registredClient.length; i ++){
                         if(registredClient[i] !=null){
                             out.println("<tr><td id=\"uno\">" + registredClient[i].getCode()+  "</td>");
                             out.println("<td id=\"dos\">" + registredClient[i].getName()+  "</td>");
                             out.println("<td id=\"tres\">" + registredClient[i].getAddress()+   "</td>");
                             out.println("<td id=\"cuatro\">" + registredClient[i].getEmail()+ "</td>");
                             out.println("<td id=\"cinco\">" + registredClient[i].getPhone()+ "</td>");
                             out.println("<td>"
                                        + "<button type=\"button\" class=\"btn btn-warning\" id=\"delete\"></i>Editar</button> "
                                        + "<button type=\"button\" class=\"btn btn-danger\" onclick='deleteData("+ i +");'>Eliminar</button>"
                                        + "</td></tr>");
                         }
                     }
                     out.println("</tbody></table>");
                     out.println("</div>");
                     out.println("<div class='container-lg d-flex'> <a href='index.html' class=\"btn btn-success ml-auto\">Registrar Nuevo Cliente</a></div><br>");
                     out.println("</form>");
                     out.println("</body>");
                     out.println("</html>");


         //            if(
         //                request.getParameter("code") == null    ||
         //                request.getParameter("name") == null    ||
         //                request.getParameter("address") == null ||
         //                request.getParameter("email") == null   ||
         //                request.getParameter("phone") == null
         //                       
         //                    ) {

         //            } else {

         //                String clienteCode = request.getParameter("code");
         //                String clienteName = request.getParameter("name");
         //                String clienteAddress = request.getParameter("address");
         //                String clienteEmail = request.getParameter("email");
         //                String clientePhone = request.getParameter("phone");
         //                this.clienteModell.add(new ClientModell(
         //                        clienteCode,
         //                        clienteName,
         //                        clienteAddress,
         //                        clienteEmail,
         //                        clientePhone
         //                ));
         //                out.println("<script>Swal.fire({\n" +
         //                                "  position: 'top-end',\n" +
         //                                "  icon: 'success',\n" +
         //                                "  title: '¡Cliente " + clienteCode + " registrado!',\n" +
         //                                "  showConfirmButton: false,\n" +
         //                                "  timer: 1900\n" +
         //                                "})</script>" + 
         //                        "<div class=\"alert alert-success\" role=\"alert\">Cliente " + clienteCode + " registrado!</div>");
         //            }


         //            if (!this.clienteModell.isEmpty()){
         //                out.println(
         //                    "<table class=\"table\">\n" +
         //                    "  <thead class=\"thead-dark\">\n" +
         //                    "    <tr>\n" +
         //                    "      <th scope=\"col\">Código</th>\n" +
         //                    "      <th scope=\"col\">Nombre</th>\n" +
         //                    "      <th scope=\"col\">Dirección</th>\n" +
         //                    "      <th scope=\"col\">Correo</th>\n" +
         //                    "      <th scope=\"col\">Teléfono</th>\n" +
         //                    "    </tr>\n" +
         //                    "  </thead>\n" +
         //                    "  <tbody id=\"Table\">\n"
         //                );
         //            } else {
         //                out.println("<a class=\"btn btn-danger\">Sin Registros</a>");
         //            }

         //            for (int i = 0; i < this.clienteModell.size(); i++){
         //                cliente = this.clienteModell.get(i);    
         //                out.println(                 
         //                    "    <tr>\n" +
         //                    "      <th scope=\"row\">" + cliente.code + "</th>\n" +
         //                    "      <td>" + cliente.name + "</td>\n" +
         //                    "      <td>" + cliente.address + "</td>\n" +
         //                    "      <td>" + cliente.email + "</td>\n" +
         //                    "      <td>" + cliente.phone + "</td>\n" +
         //                    "      <td>" +
         //                    "           <button type=\"button\" class=\"btn btn-warning\" id=\"delete\" onclick=\"deleteData();\"></i>Editar</button> " +
         //                    "           <button type=\"button\" class=\"btn btn-danger\">Delete</button>" +
         //                    "      </td>\n" +
         //                    "      </tr>\n"
         //                );
         //            }


         //            if (!this.clienteModell.isEmpty()){
         //                out.println(                    
         //                    "  </tbody>\n" +
         //                    "</table>\n" +
         //                    "\n"
         //                );
         //            }

         //            out.println("</div>");

        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
        
    }
    
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        System.out.println("en dodelete");
//        System.out.println("postion=" + req.getParameter("position"));
//        processRequest(req, resp);
//        
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
