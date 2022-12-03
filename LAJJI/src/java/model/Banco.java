/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jvcor
 */

/*
create table funcionario(

    cpf varchar(14) primary key,
    nome varchar(50),
    email varchar(50) unique,
    senha varchar(20),
    rg varchar(12),
    endereco varchar(75),
    dataNascimento date,
    telefone varchar(11)
);

create table produto(
    
    codigo serial primary key,
    quantidade int check(quantidade >= 0),
    quantidadeMinima int check(quantidadeMinima >= 0),
    descricao varchar(100),
    precoUnitario decimal(10, 2),
    precoDeCompra decimal(10, 2),
    marca varchar(50),
    ultimaAtualizacao date not null defaULT CURRENT_DATE,
    cpfFuncionario varchar(50) not null references funcionario(cpf) on update cascade
);
*/

public class Banco {
    
    public static EntityManagerFactory conexao = null;
    public EntityManager sessao;
    private final String nomeArqPersistence = "LAJJIPU";// nome da unidade de persistência

    public Banco() throws Exception {
        try {
            if ((conexao == null) || (!conexao.isOpen())) {
                conexao = Persistence.createEntityManagerFactory(nomeArqPersistence);
            }
            sessao = conexao.createEntityManager();
        } catch (Exception ex) {
            throw new Exception("Erro de conexão: " + ex.getMessage());
        }
    }
}
