/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Banco;
import model.Produto;

/**
 *
 * @author jvcor
 */
public class ProdutoDAO {
    
    public void gravarProduto(Produto obj) throws Exception {
        
        Banco bb;
        
        try {
            
            bb = new Banco();
           
            bb.sessao.getTransaction().begin();
            bb.sessao.persist(obj);
            bb.sessao.getTransaction().commit();
            
        }
        catch (Exception ex) {

            throw new Exception("Erro ao gravar produto: " + ex.getMessage());
        }
    }

    public boolean alterarProduto(Object obj) throws Exception {
        
        Banco bb;
        Produto objP = (Produto)obj;
        ProdutoDAO objDAO = new ProdutoDAO();
        
        try {
            
            bb = new Banco();
            bb.sessao.getTransaction().begin();
            
            if(objDAO.getCodigoDoProduto(Produto.class, objP.getCodigo()) != null){
                
                bb.sessao.merge(obj);
                bb.sessao.getTransaction().commit();
                return true;
            }
            else{
                
                bb.sessao.getTransaction().commit();
                return false;
            }
            
        } 
        catch (Exception ex) {
            
            throw new Exception("Erro ao alterar produto: " + ex.getMessage());
        }
    }

    public boolean removerProduto(Class tipo, int codigo) throws Exception {
        
        Banco bb;
        Object obj;
        
        try {
            
            bb = new Banco();
            bb.sessao.getTransaction().begin();
            
            obj = bb.sessao.find(tipo, codigo);
            
            if(obj != null){
                
                bb.sessao.remove(obj);
                bb.sessao.getTransaction().commit();
                return true;
            }
            else{
                
                bb.sessao.getTransaction().commit();
                return false;
            }
        }
        catch (Exception ex) {
            
            throw new Exception("Erro ao remover produto: " + ex.getMessage());
        }
    }

    public Object getCodigoDoProduto(Class tipo, final int codigo) throws Exception {
        
        Banco bb;
        
        try {
            
            bb = new Banco();
            return bb.sessao.find(tipo, codigo);
            
        }
        catch (Exception ex) {
            
            throw new Exception("Erro ao getCodigoDoProduto: " + ex.getMessage());
        }
    }

    public List<Produto> listarTodosProdutos() throws Exception {
        
        Banco bb;
        
        try {
            
            bb = new Banco();
            return  bb.sessao.createQuery("SELECT p FROM Produto p ORDER BY p.codigo").getResultList();
        } 
        catch (Exception ex) {
            
            throw new Exception("Erro ao listarTodosProdutos: " + ex.getMessage());
        }
    }
}
