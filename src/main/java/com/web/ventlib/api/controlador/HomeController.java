package com.web.ventlib.api.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.ventlib.api.entidad.DetallePedido;
import com.web.ventlib.api.entidad.Libro;
import com.web.ventlib.api.entidad.Pedido;
import com.web.ventlib.api.entidad.Usuario;
import com.web.ventlib.api.servicio.DetallePedidoServicio;
import com.web.ventlib.api.servicio.LibroServicio;
import com.web.ventlib.api.servicio.PedidoServicio;
import com.web.ventlib.api.servicio.UsuarioServicio;

@Controller
@RequestMapping("/")
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PedidoServicio pedidoServicio;

    @Autowired
    private DetallePedidoServicio detallePedidoServicio;

    // Almacenar Orden
    List<DetallePedido> detalles = new ArrayList<DetallePedido>();

    // Datos Orden
    Pedido pedido = new Pedido();

    // Previo del producto
    @GetMapping("/previo/{id}")
    public String productoHome(@PathVariable Long id, Model model) {
        log.info("Id producto enviado como parámetro {}", id);
        Libro libro = new Libro();
        Optional<Libro> productoOptional = libroServicio.get(id);
        libro = productoOptional.get();

        model.addAttribute("libro", libro);

        return "previo";
    }

    // Agregar al carrito
    @PostMapping("/carrito")
    public String addCarrito(@RequestParam Long id, @RequestParam Integer cantidad, Model model) {
        DetallePedido detallePedido = new DetallePedido();
        Libro libro = new Libro();
        double sumaTotal = 0;

        Optional<Libro> optionalProducto = libroServicio.get(id);
        log.info("Producto añadido: {}", optionalProducto.get());
        log.info("Cantidad: {}", cantidad);
        libro = optionalProducto.get();

        detallePedido.setCantidad(cantidad);
        detallePedido.setPrecio(libro.getPrecio());
        detallePedido.setNombre(libro.getTitulo());
        detallePedido.setTotal(libro.getPrecio() * cantidad);
        detallePedido.setLibro(libro);

        // validar que le producto no se añada 2 veces
        Long idLibro = libro.getIdLibro();
        boolean ingresado = detalles.stream().anyMatch(p -> p.getLibro().getIdLibro() == idLibro);

        if (!ingresado) {
            detalles.add(detallePedido);
        }

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        pedido.setTotal(sumaTotal);
        model.addAttribute("carrito", detalles);
        model.addAttribute("pedido", pedido);

        return "carrito";
    }

    //Modificar

    // quitar un producto del carrito
	@GetMapping("/delete/carrito/{id}")
	public String deleteProductoCart(@PathVariable Long id, Model model) {

		// lista nueva de prodcutos
		List<DetallePedido> pedidoNuevo = new ArrayList<DetallePedido>();

		for (DetallePedido detallePedido : detalles) {
			if (detallePedido.getLibro().getIdLibro() != id) {
				pedidoNuevo.add(detallePedido);
			}
		}

		// poner la nueva lista con los productos restantes
		detalles = pedidoNuevo;

		double sumaTotal = 0;
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		pedido.setTotal(sumaTotal);
		model.addAttribute("carrito", detalles);
		model.addAttribute("pedido", pedido);

		return "/index";
	}
	
	@GetMapping("/getCarrito")
	public String getCart(Model model, HttpSession session) {
		
		model.addAttribute("carrito", detalles);
		model.addAttribute("pedido", pedido);
		
		//sesion
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "/carrito";
	}
	
	@GetMapping("/pedido/{username}")
	public String order(Model model, @PathVariable (name = "username") String username) {
        Optional<Usuario> us = usuarioServicio.findByEmail(username);

        Usuario usuario = new Usuario(us.get().getNombre(), us.get().getApellidos(), us.get().getDireccion(), us.get().getLocalidad(), us.get().getCodigoPostal(), us.get().getCiudad(), us.get().getEmail(), us.get().getPassword(), us.get().getRoles());

        model.addAttribute("usuario", usuario);
		model.addAttribute("cart", detalles);
		model.addAttribute("pedido", pedido);
		
		return "resumenPedido";
	}
	
	// guardar el Pedido
	@GetMapping("/savePedido/{username}")
	public String saveOrder(@PathVariable (name = "username") String username ) {
		Date fechaCreacion = new Date();
        pedido.setFecha(fechaCreacion);
		pedido.setNumeroOrd(pedidoServicio.generarNumeroOrden());
		
		//usuario
		Optional<Usuario> us = usuarioServicio.findByEmail(username);

        Usuario usuario = new Usuario(us.get().getIdUsuario(),us.get().getNombre(), us.get().getApellidos(), us.get().getDireccion(), us.get().getLocalidad(), us.get().getCodigoPostal(), us.get().getCiudad(), us.get().getEmail(), us.get().getPassword(), us.get().getRoles());

		pedido.setUsuario(usuario);
		pedidoServicio.save(pedido);
		
		//guardar detalles
		for (DetallePedido dt:detalles) {
			dt.setPedido(pedido);
			detallePedidoServicio.guardarDetallePedido(dt);
		}
		
		///limpiar lista y orden
		pedido = new Pedido();
		detalles.clear();
		
		return "redirect:/index";
	}

}