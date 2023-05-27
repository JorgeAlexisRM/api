package com.web.ventlib.api.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.ventlib.api.entidad.Libro;
import com.web.ventlib.api.servicio.LibroServicio;

@Controller
public class LibroController {
    
    @Autowired
    private LibroServicio servicio;

    @GetMapping({"/libros","/"})
    public String listarLibros(Model modelo){
        modelo.addAttribute("libros", servicio.listarLibros());
        return "libros";
    }

    @GetMapping("/libros/nuevo")
    public String mostrarLibroFormulario(Model modelo){
        Libro libro = new Libro();
        modelo.addAttribute("libro", libro);
        return "crear_libro";
    }

    @PostMapping("/libros")
    public String guardarLibro(@ModelAttribute("libro") Libro libro){
        servicio.guardarLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/libros/editar/{id}")
    public String mostrarFormEditar(@PathVariable Long id,Model modelo){
        modelo.addAttribute("libro", servicio.obtenerLibroPorId(id));
        return "editar_libro";
    }

    @PostMapping("/libros/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro, Model modelo){
        Libro libroExistente = servicio.obtenerLibroPorId(id);
        libroExistente.setIdLibro(id);
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAutor(libro.getAutor());
        libroExistente.setIsbn(libro.getIsbn());
        libroExistente.setPrecio(libro.getPrecio());

        servicio.actualizarLibro(libroExistente);
        return "redirect:/libros";
    }

    @GetMapping("/libros/{id}")
    public String eliminarLibro(@PathVariable Long id){
        servicio.eliminarLibro(id);
        return "redirect:/libros";
    }


    /*@GetMapping("/libros/isbn")
	public ResponseEntity<List<Libro>> getFindByISBN(@RequestParam Long isbn) {
		return new ResponseEntity<List<Libro>>(servicio.findByISBN(isbn), HttpStatus.OK);
	}*/

}
