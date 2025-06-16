package pe.edu.vallegrande.inventaStore.service.impl;

import pe.edu.vallegrande.inventaStore.model.User;
import pe.edu.vallegrande.inventaStore.repository.UserRepository;
import pe.edu.vallegrande.inventaStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        log.info("Listando Usuarios");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long identifier) {
        log.info("Buscando Usuario por ID: {}", identifier);
        return userRepository.findById(identifier);
    }

    @Override
    public List<User> findByState(Boolean state) {
        log.info("Listando Usuarios por estado: {}", state);
        return userRepository.findByState(state);
    }

    @Override
    public User save(User user) {
        log.info("Registrando Usuario: {}", user);
        user.setState(true);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.info("Actualizando Usuario: {}", user);
        user.setState(true);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> softDelete(Long identifier) {
        Optional<User> userOpt = userRepository.findById(identifier);
        userOpt.ifPresent(user -> {
            log.info("Desactivando Usuario ID: {}", identifier);
            user.setState(false);
            userRepository.save(user);
        });
        return userOpt;
    }

    @Override
    public Optional<User> restore(Long identifier) {
        Optional<User> userOpt = userRepository.findById(identifier);
        userOpt.ifPresent(user -> {
            log.info("Reactivando Usuario ID: {}", identifier);
            user.setState(true);
            userRepository.save(user);
        });
        return userOpt;
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    
}
