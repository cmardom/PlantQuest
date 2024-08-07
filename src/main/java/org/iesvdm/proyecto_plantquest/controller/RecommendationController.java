package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.Questionnaire;
import org.iesvdm.proyecto_plantquest.domain.Recommendation;
import org.iesvdm.proyecto_plantquest.service.QuestionnaireService;
import org.iesvdm.proyecto_plantquest.service.RecommendationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/recommendations")
public class RecommendationController {

    private RecommendationService recommendationService = null;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping({"", "/"})
    public List<Recommendation> all(){
        log.info("Accessing recommendations List");
        return this.recommendationService.getRecommendations();
    }

    @PostMapping({"", "/"})
    public Recommendation recommendation(@RequestBody Recommendation recommendation){
        return this.recommendationService.save(recommendation);
    }

    @GetMapping("/{id}")
    public Recommendation one(@PathVariable("id") Long id) throws Exception {
        return this.recommendationService.one(id);
    }

    @PutMapping("/{id}")
    public Recommendation replaceRecommendation(@PathVariable("id") Long id, @RequestBody Recommendation recommendation) throws Exception {
        return this.recommendationService.replace(id, recommendation);
    }

    @GetMapping({"", "/result"})
    public List<Recommendation> recommendationsResult() {

        return recommendationService.recommendationsResult();

    }



}
