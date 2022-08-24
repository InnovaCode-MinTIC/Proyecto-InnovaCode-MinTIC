package com.innovacode.InnovaCode;

import com.innovacode.InnovaCode.entities.Enterprise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InnovaCodeApplication {

	public static void main(String[] args) {

		SpringApplication.run(InnovaCodeApplication.class, args);

		//Enterprise empresa1 = new Enterprise("Comcel S.A.","Tv 77c #47 16 - Bogotá D.C", "+57 601 733 4546", "900.940.198-7");
		//System.out.println("empresa1 = " + empresa1);
	}

}
