package com.my.santander_bank.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.my.santander_bank.domain.model.User;
import com.my.santander_bank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// Aqui você pode adicionar métodos para lidar com as requisições HTTP
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

   @PostMapping
   public ResponseEntity<User> create(@RequestBody User newUser) {
       // Chama o serviço para criar o novo usuário
       var userCreated = userService.create(newUser);

       // Constrói a URI do novo recurso criado
       // Quando essa URI for chamada vai mostrar o usuário criado
       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(userCreated.getId())
               .toUri();

       // Retorna a resposta com o status 201 Created e o corpo contendo o novo usuário
       return ResponseEntity.created(location).body(userCreated);
   }
}