package org.iesvdm.proyecto_plantquest.repository;

import org.iesvdm.proyecto_plantquest.domain.UserQuestionnaireQuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionnaireQuestionAnswerRepository extends JpaRepository<UserQuestionnaireQuestionAnswer, Long> {
}
