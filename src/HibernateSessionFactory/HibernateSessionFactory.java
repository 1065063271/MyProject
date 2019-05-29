package HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private SessionFactory sessionFactory=null;

    public HibernateSessionFactory(){

    }

    public SessionFactory config(){
        try{
            Configuration configure= new Configuration();
            configure.configure();
            return configure.configure().buildSessionFactory();
        }catch(Exception e){
            System.out.print("HibernateSessionFactory");
            e.getMessage();
            return null;
        }
    }

    public Session getSession(){
        sessionFactory=config();
        return sessionFactory.openSession();
    }

}