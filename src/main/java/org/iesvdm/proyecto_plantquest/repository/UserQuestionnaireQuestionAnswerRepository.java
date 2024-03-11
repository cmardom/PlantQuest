package org.iesvdm.proyecto_plantquest.repository;

import org.iesvdm.proyecto_plantquest.domain.Question;
import org.iesvdm.proyecto_plantquest.domain.UserQuestionnaireQuestionAnswer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionnaireQuestionAnswerRepository extends JpaRepository<UserQuestionnaireQuestionAnswer, Long> {
    public Page<UserQuestionnaireQuestionAnswer> findUserQuestionnaireQuestionAnswerByUserID(Long userID, Pageable pageable);

}
