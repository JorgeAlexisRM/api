package com.web.ventlib.api.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ventlib.api.entidad.Pedido;
import com.web.ventlib.api.entidad.Usuario;
import com.web.ventlib.api.repositorio.PedidoRepositorio;

@Service
public class PedidoServicioImpl implements PedidoServicio{

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepositorio.findAll();
    }
    
    @Override
    public String generarNumeroOrden() {
        int numero=0;
        String numeroConcatenado="";

        List<Pedido> pedidos = findAll();

        List<Integer> numeros = new ArrayList<Integer>();

        pedidos.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumeroOrd())));

        if(pedidos.isEmpty()){
            numero=1;
        }else{
            numero= numeros.stream().max(Integer::compare).get();
            numero++;
        }

        if(numero<10) {
            numeroConcatenado="000000000"+String.valueOf(numero);
		}else if(numero<100) {
			numeroConcatenado="00000000"+String.valueOf(numero);
		}else if(numero<1000) {
			numeroConcatenado="0000000"+String.valueOf(numero);
		}else if(numero<10000) {
			numeroConcatenado="0000000"+String.valueOf(numero);
		}		
		
		return numeroConcatenado;
    }

    @Override
    public List<Pedido> findByUsuario(Usuario usuario) {
        return pedidoRepositorio.findByUsuario(usuario);
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepositorio.findById(id);
    }




}