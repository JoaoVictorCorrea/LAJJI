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
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Funcionario;
import model.Produto;


/**
 *
 * @author jvcor
 */
@WebServlet(name = "SConsultarProduto", urlPatterns = {"/SConsultarProduto"})
public class SConsultarProduto extends HttpServlet {

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
        
        List<Produto> lista;
        ProdutoDAO objDAO;
        Produto objP;
        Funcionario objF;
        
        try{
            
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            
            objDAO = new ProdutoDAO();
            lista = objDAO.listarTodosProdutos();
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<link rel='stylesheet' href='logged/assets/css/logged.css'>");
                out.println("<link rel='stylesheet' href='logged/pconsulta/consulta.css'>");
                out.println("<title>LAJJI | Consulta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='nav-side-menu'>");
                out.println("<div class='area'>");
                out.println("</div>");
                out.println("<nav class='main-menu'>");
                    out.println("<ul>");
                        out.println("<li class='main-menu-title'>");
                            out.println("<p>LAJJI</p>");
                        out.println("</li>");
                    out.println("<li>");
                        out.println("<a href='logged/logged.html'>");
                            out.println("<i class='fa fa-home fa-2x'></i>");
                            out.println("<span class='nav-text'>");
                                out.println("Dashboard");
                            out.println("</span>");
                        out.println("</a>");
                    out.println("</li>");
                    out.println("<li class='has-subnav'>");
                        out.println("<a href=\"../SConsultarProduto\">");
                            out.println("<i class='fa fa-laptop fa-2x'></i>");
                            out.println("<span class='nav-text'>");
                                out.println("Consultar");
                            out.println("</span>");
                        out.println("</a>");
                    out.println("</li>");
                    out.println("<li class='has-subnav'>");
                        out.println("<a href='logged/pcadastro/cadastro.html'>");
                            out.println("<i class='fa fa-list fa-2x'></i>");
                            out.println("<span class='nav-text'>");
                                out.println("Cadastro");
                            out.println("</span>");
                        out.println("</a>");
                    out.println("</li>");
                    out.println("<li class='has-subnav'>");
                        out.println("<a href='logged/palteracao/alteracao.html'>");
                           out.println("<i class='fa fa-folder-open fa-2x'></i>");
                            out.println("<span class='nav-text'>");
                                out.println("Alteração");
                            out.println("</span>");
                        out.println("</a>");
                    out.println("</li>");
                    out.println("<li>");
                        out.println("<a href=\"SRemocaoProduto\">");
                            out.println("<i class='fa fa-trash-o fa-2x'></i>");
                            out.println("<span class='nav-text'>");
                                out.println("Remoção");
                            out.println("</span>");
                        out.println("</a>");
                    out.println("</li>");
                out.println("</ul>");
                out.println("<ul class='logout'>");
                    out.println("<li>");
                        out.println("<a href='index.html'>");
                            out.println("<i class='fa fa-power-off fa-2x'></i>");
                            out.println("<span class='nav-text'>");
                                out.println("Logout");
                            out.println("</span>");
                        out.println("</a>");
                    out.println("</li>");  
                out.println("</ul>");
            out.println("</nav>");
            out.println("</div>");
            
            out.println("<div class='table-div'>");
                out.println("<div class='table-header'>");
                    out.println("<h1>Produtos</h1>");
                out.println("</div>");
                out.println("<div class='scroll'>");
                    out.println("<table>");
                        out.println("<thead>");
                            out.println("<tr>");
                                out.println("<th>Código</th>");
                                out.println("<th>Descrição</th>");
                                out.println("<th>Marca</th>");
                                out.println("<th>Preço Unitário</th>");
                                out.println("<th>Preço de Compra</th>");
                                out.println("<th>Quantidade</th>");
                                out.println("<th>Quantidade Mínima</th>");
                                out.println("<th>Última Atualização</th>");
                                out.println("<th>Ultima alteração feita por</th>");
                            out.println("</tr>");
                        out.println("</thead>");
                        
            for(int i = 0; i < lista.size(); i++)
            {
                objP = lista.get(i);
                objF = objP.getCpffuncionario();
                
                out.println("<tr> <td>" + objP.getCodigo() + "</td>");                
                out.println("<td>" + objP.getDescricao() + "</td>");
                out.println("<td>" + objP.getMarca() + "</td>");
                out.println("<td>" + objP.getPrecounitario() + "</td>");
                out.println("<td>" + objP.getPrecodecompra() + "</td>");
                out.println("<td>" + objP.getQuantidade() + "</td>");
                out.println("<td>" + objP.getQuantidademinima() + "</td>");
                out.println("<td>" + format.format(objP.getUltimaatualizacao()) + "</td>");
                out.println("<td> " + objF.getNome() + "</td></tr>");                
            }
            
                out.println("</table>");
            out.println("</div>");
        out.println("</div>");
        
        out.println("<script src='logged/assets/logged.js'></script>");
                    
        out.println("</body>");
        out.println("</html>");
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
