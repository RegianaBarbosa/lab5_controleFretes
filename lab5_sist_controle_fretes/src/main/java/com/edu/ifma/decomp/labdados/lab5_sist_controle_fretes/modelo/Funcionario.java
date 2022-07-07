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
public class Funcionario implements EntidadeBase{
    private Integer id;
    private String matricula;
    
    private PessoaFisica pessoa;
    private Filial filial;
    private Set<Dependente> dependentes = new LinkedHashSet<>();
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }  

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @OneToOne
    @JoinColumn(name = "idPessoa")
    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    @ManyToOne
    @JoinColumn(name = "filial", nullable = false)
    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    @OneToMany(mappedBy = "idFuncionario", cascade = CascadeType.ALL)
    public Set<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(Set<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Funcionario funcionario = (Funcionario) obj;
        return Objects.equals(id, funcionario.id);
    }
    
}
