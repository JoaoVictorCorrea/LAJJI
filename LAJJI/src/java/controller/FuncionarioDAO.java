/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Banco;
import model.Funcionario;

/**
 *
 * @author jvcor
 */
public class FuncionarioDAO {
    
    public void gravarFuncionario(Object obj) throws Exception {
        
        Banco bb;
        
        try {
            
            bb = new Banco();
            
            bb.sessao.getTransaction().begin();
            bb.sessao.persist(obj);
            bb.sessao.getTransaction().commit();
        }
        catch (Exception ex) {

            throw new Exception("Erro ao gravar funcionario: " + ex.getMessage());
        }
    }

    public boolean alterarFuncionario(Object obj) throws Exception {
        
        Banco bb;
        Funcionario objF = (Funcionario)obj;
        FuncionarioDAO objDAO = new FuncionarioDAO();
        
        try {
            
            bb = new Banco();
            bb.sessao.getTransaction().begin();
            
            if(objDAO.getCPFDoFuncionario(Funcionario.class, objF.getCpf()) != null){
                
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
            
            throw new Exception("Erro ao alterar funcionario: " + ex.getMessage());
        }
    }

    public boolean removerFuncionario(Class tipo, String cpf) throws Exception {
        
        Banco bb;
        Object obj;
        
        try {
            
            bb = new Banco();
            bb.sessao.getTransaction().begin();
            
            obj = bb.sessao.find(tipo, cpf);
            
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
            
            throw new Exception("Erro ao remover funcionario: " + ex.getMessage());
        }
    }

    public Object getCPFDoFuncionario(Class tipo, final String cpf) throws Exception {
        
        Banco bb;
        
        try {
            
            bb = new Banco();
            return bb.sessao.find(tipo, cpf);
            
        }
        catch (Exception ex) {
            
            throw new Exception("Erro ao getCPFDoFuncionario: " + ex.getMessage());
        }
    }

    public List<Funcionario> listarTodosFuncionarios() throws Exception {
        
        Banco bb;
        
        try {
            
            bb = new Banco();
            return  bb.sessao.createQuery("SELECT f FROM Funcionario f").getResultList();
        } 
        catch (Exception ex) {
            
            throw new Exception("Erro ao listarTodosFuncionarios: " + ex.getMessage());
        }
    }
    
    public Funcionario logarFuncionario(String email, String senha) throws Exception{
        
        Banco bb;
        Funcionario obj;
        
        try{
            
            bb = new Banco();
            
            obj = (Funcionario)bb.sessao.createQuery("SELECT f FROM Funcionario f where f.email = :email and f.senha = :senha")
                    .setParameter("email", email)
                    .setParameter("senha", senha)
                    .getSingleResult();
                
            return obj;
        } 
        catch (Exception ex) {
            
            return null;
        }
    }
}
