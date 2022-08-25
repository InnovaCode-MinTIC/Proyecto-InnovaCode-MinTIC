package com.innovacode.InnovaCode;

import com.innovacode.InnovaCode.entities.Enterprise;

import java.util.ArrayList;

//@SpringBootApplication
public class InnovaCodeApplication {

	public static void main(String[] args) {

		//SpringApplication.run(InnovaCodeApplication.class, args);

		//Se ejecuta la función para probar la instancia de la clase empresa y sus métodos get y set
		testingEnterprises();
	}

	public static void testingEnterprises(){
		//Se crea la lista de empresas.
		ArrayList<Enterprise> enterprises = new ArrayList<>();

		//Se inicializa cada ítem de la lista y automáticamente se crean 10 empresas.
		for (int i = 0; i<10 ; i++) {
			enterprises.add(new Enterprise(i,"Empresa "+i,""+i+i+i+"."+i+i+i+"."+i+i+i+"-"+i,"+57 "+i+i+i+i+i+i+i+i+i+i,"Calle "+i+" #"+i+" - "+i));
		}

		//Se lee y modifica el nombre de la empresa en 1.
		System.out.println("Nombre original: " + enterprises.get(1).getName());
		enterprises.get(1).setName("Empresa nueva");
		System.out.println("Nuevo nombre: " + enterprises.get(1).getName());

		//Se lee y modifica la dirección de la empresa en 2.
		System.out.println("Direccion original: "+ enterprises.get(2).getAddress());
		enterprises.get(2).setAddress("Carrera 1 # 2 - 3");
		System.out.println("Nueva Direccion: " + enterprises.get(2).getAddress());

		//Se lee y modifica el teléfono de la empresa en 0.
		System.out.println("Telefono original: " + enterprises.get(0).getPhone());
		enterprises.get(0).setPhone("+57 1234567890");
		System.out.println("Nuevo telefono: " + enterprises.get(0).getPhone());

		//Se lee y modifica la identificación (NIT) de la empresa en 8.
		System.out.println("Identificacion original: " + enterprises.get(8).getDocument());
		enterprises.get(8).setDocument("123.456.789-0");
		System.out.println("Nueva Identificacion: " + enterprises.get(8).getDocument());
	}

}
