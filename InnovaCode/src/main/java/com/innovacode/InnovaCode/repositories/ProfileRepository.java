package com.innovacode.InnovaCode.repositories;

import com.innovacode.InnovaCode.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,String> {
}
