package fr.afcepf.al26.spring.service.impl;

import fr.afcepf.al26.spring.entity.Adresse;
import fr.afcepf.al26.spring.service.api.IDaoAdresse;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Stagiaire on 14/01/2016.
 */
@Service
public class DaoAdresseHibernateTransactionnal implements IDaoAdresse {
    private SessionFactory sf;

    @Autowired
    public void setsf(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    @Override
    @Transactional
    public List<Adresse> getAll() {
        Query query = sf.getCurrentSession().createQuery("FROM Adresse a");
        return query.list();
    }

    @Override
    @Transactional
    public Adresse insert(Adresse adresse) {
        sf.getCurrentSession().save(adresse);
        return adresse;
    }
}
