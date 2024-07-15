package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Recommendation;
import org.iesvdm.proyecto_plantquest.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    public final RecommendationRepository  recommendationRepository;


    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
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
}
