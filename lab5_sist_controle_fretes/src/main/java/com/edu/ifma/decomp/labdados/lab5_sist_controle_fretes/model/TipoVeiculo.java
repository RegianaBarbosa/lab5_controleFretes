package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.model;

import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Regiana
 */
@Entity
public class TipoVeiculo implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private int pesoMaximo;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }  
        
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    
     @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipoVeiculo tipo = (TipoVeiculo) obj;
        return Objects.equals(id, tipo.id);
    }
}
