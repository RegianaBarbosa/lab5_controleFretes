package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.model;

import java.util.Objects;
import javax.persistence.*;

/**
 * muitos para um - cliente
 * muitos para um - cidade
 * um para muitos - itemfrete
 * muitos para um - categoria frete
 * muitos para um - veiculo
 */
public class Frete implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private int numeroNF;
    
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }     

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(int numeroNF) {
        this.numeroNF = numeroNF;
    }
    
    public void calcularFrete(){
        
    }
   
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Frete frete = (Frete) obj;
        return Objects.equals(id, frete.id);
    }
    
}
