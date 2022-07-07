/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Regiana
 */
public class TesteClasses {
    public static void main(String[] args) {
        EntityManagerFactory factory =
        Persistence.createEntityManagerFactory ("lab5_fretes") ;
        EntityManager manager = factory.createEntityManager() ;
        
        manager . getTransaction ().begin () ;
        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setNome("One");
        pessoa.setEndereco("Rua 1, bairro 1");
        //Cliente cliente = new Cliente() ;
        //cliente.setPessoa(pessoa);
        
        manager.persist (pessoa) ;
        
        manager.getTransaction().commit() ;
        
        manager.close() ;
        factory.close() ;
    }
}
