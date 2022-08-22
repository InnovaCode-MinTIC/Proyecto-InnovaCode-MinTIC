package com.innovacode.InnovaCode;

import com.innovacode.InnovaCode.entities.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InnovaCodeApplication {

	public static void main(String[] args) {

		SpringApplication.run(InnovaCodeApplication.class, args);

//		Empresa empresa1 = new Empresa("Comcel S.A.","Cra 30 #49a - 92 - Bogotá D.C", "+57 601 733 4546", "900.940.198-7");
//		System.out.println("empresa1 = " + empresa1);
	}

}
