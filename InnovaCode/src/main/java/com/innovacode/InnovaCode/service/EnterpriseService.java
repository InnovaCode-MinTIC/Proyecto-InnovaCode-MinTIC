package com.innovacode.InnovaCode.service;

import com.innovacode.InnovaCode.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {


       public List<Enterprise> listEnterprises();

       public Enterprise saveEnterprise(Enterprise enterprise);

       public Enterprise consultarEnterprise(Long id);

       public Enterprise updateEnterpsises (Enterprise enterprise);

       public void deleteEnterprose(Long id);
}
