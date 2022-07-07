package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
um para muitos ==> Frete
muitos para um ==> TipVeiculo
muitos para um ==> Filial
 */
@Entity
public class Veiculo implements EntidadeBase{
    private Integer id;
    private String numeroPlaca;
    
    private Set<Frete> fretes = new LinkedHashSet<>();
    private TipoVeiculo tipo;
    private Filial filial;

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
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    @ManyToOne
    @JoinColumn(name = "TipoVeiculo", nullable = false)
    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    @ManyToOne
    @JoinColumn(name = "filial", nullable = false)
    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }
    
    
    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
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
        Veiculo veiculo = (Veiculo) obj;
        return Objects.equals(id, veiculo.id);
    }
        
}
