package org.iesvdm.proyecto_plantquest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name="question")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long ID;

    @Column(name = "text")
    private String text;

    @Column(name = "answers")
    private List<Answer> answerList;

    @OneToMany(mappedBy = "questionID", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserQuestionnaireQuestionAnswer> userQuestionnaireQuestionAnswerList;
}
