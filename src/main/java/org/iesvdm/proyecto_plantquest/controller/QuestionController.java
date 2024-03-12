package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.Question;
import org.iesvdm.proyecto_plantquest.domain.User;
import org.iesvdm.proyecto_plantquest.service.QuestionService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/v1/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping({"", "/"})
    public List<Question> all(){
        log.info("Accessing Questions List");
        return this.questionService.all();
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Map<String, Object>> allPages(@RequestParam(value = "page", defaultValue = "0") int page,
                                                   @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("Accessing Paged Question List");

        Map<String, Object> responseAll = this.questionService.allPages(page, size);
        return ResponseEntity.ok(responseAll);
    }

    @GetMapping(value = {"", "/"}, params = {"search-param","page", "size"})
    public Page<Question> allPagesFilterByText(@RequestParam(value = "search-param", defaultValue = "") String searchParam, @RequestParam(value = "page", defaultValue = "0") int page,
                                             @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("Accessing Paged Question List Filtered By ID");

        return this.questionService.allPagesByText(searchParam, page, size);

    }

    @PostMapping({"", "/"})
    public Question newQuestion(@RequestBody Question question){
        return this.questionService.save(question);
    }

    @GetMapping("/{id}")
    public Question one(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.questionService.one(id);
    }

    @PutMapping("/{id}")
    public Question replaceQuestion(@PathVariable("id") Long id, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        return this.questionService.replace(id, question);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        this.questionService.delete(id);
    }
}
