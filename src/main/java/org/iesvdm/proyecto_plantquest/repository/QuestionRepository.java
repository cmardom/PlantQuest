package org.iesvdm.proyecto_plantquest.repository;

import org.iesvdm.proyecto_plantquest.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
