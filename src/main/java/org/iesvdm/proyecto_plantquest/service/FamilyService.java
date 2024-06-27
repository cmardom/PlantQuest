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
}
