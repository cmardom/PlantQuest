package org.iesvdm.proyecto_plantquest.service;

import org.iesvdm.proyecto_plantquest.domain.User;
import org.iesvdm.proyecto_plantquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> all() {return this.userRepository.findAll();}
    public User save(User user) {return this.userRepository.save(user);}

    //probar excepcion: predeterminadas o propias?
    public User one(Long id) throws ChangeSetPersister.NotFoundException {
        return this.userRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public User replace(Long id, User user) throws ChangeSetPersister.NotFoundException {
        return this.userRepository.findById(id).map(u -> (id.equals(user.getID()) ?
                this.userRepository.save(user) : null))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void delete(Long id) throws ChangeSetPersister.NotFoundException {
        this.userRepository.findById(id).map(u -> {this.userRepository.delete(u);
                return u;})
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
