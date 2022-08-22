package com.innovacode.InnovaCode.controllers;

import com.innovacode.InnovaCode.entities.Empresa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    @GetMapping("/Empresa")
    public Empresa mostrarEmpresa(){
        Empresa empresa1 = new Empresa("Inelcitel SAS", "Trasversal 77c #47 - 16", "+57 311 499 3733", "900.940.198-7");
        return empresa1;
    }
}
