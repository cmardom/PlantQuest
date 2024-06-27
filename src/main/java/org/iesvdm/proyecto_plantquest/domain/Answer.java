package org.iesvdm.proyecto_plantquest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<UserQuestionnaireQuestionAnswer> userQuestionnaireQuestionAnswerList;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "question", nullable = true, foreignKey = @ForeignKey(name = "id_question"))
    private Question question;

    @Column(name = "propertyValue")
    private int propertyValue;
}
