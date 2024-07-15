package org.iesvdm.proyecto_plantquest.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="recommendation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "recommendation_family",
            joinColumns = @JoinColumn(name = "recommendation_id"),
            inverseJoinColumns = @JoinColumn(name = "family_id")
    )
    private List<Family> families;

    @Column (name = "matches")
    private int matches;


    public Recommendation(Family family, int i) {
        families.add(family);
        matches = i;
    }
}
