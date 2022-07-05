package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.test;

import com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.model.PessoaFisica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Regiana
 */
public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab5_fretes_teste");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        try{
            PessoaFisica pessoa = new PessoaFisica();
            pessoa.setNome("Pessoa 1");
            pessoa.setEndereco("Rua 1");
            pessoa.setTelefone(11111111);
             manager.persist(pessoa);
            manager.getTransaction().commit();
            System.out.println("Funcionou!!!");
        }catch(Exception e){
            System.out.println(e);
        }
        
        manager.close();
        factory.close();
    }
}
