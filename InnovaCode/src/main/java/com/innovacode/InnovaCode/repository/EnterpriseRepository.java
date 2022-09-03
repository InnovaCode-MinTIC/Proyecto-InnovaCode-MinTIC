package com.innovacode.InnovaCode.repository;

import com.innovacode.InnovaCode.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

}
