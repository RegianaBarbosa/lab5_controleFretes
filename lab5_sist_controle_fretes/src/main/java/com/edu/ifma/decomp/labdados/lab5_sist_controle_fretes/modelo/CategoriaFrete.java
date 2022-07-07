package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 * um para muitos - Frete
 * 
 */

@Entity
public class CategoriaFrete implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private BigDecimal desconto;
    
    private Set<Frete> fretes = new LinkedHashSet<>();
    
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }     

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL)
    public Set<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(Set<Frete> fretes) {
        this.fretes = fretes;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CategoriaFrete categoria = (CategoriaFrete) obj;
        return Objects.equals(id, categoria.id);
    }
}
