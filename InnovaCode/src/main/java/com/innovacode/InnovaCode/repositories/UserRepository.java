package com.innovacode.InnovaCode.repositories;

import com.innovacode.InnovaCode.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long>{
    Usuario findByEmail(String email);
}
