package com.Apis.api.Service;

import com.Apis.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiService {
    private List<User> usuarios = new ArrayList<>();

    public String AddUsuario(User user){
        this.usuarios.add(user);
        return "Usuário cadastrado";
    }

    public String listarUsuarios() {
        return usuarios.stream()
                .map(user -> "Nome: " + user.getName() + "\n" +
                        "ID: " + user.getId() + "\n" +
                        "Email: " + user.getEmail())
                .collect(Collectors.joining("\n\n")); //espaço entre os usuários
    }
// update por meio da url
//    public String changeUser(Long id, String newName, String newEmail) {
//        this.usuarios.stream()
//                .filter(user -> user.getId().equals(id))
//                .forEach(user -> {
//                        user.setName(newName);
//                        user.setEmail(newEmail);
//                });
//        return "Usuário alterado";
//    }
    // update por do body do json
    public String changeUser(Long id, User updateuser) {
        boolean updated = this.usuarios.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()  // Encontra o primeiro usuário correspondente
                .map(user -> {
                    user.setName(updateuser.getName());
                    user.setEmail(updateuser.getEmail());
                    return true;
                })
                .orElse(false); // Se não encontrar o usuário, retorna falso
        return updated? "Usuário alterado":"Usuário não encontrado";
    }

    public String deleteUser(Long id) {
        this.usuarios.removeIf(user -> user.getId().equals(id));
        return "Usuário deletado";
    }



//    public void atualizarUsuario(int id, String novoNome, String novoEmail) {
//    usuarios.stream()
//        .filter(user -> user.getId() == id)
//        .forEach(user -> {
//            user.setName(novoNome);
//            user.setEmail(novoEmail);
//        });
//}
// Esse método mantém a mesma referência na lista, alterando apenas os atributos.
//
//🔹 Qual usar?
//
//Se a classe User for imutável (sem setters), use o primeiro método (cria um novo objeto).
//
//Se User permitir modificações diretas, a segunda abordagem pode ser mais eficiente.
}
