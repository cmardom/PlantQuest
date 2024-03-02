package org.iesvdm.proyecto_plantquest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "newsletter")
    private boolean newsletter;

    @Column(name = "userRole")
    private UserRole userRole;


    @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserQuestionnaireQuestionAnswer> userQuestionnaireQuestionAnswerList;

//    @Column(name = "blogComments")
//    private ArrayList<Comment> comments;


}
