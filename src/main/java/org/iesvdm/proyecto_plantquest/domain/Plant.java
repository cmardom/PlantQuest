package org.iesvdm.proyecto_plantquest.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="plant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String imagePath;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family", nullable = false)
    private Family family;

}




