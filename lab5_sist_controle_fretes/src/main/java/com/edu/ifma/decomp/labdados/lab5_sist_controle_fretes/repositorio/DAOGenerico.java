package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.repositorio;
import com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.model.EntidadeBase;
import javax.persistence.EntityManager;
import java.util.Objects;

/**
 * @author Regiana
 */

class DAOGenerico <T extends EntidadeBase> {

    private final EntityManager manager;

    DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }

    T salvaOuAtualiza(T t) {
        if( Objects.isNull(t.getId()) )
             this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }
    
}
