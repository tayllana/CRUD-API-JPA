package com.my.santander_bank.service;

import com.my.santander_bank.domain.model.User;

/* `UserRepository` -> lida diretamente com operações de banco de dados.
`UserService` -> encapsula a lógica de negócios relacionada aos usuários e utiliza o `UserRepository` para acessar os dados.  */
public interface UserService {

    User findById(Long id);

    User create(User newUser);

}
