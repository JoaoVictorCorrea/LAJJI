package model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Funcionario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-11-21T02:19:01")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, String> marca;
    public static volatile SingularAttribute<Produto, Integer> codigo;
    public static volatile SingularAttribute<Produto, BigDecimal> precodecompra;
    public static volatile SingularAttribute<Produto, BigDecimal> precounitario;
    public static volatile SingularAttribute<Produto, Integer> quantidade;
    public static volatile SingularAttribute<Produto, Date> ultimaatualizacao;
    public static volatile SingularAttribute<Produto, Funcionario> cpffuncionario;
    public static volatile SingularAttribute<Produto, Integer> quantidademinima;
    public static volatile SingularAttribute<Produto, String> descricao;

}