package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.Family;
import org.iesvdm.proyecto_plantquest.domain.Plant;
import org.iesvdm.proyecto_plantquest.service.FamilyService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/v1/api/families")
public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping({"", "/"})
    public List<Family> allFamilies() {
        log.info("All families called");
        return familyService.getAllFamilies();
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Map<String, Object>> allPages(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("All paged families called");
        Map<String, Object> result = this.familyService.allPages(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"", "/"}, params = {"text", "page", "size"})
    public Page<Family> allPlantsByDescription(@RequestParam(value = "text", defaultValue = "") String text,
                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("All paged families filtered by name called");
        return this.familyService.getAllFamiliesByDescriptionContainingIgnoreCase(text, page, size);
    }

    @PostMapping({"", "/"})
    public Family newFamily(@RequestBody Family family){
        return familyService.saveFamily(family);
    }

    @GetMapping("/{id}")
    public Family getFamily(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.familyService.one(id);
    }

    @PutMapping("/{id}")
    public Family replaceFamily(@PathVariable("id") Long id, @RequestBody Family family) throws ChangeSetPersister.NotFoundException {
        return this.familyService.replace(id, family);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteFamily(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException{
        this.familyService.delete(id);
    }
}
