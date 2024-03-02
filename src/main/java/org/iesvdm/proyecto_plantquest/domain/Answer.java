package org.iesvdm.proyecto_plantquest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="answer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long ID;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "answerID", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserQuestionnaireQuestionAnswer> userQuestionnaireQuestionAnswerList;


    //Incluir respuestas que llevan a propiedades de plantas para la recomendacion:
    // humedad, robustez, riego...
}
