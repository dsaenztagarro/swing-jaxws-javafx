/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.core.generic;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author davlanca
 */
public class EntityManagerProvider {
    
    private static final String DB_PU = "hidroconPU";
    
    private static EntityManagerProvider emp = new EntityManagerProvider();
    private static EntityManagerFactory emf;
    
    private EntityManagerProvider() {
    }
    
    public static EntityManagerProvider getEntityManagerProvider() {
        if (emp==null) {
            emp = new EntityManagerProvider();
        }
        return emp;
    }

    public EntityManagerFactory getEntityManagerFactory() {    
        if (emf==null) {
            createEntityManagerFactory();
        }
        return emf;
    }    
    
    protected void createEntityManagerFactory() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("hidroconPU");
    }
    
}
