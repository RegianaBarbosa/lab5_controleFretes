package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * muitos para um - Frete
 */
@Entity
public class ItemFrete implements EntidadeBase{
    private Integer id;
    private String descricao;
    private int peso;
    private BigDecimal valor;
    private Integer quantidade = 1;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }     

    @Column (nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
     
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemFrete item = (ItemFrete) obj;
        return Objects.equals(id, item.id);
    }
    
    public void aumentaQuantidade(Integer qtd) {
        this.quantidade = this.quantidade + qtd;
    }
    
    @Transient
    public BigDecimal getSubTotal() {
        return valor.multiply(new BigDecimal(quantidade));
    }
}
