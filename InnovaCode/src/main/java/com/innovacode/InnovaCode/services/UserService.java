package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Usuario;
import com.innovacode.InnovaCode.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Usuario createUser(Usuario newUsuario){
        return this.repository.save(newUsuario);
    }

    public Usuario findUserByEmail(String email){
        return this.repository.findByEmail(email);
    }

    public Usuario getOrCreateUser(Map<String, Object> userData) {
        String email = (String) userData.get("email");
        Usuario usuario = findUserByEmail(email);
        if(usuario == null){
            String name = (String) userData.get("name");
            String image = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");

            Usuario newUsuario = new Usuario(email=email,image=image,auth0Id=auth0Id);
            return createUser(newUsuario);
        }
        return usuario;
    }
}
