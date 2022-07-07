package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Regiana
 */
@Entity
public class Cliente implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "idPessoa")
    private PessoaFisica pessoa;
    
    private Set<Frete> fretes = new LinkedHashSet<>();
    
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }  

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    @OneToMany(mappedBy = "idCliente", cascade = CascadeType.ALL)
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
        Cliente cliente = (Cliente) obj;
        return Objects.equals(id, cliente.id);
    }
    
    
}
