package com.web.ventlib.api.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.ventlib.api.entidad.Usuario;
import com.web.ventlib.api.servicio.UsuarioServicio;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioServicio servicio;

    @RequestMapping("/registro")
    public String mostrarUsuarioFormulario(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "crear_Usuario";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario){
        servicio.guardarUsuario(usuario);
        return "redirect:/";
    }

    @RequestMapping("/perfil/{id}")
    public ModelAndView mostrarFormEditar(@PathVariable (name = "id") Long id){
        ModelAndView modelo = new ModelAndView("editar_Usuario");
        Usuario usuario = servicio.obtenerUsuarioPorId(id);
        modelo.addObject("usuario", usuario);
        return modelo;
    }

    @RequestMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable(name = "id") Long id){
        servicio.eliminarUsuario(id);
        return "redirect:/";
    }
    
}
