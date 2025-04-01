package com.my.santander_bank.domain.repository;

import com.my.santander_bank.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Essa classe cria, busca, atualiza e deleta
}
