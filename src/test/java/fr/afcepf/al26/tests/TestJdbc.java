package fr.afcepf.al26.tests;

import fr.afcepf.al26.spring.entity.Adresse;
import fr.afcepf.al26.spring.service.api.IDaoAdresse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Stagiaire on 12/01/2016.
 */
public class TestJdbc {

    private static Logger log = Logger.getLogger(TestJdbc.class);
    public static void main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IDaoAdresse dao = beanFactory.getBean(IDaoAdresse.class);
        List<Adresse> adresses = dao.getAll();
        for (Adresse adresse:adresses){
            log.info(adresse.toString());
        }
        /*
        Adresse adresse = new Adresse(null,"num","rue","ville","cp","pays");
        dao.insert(adresse);
        List<Adresse> adresses1 = dao.getAll();
        for (Adresse adresse1 : adresses1){
            log.info(adresse1.toString());
        }
        */
    }
}
