package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.model;

import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Regiana
 */
public class PessoaFisica implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false)
    private String nome;
    @Column(length = 60, nullable = false)
    private String endereco;
    @Column(length = 20, nullable = false)
    private int telefone;
        
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PessoaFisica pessoa = (PessoaFisica) obj;
        return Objects.equals(id, pessoa.id);
    }
    
    
}
