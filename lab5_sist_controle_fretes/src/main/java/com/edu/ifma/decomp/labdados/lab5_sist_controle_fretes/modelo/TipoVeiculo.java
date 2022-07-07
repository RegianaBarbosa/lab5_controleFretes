package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Regiana
 */
@Entity
public class TipoVeiculo implements EntidadeBase, Serializable {
    private Integer id;  
    private String descricao;
    private int pesoMaximo;
    
    private Set<Veiculo> veiculos = new LinkedHashSet<>();

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }  
        
    @Column(nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(nullable = false)
    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    
    @OneToMany(mappedBy = "TipoVeiculo", cascade = CascadeType.ALL)
    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
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
