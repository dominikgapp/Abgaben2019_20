package tirol_htl_anichstrasse.jpa_test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// import org.postgresql.jdbc2.optional.ConnectionPool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Person p = new Person(); 
       p.setAge(18);
       p.setFirst_name("Dominik");
       p.setLast_name("Gapp");
        EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager(); 
       // manager.getTransaction().begin();; 
       // manager.persist(p); 
       // manager.getTransaction().commit();
        
        
        
        //read person 
       // Person p = manager.find(Person.class, 1L); 
       // System.out.println(p);
        
        
        //update person
       // p.setFirst_name("Ingeborg");
       // manager.getTransaction().begin();
       // manager.getTransaction().commit();
        
        
        //delete person 
       // manager.getTransaction().begin();
       // manager.remove(p);
       // manager.getTransaction().commit();
        
        
        Hobby h = new Hobby("schwimmen", 8, 0); 
        
        manager.getTransaction().begin();
        manager.persist(h);
        manager.getTransaction().commit();
        
        
        p.setHobby(h);
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        
        
        
        
    }
    
    
    
    
}
