package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.repositorio;

import com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.modelo.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Regiana
 */
public class CidadeRepositorio {
    private static EntityManager manager;
    private static EntityManagerFactory factory;
    private final DAOGenerico<Cidade> daoGenerico;

    public CidadeRepositorio() {
        factory = Persistence.createEntityManagerFactory("lab05_frete");
        CidadeRepositorio.manager = factory.createEntityManager();
        daoGenerico = new DAOGenerico<>(CidadeRepositorio.manager);
    }

    public Cidade buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Cidade.class, id);
    }

    public List<Cidade> buscaPorNome(String nome) {
        return CidadeRepositorio.manager.createQuery("from Cidade " +
                        "where upper(nome) like :nome", Cidade.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<Cidade> buscaPorEstado(String estado) {
        return CidadeRepositorio.manager.createQuery("from Cidade " +
                        "where upper(estado) like :estado", Cidade.class)
                .setParameter("estado", estado.toUpperCase() + "%")
                .getResultList();
    }

    public Cidade salvaOuAtualiza(Cidade cidade) {
        return daoGenerico.salvaOuAtualiza(cidade);
    }

    public void remove(Cidade cidade) {
        daoGenerico.remove(cidade);
    }
}
