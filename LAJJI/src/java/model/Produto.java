/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jvcor
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodigo", query = "SELECT p FROM Produto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Produto.findByQuantidademinima", query = "SELECT p FROM Produto p WHERE p.quantidademinima = :quantidademinima"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByPrecounitario", query = "SELECT p FROM Produto p WHERE p.precounitario = :precounitario"),
    @NamedQuery(name = "Produto.findByPrecodecompra", query = "SELECT p FROM Produto p WHERE p.precodecompra = :precodecompra"),
    @NamedQuery(name = "Produto.findByMarca", query = "SELECT p FROM Produto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Produto.findByUltimaatualizacao", query = "SELECT p FROM Produto p WHERE p.ultimaatualizacao = :ultimaatualizacao")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "quantidademinima")
    private Integer quantidademinima;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precounitario")
    private BigDecimal precounitario;
    @Column(name = "precodecompra")
    private BigDecimal precodecompra;
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "ultimaatualizacao")
    @Temporal(TemporalType.DATE)
    private Date ultimaatualizacao;
    @JoinColumn(name = "cpffuncionario", referencedColumnName = "cpf")
    @ManyToOne(optional = false)
    private Funcionario cpffuncionario;

    public Produto() {
    }

    public Produto(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto(Integer codigo, Date ultimaatualizacao) {
        this.codigo = codigo;
        this.ultimaatualizacao = ultimaatualizacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidademinima() {
        return quantidademinima;
    }

    public void setQuantidademinima(Integer quantidademinima) {
        this.quantidademinima = quantidademinima;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }

    public BigDecimal getPrecodecompra() {
        return precodecompra;
    }

    public void setPrecodecompra(BigDecimal precodecompra) {
        this.precodecompra = precodecompra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getUltimaatualizacao() {
        return ultimaatualizacao;
    }

    public void setUltimaatualizacao(Date ultimaatualizacao) {
        this.ultimaatualizacao = ultimaatualizacao;
    }

    public Funcionario getCpffuncionario() {
        return cpffuncionario;
    }

    public void setCpffuncionario(Funcionario cpffuncionario) {
        this.cpffuncionario = cpffuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ codigo=" + codigo + " ]";
    }
    
}
