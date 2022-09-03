package com.innovacode.InnovaCode.service;

import com.innovacode.InnovaCode.entity.Enterprise;
import com.innovacode.InnovaCode.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{

    @Autowired
    private EnterpriseRepository repository;


    @Override
    public List<Enterprise> listEnterprises() {
        return repository.findAll(); }

    @Override
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return repository.save(enterprise);
    }

    @Override
    public Enterprise consultarEnterprise(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Enterprise updateEnterpsises(Enterprise enterprise) {
        return repository.save(enterprise);
    }

    @Override
    public void deleteEnterprose(Long id) {
        repository.deleteById(id);
    }
}
