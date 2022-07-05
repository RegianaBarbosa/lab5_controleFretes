package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.model;

import java.util.Objects;
import javax.persistence.*;

/**
um para muitos ==> Frete
muitos para um ==> TipVeiculo
muitos para um ==> Filial
 */
@Entity
public class Veiculo implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String numeroPlaca;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
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
