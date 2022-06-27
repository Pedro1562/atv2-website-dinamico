package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@WebServlet(urlPatterns = {"/login"})
public class loginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
      HttpSession session = req.getSession(true);
       // 2 - Verificamos se o usuário existe.
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       // 3 - Verificamos se reconhecemos o usuário.
       // Poderia ser um banco de dados, serviço externo, etc...
       if (username.equals("admin") && password.equals("admin")) {
           // 4 - Salvamos o login
           Usuario usuario = new Usuario(username, password);
           session.setAttribute("usuario", usuario);
           RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
           rd.forward(req,resp);
       } else {
           req.setAttribute("erro", "Usuário ou senha desconhecido.");
           RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
           rd.forward(req,resp);
       }
   }
}
