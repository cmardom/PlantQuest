package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Answer;
import org.iesvdm.proyecto_plantquest.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    
    @Autowired
    public final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> all() {return this.answerRepository.findAll();}
    public Answer save(Answer answer) {return this.answerRepository.save(answer);}

    //probar excepcion: predeterminadas o propias?
    public Answer one(Long id) throws ChangeSetPersister.NotFoundException {
        return this.answerRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Answer replace(Long id, Answer answer) throws ChangeSetPersister.NotFoundException {
        return this.answerRepository.findById(id).map(a -> (id.equals(answer.getID()) ?
                        this.answerRepository.save(answer) : null))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void delete(Long id) throws ChangeSetPersister.NotFoundException {
        this.answerRepository.findById(id).map(a -> {this.answerRepository.delete(a);
                    return a;})
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
