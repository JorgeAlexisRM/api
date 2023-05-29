package com.web.ventlib.api.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.ventlib.api.entidad.Libro;
import com.web.ventlib.api.servicio.LibroServicio;

@Controller
public class LibroController {
    
    @Autowired
    private LibroServicio servicio;

    @RequestMapping("/index")
    public String verPaginaDeInicio(Model modelo,@Param("palabraClave") String palabraClave){
        List<Libro> listaLibros = servicio.listarLibros(palabraClave);
   
        modelo.addAttribute("listaLibros", listaLibros);
        modelo.addAttribute("palabraClave", palabraClave);
        return "index";
    }

    @RequestMapping("/admin/libros")
    public String verRegistroDeLibros(Model modelo,@Param("palabraClave") String palabraClave){
        List<Libro> listaLibros = servicio.listarLibros(palabraClave);
   
        modelo.addAttribute("listaLibros", listaLibros);
        modelo.addAttribute("palabraClave", palabraClave);
        return "libros";
    }

    @RequestMapping("/admin/nuevo")
    public String mostrarLibroFormulario(Model modelo){
        Libro libro = new Libro();
        modelo.addAttribute("libro", libro);
        return "crear_libro";
    }

    @RequestMapping(value = "/admin/guardar", method = RequestMethod.POST)
    public String guardarLibro(@ModelAttribute("libro") Libro libro){
        servicio.guardarLibro(libro);
        return "redirect:/admin/libros";
    }

    @RequestMapping("/admin/editar/{id}")
    public ModelAndView mostrarFormEditar(@PathVariable (name = "id") Long id){
        ModelAndView modelo = new ModelAndView("editar_libro");
        Libro libro = servicio.obtenerLibroPorId(id);
        modelo.addObject("libro", libro);
        return modelo;
    }

   /*@PostMapping("/libros/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro, Model modelo){
        Libro libroExistente = servicio.obtenerLibroPorId(id);
        libroExistente.setIdLibro(id);
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAutor(libro.getAutor());
        libroExistente.setIsbn(libro.getIsbn());
        libroExistente.setPrecio(libro.getPrecio());

        servicio.actualizarLibro(libroExistente);
        return "redirect:/libros";
    }*/

    @RequestMapping("/admin/eliminar/{id}")
    public String eliminarLibro(@PathVariable(name = "id") Long id){
        servicio.eliminarLibro(id);
        return "redirect:/admin/libros";
    }

    

}
