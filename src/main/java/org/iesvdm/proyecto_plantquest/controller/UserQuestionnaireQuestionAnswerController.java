package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.Question;
import org.iesvdm.proyecto_plantquest.domain.User;
import org.iesvdm.proyecto_plantquest.domain.UserQuestionnaireQuestionAnswer;
import org.iesvdm.proyecto_plantquest.service.UserQuestionnaireQuestionAnswerService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/userQuestionnaireQuestionAnswers")
public class UserQuestionnaireQuestionAnswerController {

    private final UserQuestionnaireQuestionAnswerService userQuestionnaireQuestionAnswerService;


    public UserQuestionnaireQuestionAnswerController(UserQuestionnaireQuestionAnswerService userQuestionnaireQuestionAnswerService) {
        this.userQuestionnaireQuestionAnswerService = userQuestionnaireQuestionAnswerService;
    }

    @GetMapping({"", "/"})
    public List<UserQuestionnaireQuestionAnswer> all(){
        log.info("Accessing UQQA List");
        return this.userQuestionnaireQuestionAnswerService.all();
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Map<String, Object>> allPages(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("Accessing Paged UQQA List");

        Map<String, Object> responseAll = this.userQuestionnaireQuestionAnswerService.allPages(page, size);
        return ResponseEntity.ok(responseAll);
    }

    @GetMapping(value = {"", "/"}, params = {"user-id","page", "size"})
    public Page<UserQuestionnaireQuestionAnswer> allPagesByUserID(@RequestParam(value = "user-id", defaultValue = "0") Long userID,
                                                                                          @RequestParam(value = "page", defaultValue = "0") int page,
                                                                                          @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("Accessing Paged UQQA Distinct List Filtered By Question Text");

        return this.userQuestionnaireQuestionAnswerService.allPagesByUserID(userID, page, size);

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
