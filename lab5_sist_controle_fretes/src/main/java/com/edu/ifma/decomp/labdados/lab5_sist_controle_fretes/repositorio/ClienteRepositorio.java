package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.repositorio;

import com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class ClienteRepositorio {
    private static EntityManager manager;
    private static EntityManagerFactory factory;
    private final DAOGenerico<Cliente> daoGenerico;
    
    public ClienteRepositorio(EntityManager manager) {
        ClienteRepositorio.manager = manager;
        daoGenerico = new DAOGenerico<>(ClienteRepositorio.manager);
    }
    public Cliente buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Cliente.class, id);
    }

    public List<Cliente> buscaPorNome(String nome) {
        return ClienteRepositorio.manager.createQuery("from Cliente " +
                        "where upper(nome) like :nome", Cliente.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }


    public Cliente salvaOuAtualiza(Cliente cliente) {
        return daoGenerico.salvaOuAtualiza(cliente);
    }

    public void remove(Cliente cliente) {
        daoGenerico.remove(cliente );
    }
}
