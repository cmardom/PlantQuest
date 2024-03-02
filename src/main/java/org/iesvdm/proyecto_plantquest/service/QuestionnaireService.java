package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Questionnaire;
import org.iesvdm.proyecto_plantquest.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    
    @Autowired
    QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> all() {return this.questionnaireRepository.findAll();}
    public Questionnaire save(Questionnaire questionnaire) {return this.questionnaireRepository.save(questionnaire);}

    //probar excepcion: predeterminadas o propias?
    public Questionnaire one(Long id) throws ChangeSetPersister.NotFoundException {
        return this.questionnaireRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Questionnaire replace(Long id, Questionnaire questionnaire) throws ChangeSetPersister.NotFoundException {
        return this.questionnaireRepository.findById(id).map(q -> (id.equals(questionnaire.getID()) ?
                        this.questionnaireRepository.save(questionnaire) : null))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void delete(Long id) throws ChangeSetPersister.NotFoundException {
        this.questionnaireRepository.findById(id).map(q -> {this.questionnaireRepository.delete(q);
                    return q;})
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
    
}
