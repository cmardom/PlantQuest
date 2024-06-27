package org.iesvdm.proyecto_plantquest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="family")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @EqualsAndHashCode.Include
    private Long ID;

    @Column
    private String imagePath;

    @Column
    private String colloquialName;

    @Column
    private String scientificName;

    @Column
    private String description;

    @Column
    private int[] lightHours;

    @Column
    private int[] lightType;

    @Column
    private int[] lightOrientation;

    @Column
    private int[] size;

    @Column
    private int[] exhibit;

    @Column
    private int[] humidity;

    @Column
    private int[] temperature;

    @Column
    private int[] toxicity;

    @Column
    private int[] watering;

    @Column
    private int[] type;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Plant> plants;



}

