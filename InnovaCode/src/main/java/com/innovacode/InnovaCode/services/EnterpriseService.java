package com.innovacode.InnovaCode.services;

import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    private EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public List<Enterprise> getEnterpriseList() {
        return this.repository.findAll();
    }

    public Enterprise postEnterprise(Enterprise enterprise) {
        return this.repository.save(enterprise);
    }

    public Enterprise getEnterpriseById(Long id) {
        return this.repository.findById(id).get();
    }

    public Enterprise patchEnterprise(Long id, Enterprise enterprise) {
        Enterprise newEnterprise = getEnterpriseById(id);
        newEnterprise.setId(id);
        if(enterprise.getName() != null) newEnterprise.setName(enterprise.getName());
        if(enterprise.getDocument() != null) newEnterprise.setDocument(enterprise.getDocument());
        if(enterprise.getPhone() != null) newEnterprise.setPhone(enterprise.getPhone());
        if(enterprise.getName() != null) newEnterprise.setAddress(enterprise.getAddress());

        return this.repository.save(newEnterprise);
    }

    public void deleteEnterprise(Long id) {
        this.repository.deleteById(id);
    }


}