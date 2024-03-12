package org.iesvdm.proyecto_plantquest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="questionnaire")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long ID;

    @Column(name = "title")
    private String title;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

//    @Column(name = "questions")
//    @OneToMany
//    private List<Question> questionList;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<UserQuestionnaireQuestionAnswer> userQuestionnaireQuestionAnswerList;
}
