package com.web.ventlib.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import com.web.ventlib.api.entidad.Libro;
import com.web.ventlib.api.repositorio.LibroRepositorio;

@Controller
@SpringBootApplication
public class VentaDeLibrosIsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(VentaDeLibrosIsApplication.class, args);
	}

	@Autowired
	private LibroRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception{
		/*Libro libro1 = new Libro("Precidente", "Juan", (long) 1234567890, 125.50);
		repositorio.save(libro1);

		Libro libro2 = new Libro("Prince", "Jose", (long) 1234787890, 100.5);
		repositorio.save(libro2);*/

	}

}
