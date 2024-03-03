package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.Questionnaire;
import org.iesvdm.proyecto_plantquest.domain.User;
import org.iesvdm.proyecto_plantquest.service.QuestionnaireService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;


    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping({"", "/"})
    public List<Questionnaire> all(){
        log.info("Accessing Questionnaires List");
        return this.questionnaireService.all();
    }

    @PostMapping({"", "/"})
    public Questionnaire newQuestionnaire(@RequestBody Questionnaire questionnaire){
        return this.questionnaireService.save(questionnaire);
    }

    @GetMapping("/{id}")
    public Questionnaire one(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.questionnaireService.one(id);
    }

    @PutMapping("/{id}")
    public Questionnaire replaceQuestionnaire(@PathVariable("id") Long id, @RequestBody Questionnaire questionnaire) throws ChangeSetPersister.NotFoundException {
        return this.questionnaireService.replace(id, questionnaire);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteQuestionnaire(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        this.questionnaireService.delete(id);
    }
}
