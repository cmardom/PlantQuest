package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.UserQuestionnaireQuestionAnswer;
import org.iesvdm.proyecto_plantquest.repository.UserQuestionnaireQuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuestionnaireQuestionAnswerService {
    
    @Autowired
    UserQuestionnaireQuestionAnswerRepository userQuestionnaireQuestionAnswerRepository;

    public List<UserQuestionnaireQuestionAnswer> all() {return this.userQuestionnaireQuestionAnswerRepository.findAll();}
    public UserQuestionnaireQuestionAnswer save(UserQuestionnaireQuestionAnswer userQuestionnaireQuestionAnswer) {return this.userQuestionnaireQuestionAnswerRepository.save(userQuestionnaireQuestionAnswer);}

    //probar excepcion: predeterminadas o propias?
    public UserQuestionnaireQuestionAnswer one(Long id) throws ChangeSetPersister.NotFoundException {
        return this.userQuestionnaireQuestionAnswerRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public UserQuestionnaireQuestionAnswer replace(Long id, UserQuestionnaireQuestionAnswer userQuestionnaireQuestionAnswer) throws ChangeSetPersister.NotFoundException {
        return this.userQuestionnaireQuestionAnswerRepository.findById(id).map(u -> (id.equals(userQuestionnaireQuestionAnswer.getID()) ?
                        this.userQuestionnaireQuestionAnswerRepository.save(userQuestionnaireQuestionAnswer) : null))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void delete(Long id) throws ChangeSetPersister.NotFoundException {
        this.userQuestionnaireQuestionAnswerRepository.findById(id).map(u -> {this.userQuestionnaireQuestionAnswerRepository.delete(u);
                    return u;})
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
