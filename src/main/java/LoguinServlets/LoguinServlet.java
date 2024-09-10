/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package LoguinServlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*Servlet para la conexion con el formulario de inicio de sesion, */
@WebServlet(name = "LoguinServlet", urlPatterns = {"/LoguinServlet"})
public class LoguinServlet extends HttpServlet {
/*variables para definir los valores validos para permitir el acceso en el formulario:*/
    protected String validName="usuario";
    protected String validPassword="usu123";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }

   /*metodo get que se comunica con la pagina HTML del formulario.*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("index.html");
    }

    /*metodo post que establece parametros y envia sentecias al formulario HTML*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");
        
       
            if(validName.equals(nombre) &&  validPassword.equals(contrasena)){
            request.getRequestDispatcher("accedido.html").forward(request, response);
            
            
            }else{
            request.setAttribute("error", "error en el inicio de sesion, intentelo nuevamente,");
            request.setAttribute("errorExist", true);
            
            request.getRequestDispatcher("noAccedido.html").forward(request, response);
            }
           

    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
