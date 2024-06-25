package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Plant;
import org.iesvdm.proyecto_plantquest.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public List<Plant> getAllPlants() {return  this.plantRepository.findAll();}

    public Map<String, Object> allPages(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Plant> pages = this.plantRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("pages", pages.getContent());
        return map;
    }
//findPlantByDescriptionContainingIgnoreCase
    public Page<Plant> getAllPlantsByDescriptionContainingIgnoreCase(String text, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("text").ascending());
        Page<Plant> pageAll = this.plantRepository.findPlantByDescriptionContainingIgnoreCase(text, pageable);
        return pageAll;
    }

    public Plant savePlant(Plant plant) {return this.plantRepository.save(plant);}

    public Plant one (Long id) throws ChangeSetPersister.NotFoundException {
        return this.plantRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Plant replace (Long id, Plant newPlant) throws ChangeSetPersister.NotFoundException {
        return this.plantRepository.findById(id).map(p -> (id.equals(newPlant.getID()) ?
                this.plantRepository.save(newPlant) : null)).orElseThrow(ChangeSetPersister.NotFoundException::new);

    }

    public void delete(Long id) throws ChangeSetPersister.NotFoundException {
        this.plantRepository.findById(id).map(p-> {this.plantRepository.delete(p);
        return p;}).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
