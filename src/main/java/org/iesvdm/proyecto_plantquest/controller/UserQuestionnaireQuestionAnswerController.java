package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.User;
import org.iesvdm.proyecto_plantquest.domain.UserQuestionnaireQuestionAnswer;
import org.iesvdm.proyecto_plantquest.service.UserQuestionnaireQuestionAnswerService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/userQuestionnaireQuestionAnswers")
public class UserQuestionnaireQuestionAnswerController {

    private final UserQuestionnaireQuestionAnswerService userQuestionnaireQuestionAnswerService;


    public UserQuestionnaireQuestionAnswerController(UserQuestionnaireQuestionAnswerService userQuestionnaireQuestionAnswerService) {
        this.userQuestionnaireQuestionAnswerService = userQuestionnaireQuestionAnswerService;
    }

    @GetMapping({"", "/"})
    public List<UserQuestionnaireQuestionAnswer> all(){
        log.info("Accessing UserQuestionnaireQuestionAnswer List");
        return this.userQuestionnaireQuestionAnswerService.all();
    }

    @PostMapping({"", "/"})
    public UserQuestionnaireQuestionAnswer newUserQuestionnaireQuestionAnswer(@RequestBody UserQuestionnaireQuestionAnswer u){
        return this.userQuestionnaireQuestionAnswerService.save(u);
    }

    @GetMapping("/{id}")
    public UserQuestionnaireQuestionAnswer one(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.userQuestionnaireQuestionAnswerService.one(id);
    }

    @PutMapping("/{id}")
    public UserQuestionnaireQuestionAnswer replaceUserQuestionnaireQuestionAnswer(@PathVariable("id") Long id, @RequestBody UserQuestionnaireQuestionAnswer u) throws ChangeSetPersister.NotFoundException {
        return this.userQuestionnaireQuestionAnswerService.replace(id, u);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUserQuestionnaireQuestionAnswer(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        this.userQuestionnaireQuestionAnswerService.delete(id);
    }
}
