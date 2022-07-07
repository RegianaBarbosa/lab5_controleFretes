package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
* um para muitos -> veiculo
* um para muitos -> Funcionario
 */
@Entity
public class Filial implements EntidadeBase{
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;
    
    private Set<Veiculo> veiculos = new LinkedHashSet<>();
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }     

    @Column(length = 45, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(length = 60, nullable = false)
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Column(length = 20, nullable = false)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Filial filial = (Filial) obj;
        return Objects.equals(id, filial.id);
    }

    

    
}
