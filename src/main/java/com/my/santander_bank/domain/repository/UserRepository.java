package com.my.santander_bank.domain.repository;

import com.my.santander_bank.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/* `UserRepository` -> lida diretamente com operações de banco de dados.
`UserService` -> encapsula a lógica de negócios relacionada aos usuários e utiliza o `UserRepository` para acessar os dados.  */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
/* Métodos herdados da interface `JpaRepository`:
    - `save(S entity)`
    - `findById(ID id)`
    - `findAll()`
    - `deleteById(ID id)`
    - `existsById(ID id)`
    - `count()`
 */
    boolean existsByAccountNumber(String accountNumber);
}