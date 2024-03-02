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
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Long userID;

    @ManyToOne
    @JoinColumn(name = "questionnaireID")
    private Long questionnaireID;

    @ManyToOne
    @JoinColumn(name = "questionID")
    private Long questionID;

    @ManyToOne
    @JoinColumn(name = "answerID")
    private Long answerID;
}
