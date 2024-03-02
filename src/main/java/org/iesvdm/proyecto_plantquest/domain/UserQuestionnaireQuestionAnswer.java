package org.iesvdm.proyecto_plantquest.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="userQuestionnaireQuestionAnswer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserQuestionnaireQuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private long userID;

    @ManyToOne
    @JoinColumn(name = "questionnaireID")
    private long questionnaireID;

    @ManyToOne
    @JoinColumn(name = "questionID")
    private long questionID;

    @ManyToOne
    @JoinColumn(name = "answerID")
    private long answerID;
}
