package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Regiana
 */

@Entity
public class Dependente implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false)
    private String nome;
    @Column(nullable = false)
    private Date dataNascimento;
    
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
       
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dependente dependente = (Dependente) obj;
        return Objects.equals(id, dependente.id);
    }
    
}
