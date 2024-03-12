package org.iesvdm.proyecto_plantquest.repository;

import org.iesvdm.proyecto_plantquest.domain.UserQuestionnaireQuestionAnswer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionnaireQuestionAnswerRepository extends JpaRepository<UserQuestionnaireQuestionAnswer, Long> {
    //public Page<UserQuestionnaireQuestionAnswer> findUserQuestionnaireQuestionAnswersByUserID(Long userID, Pageable pageable);
    //necesita User

//    public Page<UserQuestionnaireQuestionAnswer> findDistinctByQuestionContainsIgnoreCase(String text, Pageable pageable);
    Page<UserQuestionnaireQuestionAnswer> findUserQuestionnaireQuestionAnswersByUser_ID(Long userID, Pageable pageable);

}

//No devuelve content
//No funciona la query > devuelve todos los uqqa, ya sea por texto de pregunta o por id de usuario
//No puedo cambiar la ruta a /v1/api aunque este en application properties
