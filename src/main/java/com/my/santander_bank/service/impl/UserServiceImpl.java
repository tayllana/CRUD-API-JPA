package com.my.santander_bank.service.impl;

import com.my.santander_bank.domain.model.User;
import com.my.santander_bank.domain.repository.UserRepository;
import com.my.santander_bank.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/* `UserRepository` -> lida diretamente com operações de banco de dados.
`UserService` -> encapsula a lógica de negócios relacionada aos usuários e utiliza o `UserRepository` para acessar os dados.  */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User newUser) {
        // Verifica se o ID do novo usuário já existe no banco de dados
        if(userRepository.existsByAccountNumber(newUser.getAccount().getNumber())) {
            throw new IllegalArgumentException("User with this account number already exists");
        }
        return userRepository.save(newUser);
    }

}
