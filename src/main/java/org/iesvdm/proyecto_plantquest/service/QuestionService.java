package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Question;
import org.iesvdm.proyecto_plantquest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> all() {return this.questionRepository.findAll();}
    public Question save(Question question) {return this.questionRepository.save(question);}

    //probar excepcion: predeterminadas o propias?
    public Question one(Long id) throws ChangeSetPersister.NotFoundException {
        return this.questionRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Question replace(Long id, Question question) throws ChangeSetPersister.NotFoundException {
        return this.questionRepository.findById(id).map(q -> (id.equals(question.getID()) ?
                        this.questionRepository.save(question) : null))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void delete(Long id) throws ChangeSetPersister.NotFoundException {
        this.questionRepository.findById(id).map(q -> {this.questionRepository.delete(q);
                    return q;})
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
