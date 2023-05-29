package com.web.ventlib.api.controlador;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.ventlib.api.dto.UsuarioRegistroDTO;
import com.web.ventlib.api.entidad.Usuario;
import com.web.ventlib.api.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
    
    private final Logger logger= LoggerFactory.getLogger(RegistroUsuarioController.class);

    @Autowired
    private UsuarioServicio usuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornNuevoUsuarioRegistroDTO(){
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "nuevo";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
        usuarioServicio.guardarUsuario(registroDTO);
        return "redirect:/registro?exito";
    }

}
