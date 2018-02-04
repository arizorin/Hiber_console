package ru.techcenter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import ru.techcenter.rolfcenter.Autos;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
         configObj.addAnnotatedClass(Autos.class);
        configObj.configure("ru/techcenter/hibernate.cfg.xml");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }


        public void AddClient(Autos newClient) {
            try {
                sessionObj = buildSessionFactory().openSession();
                sessionObj.beginTransaction();
                System.out.println(newClient.toString());
                sessionObj.save(newClient);
                sessionObj.getTransaction().commit();
                System.out.println("INSERT SUCCESS");
            } catch (Exception e) {
                if (null != sessionObj.getTransaction()) {
                    sessionObj.getTransaction().rollback();

                }
                e.printStackTrace();
            } finally {
                if (sessionObj != null) {
                    sessionObj.close();
                }
            }
        }

        public void DeleteClient(Autos newClient) {
                try {
                    sessionObj = buildSessionFactory().openSession();
                    sessionObj.beginTransaction();
                    sessionObj.delete(newClient);
                    sessionObj.getTransaction().commit();
                    System.out.println("DELETE SUCCESS");
                } catch (Exception e) {
                    if (null != sessionObj.getTransaction()) {
                        sessionObj.getTransaction().rollback();

                    }
                    e.printStackTrace();
                } finally {
                    if (sessionObj != null) {
                        sessionObj.close();
                    }

                }
            }
                public void UpdateClient(Autos newClient){
                    try{
                        sessionObj = buildSessionFactory().openSession();
                        sessionObj.beginTransaction();
                        sessionObj.update(newClient);
                        sessionObj.getTransaction().commit();
                        System.out.println("UPDATE SUCCESS");
                    }catch(Exception e){
                        if(null != sessionObj.getTransaction()){
                            sessionObj.getTransaction().rollback();

                        }
                        e.printStackTrace();
                    }finally{
                        if(sessionObj != null) {
                            sessionObj.close();
                        }
        }
    }

                public List<Autos> ShowAll() {
                    List<Autos> clients = new ArrayList<Autos>();
                    try {
                        sessionObj = buildSessionFactory().openSession();
                        sessionObj.beginTransaction();
                        clients = sessionObj.createQuery("from Autos ").list();

                    } catch (Exception e) {
                        if (null != sessionObj.getTransaction()) {
                            sessionObj.getTransaction().rollback();

                        }
                        e.printStackTrace();
                    } finally {
                        if (sessionObj != null) {
                            sessionObj.close();
                        }
                    }
                    return clients;
                }

                public Autos FindClient(int id){
                    Autos autos = null;
                    try {
                        sessionObj = buildSessionFactory().openSession();
                        sessionObj.beginTransaction();
                        Query query = sessionObj.createQuery("from Autos where CLIENT_ID = " + id );
                        autos = (Autos) query.uniqueResult();

                    } catch (Exception e) {
                        if (null != sessionObj.getTransaction()) {
                            sessionObj.getTransaction().rollback();

                        }
                        e.printStackTrace();
                    } finally {
                        if (sessionObj != null) {
                            sessionObj.close();
                        }
                    }
                    return autos;
                }
}
