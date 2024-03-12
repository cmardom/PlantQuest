package org.iesvdm.proyecto_plantquest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.proyecto_plantquest.domain.User;
import org.iesvdm.proyecto_plantquest.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public List<User> all(){
        log.info("Accessing User List");
        return this.userService.all();
    }

    @PostMapping({"", "/"})
    public User newUser(@RequestBody User user){
        return this.userService.save(user);
    }

    @GetMapping("/{id}")
    public User one(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.userService.one(id);
    }

    @PutMapping("/{id}")
    public User replaceUser(@PathVariable("id") Long id, @RequestBody User user) throws ChangeSetPersister.NotFoundException {
        return this.userService.replace(id, user);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        this.userService.delete(id);
    }
}
