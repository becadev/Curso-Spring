package com.Apis.api.Controller;

import com.Apis.api.Service.ApiService;
import com.Apis.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;
    @Autowired
    private ApiController(ApiService apiService) { // injetando a instancia service
        this.apiService = apiService;
    }

    @GetMapping
    public String getAllUsers() {
        return "Usuários cadastrados\n" + apiService.listarUsuarios();
    }

    @PostMapping
    public String AddUser(@RequestBody User user){
        return apiService.AddUsuario(user);
    }

    // put pelo escopo da url api/1?newName=João&newEmail=joao@email.com
//    @PutMapping("/{id}")
//    public void changeNameUser(@PathVariable("id") Long id, @RequestParam String newName, @RequestParam String newEmail) {
//        apiService.changeUser(id,newName,newEmail);
//    }
    // put por meio de body do json, manda apenas o que será alterado no json, no caso name e email
    @PutMapping("/{id}")
    public String changeNameUser(@PathVariable("id") Long id, @RequestBody User uptadeUser) {
        return apiService.changeUser(id,uptadeUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        apiService.deleteUser(id);
    }
}
