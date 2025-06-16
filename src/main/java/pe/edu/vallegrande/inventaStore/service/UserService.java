package pe.edu.vallegrande.inventaStore.service;

import pe.edu.vallegrande.inventaStore.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long identifier);

    List<User> findByState(Boolean state);

    User save(User user);

    User update(User user);

    Optional<User> softDelete(Long identifier);

    Optional<User> restore(Long identifier);

    Optional<User> findByName(String name); 
}
