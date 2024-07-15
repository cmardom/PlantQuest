package org.iesvdm.proyecto_plantquest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long ID;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "newsletter")
    private boolean newsletter;

    @Column(name = "userRole")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Recommendation> recommendations;



}
