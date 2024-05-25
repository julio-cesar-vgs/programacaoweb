package com.example.programacaoweb.services;

import com.example.programacaoweb.entities.User;
import com.example.programacaoweb.repositories.UserRepository;
import com.example.programacaoweb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        try {
            return Optional.ofNullable(userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id)));
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + id);
        }
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        userRepository.deleteById(id);
    }

    public User update(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new ResourceNotFoundException("Usuário não encontrado com o ID: " + user.getId());
        }
        try {
            userRepository.save(user);
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("Erro ao atualizar o usuário com o ID: " + user.getId());
        }
        return user;
    }
}
