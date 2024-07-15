package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.Family;
import org.iesvdm.proyecto_plantquest.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public List<Family> getAllFamilies(){return familyRepository.findAll();}

    public Map<String, Object> allPages(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<Family> families = familyRepository.findAll(pageable);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("families", families.getContent());
        return map;
    }

    public Page<Family> getAllFamiliesByDescriptionContainingIgnoreCase(String text, int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<Family> pageAll = this.familyRepository.findFamiliesByDescriptionContainingIgnoreCase(text, pageable);
        return pageAll;
    }

    public Family saveFamily(Family family){return this.familyRepository.save(family);}

    public Family one (Long id) throws ChangeSetPersister.NotFoundException {
        return this.familyRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Family replace (Long id, Family newFamily) throws ChangeSetPersister.NotFoundException{
        return this.familyRepository.findById(id).map(p-> (id.equals(newFamily.getID()) ?
                        this.familyRepository.save(newFamily) : null))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void delete(Long id) throws ChangeSetPersister.NotFoundException {
        this.familyRepository.findById(id).map(p-> {this.familyRepository.delete(p);
            return p;}).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

//    public List<Family> getIdealFamily (int[] answers){
//
//        List<Family> families = familyRepository.findAll();
//        int bestMatch = 0;
//
//
//        for(Family family : families){
//            int matches = matchesCount(family, answers);
//            if(matches > bestMatch){
//                bestMatch = matches;
//
//            }
//
//        }
//        return family;
//
//    }

    private int matchesCount(Family family, int[] answers){
        int matches = 0;

        matches += compareProperties(family.getLightHours(), answers[0]);
        matches += compareProperties(family.getLightType(), answers[1]);
        matches += compareProperties(family.getLightOrientation(), answers[2]);
        matches += compareProperties(family.getSize(), answers[3]);
        matches += compareProperties(family.getExhibit(), answers[4]);
        matches += compareProperties(family.getHumidity(), answers[5]);
        matches += compareProperties(family.getTemperature(), answers[6]);
        matches += compareProperties(family.getToxicity(), answers[7]);
        matches += compareProperties(family.getWatering(), answers[8]);
        matches += compareProperties(family.getType(), answers[9]);

        return matches;


    }

    private int compareProperties(int[] property, int answer){
        for (int value : property){
            if (value == answer){
                return 1;
            }
        }
        return 0;
    }
}
