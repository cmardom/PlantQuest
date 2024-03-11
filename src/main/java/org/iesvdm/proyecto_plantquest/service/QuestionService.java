package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Question;
import org.iesvdm.proyecto_plantquest.repository.QuestionRepository;
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
public class QuestionService {
    
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> all() {return this.questionRepository.findAll();}

    public Map<String, Object> allPages( int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Question> pageAll = this.questionRepository.findAll(pageable);
        Map<String, Object> response = new HashMap<>();

        response.put("questions", pageAll.getContent());
        return response;
    }

    public Page<Question> allPagesByText(String searchParam, int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("text").ascending());
        Page<Question> pageAll = this.questionRepository.findQuestionByTextContainingIgnoreCase(searchParam,pageable);

        return pageAll;
    }

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
