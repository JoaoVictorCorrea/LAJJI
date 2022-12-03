/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import model.Funcionario;
import model.Produto;

/**
 *
 * @author jvcor
 */
@WebServlet(name = "SGravarProduto", urlPatterns = {"/SGravarProduto"})
public class SGravarProduto extends HttpServlet {

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
        
        Produto objP;
        ProdutoDAO objDAO;
        Funcionario objF;
        
        DateFormat format;
        LocalDateTime now;
        
        HttpSession sessao = request.getSession(false);
        
        try{
            
            now = LocalDateTime.now();
            format = new SimpleDateFormat("yyyy-MM-dd");
            
            
            if(sessao == null ){
                sessao = request.getSession(true);
            }
            
            objF = (Funcionario)sessao.getAttribute("funcionario");
            
            objP = new Produto();
            objP.setDescricao(request.getParameter("txtDescricao"));
            objP.setMarca(request.getParameter("txtMarca"));
            objP.setPrecounitario(BigDecimal.valueOf(Double.parseDouble(request.getParameter("txtPrecoUnitario"))));
            objP.setPrecodecompra(BigDecimal.valueOf(Double.parseDouble(request.getParameter("txtPrecoCompra"))));
            objP.setQuantidade(Integer.valueOf(request.getParameter("txtQuantidade")));
            objP.setQuantidademinima(Integer.valueOf(request.getParameter("txtQuantidadeMinima")));
            objP.setUltimaatualizacao(format.parse(now.toString()));
            objP.setCpffuncionario(objF);
            
            objDAO = new ProdutoDAO();
            objDAO.gravarProduto(objP);
            
            response.sendRedirect("logged/pcadastro/cadastro.html");
            
        }
        catch(Exception ex){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Pagina de erro</title>");            
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
