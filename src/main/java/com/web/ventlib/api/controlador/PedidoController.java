package com.web.ventlib.api.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.ventlib.api.entidad.Pedido;
import com.web.ventlib.api.servicio.PedidoServicio;

@Controller
public class PedidoController {

    @Autowired
    private PedidoServicio servicio;

    @RequestMapping("/pedido")
    public String mostrarPedido(Model modelo){
        Pedido pedido = new Pedido();
        modelo.addAttribute("pedido", pedido);
        return "redirect:/";
    }

    @RequestMapping(value = "/guardarPedido", method = RequestMethod.POST)
    public String guardarPedido(@ModelAttribute("pedido") Pedido pedido){
        servicio.guardarPedido(pedido);
        return "redirect:/";
    }

    @RequestMapping("/perfil/{id}")
    public ModelAndView mostrarFormEditar(@PathVariable (name = "id") Long id){
        ModelAndView modelo = new ModelAndView("editar_Pedido");
        Pedido pedido = servicio.obtenerPedidoPorId(id);
        modelo.addObject("pedido", pedido);
        return modelo;
    }

    @RequestMapping("/eliminarPedido/{id}")
    public String eliminarPedido(@PathVariable(name = "id") Long id){
        servicio.eliminarPedido(id);
        return "redirect:/";
    }
}
