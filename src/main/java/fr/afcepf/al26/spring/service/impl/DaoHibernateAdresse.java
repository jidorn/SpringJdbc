package fr.afcepf.al26.spring.service.impl;

import fr.afcepf.al26.spring.entity.Adresse;
import fr.afcepf.al26.spring.service.api.IDaoAdresse;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stagiaire on 12/01/2016.
 */

public class DaoHibernateAdresse implements IDaoAdresse{

    private Logger log = Logger.getLogger(DaoHibernateAdresse.class);
    private SessionFactory sessionFactory = null;
    private Transaction transaction = null;
    private Session session=null;
    @Override
    public List<Adresse> getAll() {
        List<Adresse>adresses = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            adresses = session.createCriteria(Adresse.class).list();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            log.info("erreur : "+e.getMessage());
        }
        finally {
            session.close();
        }
        return adresses;
    }

    @Override
    public Adresse insert(Adresse adresse) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(adresse);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            log.info("erreur : "+e.getMessage());
        }
        finally {
            session.close();
        }
        return adresse;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
