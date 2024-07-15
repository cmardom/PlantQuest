package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Family;
import org.iesvdm.proyecto_plantquest.domain.Questionnaire;
import org.iesvdm.proyecto_plantquest.domain.Recommendation;
import org.iesvdm.proyecto_plantquest.repository.FamilyRepository;
import org.iesvdm.proyecto_plantquest.repository.QuestionnaireRepository;
import org.iesvdm.proyecto_plantquest.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    public final RecommendationRepository  recommendationRepository;

    @Autowired
    public final FamilyRepository familyRepository;

    @Autowired
    public final QuestionnaireRepository questionnaireRepository;


    public RecommendationService(RecommendationRepository recommendationRepository, FamilyRepository familyRepository, QuestionnaireRepository questionnaireRepository) {
        this.recommendationRepository = recommendationRepository;
        this.familyRepository = familyRepository;
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<Recommendation> getRecommendations() {
        return recommendationRepository.findAll();
    }

    public Recommendation save (Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public Recommendation one (Long id) throws Exception{
        return this.recommendationRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Recommendation replace (Long id, Recommendation recommendation) throws Exception{
        return this.recommendationRepository.findById(id).map(r -> (id.equals(recommendation.getID())
        ? this.recommendationRepository.save(recommendation) : null)).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Recommendation> recommendationsResult() throws NullPointerException{
        List<Family> families = familyRepository.findAll();

        Object[] answers = questionnaireRepository.findAll().stream().map(Questionnaire::getAnswers).toArray();

        int[]answers2 = Arrays.stream(answers).mapToInt(obj -> (int)obj).toArray();

        return families.stream()
                .map(family -> new Recommendation(family, matchesCount(family, answers2)))
                .sorted((r1, r2) -> Integer.compare(r2.getMatches(), r1.getMatches())) // Ordenar por coincidencias
                .collect(Collectors.toList());
    }

    private int matchesCount(Family family, int[] answers) {
        int matches = 0;

        matches += compareProperties(family.getLightHours(), answers[0]);
        matches += compareProperties(family.getLightType(), answers[1]);
        matches += compareProperties(family.getLightOrientation(), answers[2]);
        matches += compareProperties(family.getSize(), answers[3]);
        matches += compareProperties(family.getExhibit(), answers[4]);
        matches += compareProperties(family.getHumidity(), answers[5]);
        matches += compareProperties(family.getTemperature(), answers[6]);
        matches += compareProperties(family.getToxicity(), answers[7]);
        matches += compareProperties(family.getWatering(), answers[8]);
        matches += compareProperties(family.getType(), answers[9]);

        return matches;
    }

    private int compareProperties(int[] property, int answer) {
        for (int value : property) {
            if (value == answer) {
                return 1;
            }
        }
        return 0;
    }
}
