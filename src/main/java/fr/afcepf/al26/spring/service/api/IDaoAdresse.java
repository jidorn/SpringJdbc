package fr.afcepf.al26.spring.service.api;

import fr.afcepf.al26.spring.entity.Adresse;

import java.util.List;

public interface IDaoAdresse {
    List<Adresse> getAll();
    Adresse insert(Adresse adresse);
}
