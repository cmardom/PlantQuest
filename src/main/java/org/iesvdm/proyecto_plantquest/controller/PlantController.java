package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.Plant;
import org.iesvdm.proyecto_plantquest.service.PlantService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/v1/api/plants")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping({"", "/"})
    public List<Plant> allPlants() {
        log.info("All plants called");
        return plantService.getAllPlants();
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Map<String, Object>> allPages(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("All paged plants called");
        Map<String, Object> result = this.plantService.allPages(page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"", "/"}, params = {"text", "page", "size"})
    public Page<Plant> allPlantsByDescription(@RequestParam(value = "text", defaultValue = "") String text,
                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                       @RequestParam(value = "size", defaultValue = "0") int size){
        log.info("All paged plants filtered by name called");
        return this.plantService.getAllPlantsByDescriptionContainingIgnoreCase(text, page, size);
    }

    @PostMapping({"", "/"})
    public Plant newPlant(@RequestBody Plant plant){
        return plantService.savePlant(plant);
    }

    @GetMapping("/{id}")
    public Plant getPlant(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.plantService.one(id);
    }

    @PutMapping("/{id}")
    public Plant replacePlant(@PathVariable("id") Long id, @RequestBody Plant plant) throws ChangeSetPersister.NotFoundException {
        return this.plantService.replace(id, plant);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException{
        this.plantService.delete(id);
    }


}
