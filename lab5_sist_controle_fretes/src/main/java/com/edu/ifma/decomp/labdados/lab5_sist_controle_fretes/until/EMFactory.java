package com.edu.ifma.decomp.labdados.lab5_sist_controle_fretes.until;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Regiana
 */
public class EMFactory {
    private static EntityManagerFactory factory;
    
    static {
        factory = Persistence.createEntityManagerFactory("lab05_fretes");
    }
    
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
    
    public static void close(){
        factory.close();
    }
}
