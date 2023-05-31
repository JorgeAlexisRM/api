package com.web.ventlib.api.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.ventlib.api.entidad.Pedido;
import com.web.ventlib.api.servicio.PedidoServicio;

@Controller
public class AdminController {
    
    @Autowired
    private PedidoServicio pedidoServicio;

    private Logger logg= LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/admin/pedidos")
	public String ordenes(Model model) {
        List<Pedido> pedidos = pedidoServicio.findAll();
		model.addAttribute("pedidos", pedidos);
		return "pedidos";
	}
	
	@GetMapping("/admin/detalle/{id}")
	public String detalle(Model model, @PathVariable Long id) {
		logg.info("Id de la orden {}",id);
		Pedido pedido= pedidoServicio.findById(id).get();
		
		model.addAttribute("detalles", pedido.getDetalle());
		
		return "detalle_pedido";
	}
}
