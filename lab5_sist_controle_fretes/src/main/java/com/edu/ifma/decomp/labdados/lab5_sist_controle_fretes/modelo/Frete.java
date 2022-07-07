package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 * muitos para um - cliente
 * muitos para um - cidade
 * um para muitos - itemfrete
 * muitos para um - categoria frete
 * muitos para um - veiculo
 */
@Entity
public class Frete implements EntidadeBase, Serializable{
    private Integer id;
    
    private BigDecimal valor;
    private int numeroNF;
    private BigDecimal valorKmRodado = BigDecimal.ZERO;
    private BigDecimal desconto = BigDecimal.ZERO;
    
    private CategoriaFrete categoria;
    private Set<ItemFrete> itens = new LinkedHashSet<>();
    private Cliente cliente;
    private Veiculo veiculo;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }     

    @Column(nullable = false)
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Column(nullable = false)
    public int getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(int numeroNF) {
        this.numeroNF = numeroNF;
    }

    @Column
    public BigDecimal getValorKmRodado() {
        return valorKmRodado;
    }

    public void setValorKmRodado(BigDecimal valorKmRodado) {
        this.valorKmRodado = valorKmRodado;
    }


    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto() {
        this.desconto = this.categoria.getDesconto();
    }
    
    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    public CategoriaFrete getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFrete categoria) {
        this.categoria = categoria;
    }
        
    
    @OneToMany(mappedBy = "idFrete", cascade = CascadeType.ALL)
    public Set<ItemFrete> getItens() {
        return itens;
    }

    public void setItens(Set<ItemFrete> itens) {
        this.itens = itens;
    }

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "veiculo", nullable = false)
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
               
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Frete f = (Frete) obj;
        return Objects.equals(id, f.id);
    }
    
    @Transient
    public BigDecimal getTotal() {
      BigDecimal total = BigDecimal.ZERO;
       for(ItemFrete item: itens) {
           total = total.add(item.getSubTotal());
       }
       return total.add(this.valorKmRodado).subtract(desconto);
    }


    public void adiciona(ItemFrete item) {
        if (aindaNaoPossuiO(item)) {
            itens.add(item);
        } else {
            item.aumentaQuantidade(item.getQuantidade() );
        }
    }

    private boolean aindaNaoPossuiO(ItemFrete item) {
        return !itens.contains(item);
    }
}
