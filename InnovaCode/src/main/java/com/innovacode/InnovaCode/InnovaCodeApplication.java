package com.innovacode.InnovaCode;

import com.innovacode.InnovaCode.entities.Employee;
import com.innovacode.InnovaCode.entities.Enterprise;
import com.innovacode.InnovaCode.entities.Profile;
import com.innovacode.InnovaCode.entities.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
public class InnovaCodeApplication {

	public static void main(String[] args) {

		SpringApplication.run(InnovaCodeApplication.class, args);

		//Se ejecuta la función para probar la instancia de la clase empresa y sus métodos get y set

		//testGeneral();
	}
	public static void testGeneral(){
		System.out.println("------------Prueba de Empresas------------");
		//Se crea la lista de empresas.
		ArrayList<Enterprise> enterprises = new ArrayList<>();

		//Se inicializa cada ítem de la lista y automáticamente se crean 4 empresas.
		for (int i = 0; i<4 ; i++) {
			enterprises.add(new Enterprise(i,"Empresa "+i,""+i+i+i+"."+i+i+i+"."+i+i+i+"-"+i,"+57 "+i+i+i+i+i+i+i+i+i+i,"Calle "+i+" #"+i+" - "+i));
		}
		// Se imprimen los atributos de las empresas
		for (Enterprise empresa:
			 enterprises) {
			System.out.println(empresa);
		}
		//Se lee y modifica el nombre de la empresa en 1.
		System.out.println("\nNombre original: " + enterprises.get(1).getName());
		enterprises.get(1).setName("Empresa nueva");
		System.out.println("Nuevo nombre: " + enterprises.get(1).getName());

		//Se lee y modifica la dirección de la empresa en 2.
		System.out.println("\nDireccion original: "+ enterprises.get(2).getAddress());
		enterprises.get(2).setAddress("Carrera 1 # 2 - 3");
		System.out.println("Nueva Direccion: " + enterprises.get(2).getAddress());

		//Se lee y modifica el teléfono de la empresa en 0.
		System.out.println("\nTelefono original: " + enterprises.get(0).getPhone());
		enterprises.get(0).setPhone("+57 1234567890");
		System.out.println("Nuevo telefono: " + enterprises.get(0).getPhone());

		//Se lee y modifica la identificación (NIT) de la empresa en 3.
		System.out.println("\nIdentificacion original: " + enterprises.get(3).getDocument());
		enterprises.get(3).setDocument("123.456.789-0");
		System.out.println("Nueva Identificacion: " + enterprises.get(3).getDocument());

		for (Enterprise empresa:
				enterprises) {
			System.out.println(empresa);
		}
		System.out.println("------------Prueba de Empleado------------");

		// Se crea una lista de profiles
		String[] nombreUsuario = new String[]{"Alvaro Alvarez","Blanca Benavides","Camilo Castro","Daniela Dominguez","Camilo Cruz"};
		ArrayList<Profile> perfiles = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			perfiles.add(new Profile(i+"",
					"image "+i,
					"+57 "+i+i+i+i+i+i+i+i+i+i,
					nombreUsuario[i]));
		}
		// Se imprimen todos los perfiles de prueba
		for (Profile perfil: perfiles ) {
			System.out.println(perfil.toString());
		}

		// se crea un empleado tomando el perfil 0 y la empresa 0
		Employee empleado = new Employee(Long.parseLong(perfiles.get(0).getId()),
				perfiles.get(0).getUser().substring(0,4)+"@mail.com",
				perfiles.get(0),
				Employee.Enum_RoleName.Admin,
				enterprises.get(0));

		// se visualizan los datos del empleado
		System.out.println(empleado);

		// se lee y modifica el id del empleado
		System.out.println("\nId original:\t"+empleado.getId());
		empleado.setId(12);
		System.out.println("Id nuevo:\t"+empleado.getId());

		// se lee y modifica el nombre de un empleado
		System.out.println("\nNombre original:\t"+empleado.getProfile().getUser());
		empleado.getProfile().setUser("Juan Perez");//perfiles.get(0).setUser("Juan perez");
		System.out.println("Nuevo nombre:\t\t"+empleado.getProfile().getUser());

		// se lee y modifica el correo de un empleado
		System.out.println("\nCorreo original:\t"+empleado.getEmail());
		empleado.setEmail("nuevo@correo.com");
		System.out.println("Nuevo correo:\t"+empleado.getEmail());

		// se lee y modifica la empresa del empleado
		System.out.println("\nEmpresa original:\t"+empleado.getEnterprise());
		empleado.setEnterprise(enterprises.get(1));
		System.out.println("\nNueva empresa:\t"+empleado.getEnterprise());

		// Se lee y modifica el rol del empleado
		System.out.println("\nRol original:\t"+empleado.getRole());
		empleado.setRole(Employee.Enum_RoleName.Operario);
		System.out.println("Nuevo rol:\t"+empleado.getRole());

		// se visualizan nuevamente los datos del empleado (modificado)
		System.out.println(empleado);

		System.out.println("------------Prueba de movimiento de dinero------------");

		// Se crea y lee una Transaccion
		Transaction transaction = new Transaction(1,"Debito cuenta 123",1000, perfiles.get(0), enterprises.get(0));
		System.out.println(transaction);

		// Se lee y modifica el monto por uno negativo
		System.out.println("\nMonto original:\t"+transaction.getAmount());
		transaction.setAmount(-500);
		System.out.println("Nuevo monto:\t"+transaction.getAmount());

		// Se lee y modifica el concepto del movimiento
		System.out.println("\nConcepto original:\t"+transaction.getConcept());
		transaction.setConcept("Credito cuenta 001");
		System.out.println("Nuevo concepto:\t"+transaction.getConcept());

		// Se lee y modifica el usuario que realiza el moviemiento
		System.out.println("\nUsuario original:\t"+transaction.getUser().getUser());
		transaction.setUser(perfiles.get(1));
		System.out.println("Nuevo usuario:\t"+transaction.getUser().getUser());

		// Se lee nuevamente la Transaccion
		System.out.println(transaction);
	}
}
