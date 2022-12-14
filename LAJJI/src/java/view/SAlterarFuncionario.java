/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import model.Funcionario;

/**
 *
 * @author jvcor
 */
@WebServlet(name = "SAlterarFuncionario", urlPatterns = {"/SAlterarFuncionario"})
public class SAlterarFuncionario extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        Funcionario obj;
        FuncionarioDAO objDAO;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SGravar</title>");            
            out.println("</head>");
            out.println("<body>");
            
            obj = new Funcionario();
            obj.setNome(request.getParameter("txtNome"));
            obj.setCpf(request.getParameter("txtCPF"));
            obj.setSenha(request.getParameter("txtSenha"));
            obj.setRg(request.getParameter("txtRG"));
            obj.setEmail(request.getParameter("txtEmail"));
            obj.setEndereco(request.getParameter("txtEndereco"));
            obj.setDatanascimento(format.parse(request.getParameter("txtData")));
            obj.setTelefone(request.getParameter("txtTelefone"));
            
            objDAO = new FuncionarioDAO();
            
            if(objDAO.alterarFuncionario(obj))
                out.print("<h1>" + obj.getNome() + " alterado com sucesso.</h1>");
            else
                out.print("<h1>Funcionario n??o encontrado.</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception ex){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
