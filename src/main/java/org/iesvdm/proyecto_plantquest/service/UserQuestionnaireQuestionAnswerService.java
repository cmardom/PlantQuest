package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Question;
import org.iesvdm.proyecto_plantquest.domain.UserQuestionnaireQuestionAnswer;
import org.iesvdm.proyecto_plantquest.repository.UserQuestionnaireQuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserQuestionnaireQuestionAnswerService {
    
    @Autowired
    UserQuestionnaireQuestionAnswerRepository userQuestionnaireQuestionAnswerRepository;

    public List<UserQuestionnaireQuestionAnswer> all() {return this.userQuestionnaireQuestionAnswerRepository.findAll();}

    public Map<String, Object> allPages(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<UserQuestionnaireQuestionAnswer> pageAll = this.userQuestionnaireQuestionAnswerRepository.findAll(pageable);
        Map<String, Object> response = new HashMap<>();

        response.put("UQQA", pageAll.getContent());
        return response;
    }

    public Page<UserQuestionnaireQuestionAnswer> allPagesByUserID(Long userID, int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("userID").ascending());
        Page<UserQuestionnaireQuestionAnswer> pageAll = this.userQuestionnaireQuestionAnswerRepository.findUserQuestionnaireQuestionAnswerByUserID(userID, pageable);

        return pageAll;
    }

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
