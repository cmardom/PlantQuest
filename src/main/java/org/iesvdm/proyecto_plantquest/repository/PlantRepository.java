package org.iesvdm.proyecto_plantquest.repository;

import org.iesvdm.proyecto_plantquest.domain.Plant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository  extends JpaRepository<Plant, Long> {
    public Page<Plant> findPlantByDescriptionContainingIgnoreCase(String text, Pageable pageable);
}
