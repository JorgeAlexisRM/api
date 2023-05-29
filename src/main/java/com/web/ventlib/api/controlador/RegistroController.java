package com.web.ventlib.api.controlador;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.ventlib.api.entidad.Usuario;
import com.web.ventlib.api.servicio.UsuarioServicio;

@Controller
public class RegistroController {
    private final Logger logger= LoggerFactory.getLogger(RegistroController.class);

    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/")
    public String verPaginaInicio(){
        return "index";
    }
}
