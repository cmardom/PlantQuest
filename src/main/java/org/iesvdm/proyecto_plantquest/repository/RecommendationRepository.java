package org.iesvdm.proyecto_plantquest.repository;

import org.iesvdm.proyecto_plantquest.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
