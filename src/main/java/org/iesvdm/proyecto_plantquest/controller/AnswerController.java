package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.Answer;
import org.iesvdm.proyecto_plantquest.domain.User;
import org.iesvdm.proyecto_plantquest.service.AnswerService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/answers")
public class AnswerController {
//prueba
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping({"", "/"})
    public List<Answer> all(){
        log.info("Accessing Answers List");
        return this.answerService.all();
    }

    @PostMapping({"", "/"})
    public Answer newAnswer(@RequestBody Answer answer){
        return this.answerService.save(answer);
    }

    @GetMapping("/{id}")
    public Answer one(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.answerService.one(id);
    }

    @PutMapping("/{id}")
    public Answer replaceAnswer(@PathVariable("id") Long id, @RequestBody Answer answer) throws ChangeSetPersister.NotFoundException {
        return this.answerService.replace(id, answer);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        this.answerService.delete(id);
    }

}
