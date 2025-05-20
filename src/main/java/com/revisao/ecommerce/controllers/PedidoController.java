package com.revisao.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.services.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pedido")
public class PedidoController
{

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/new")
    public ResponseEntity<PedidoDTO> inserPedido(@RequestBody @Valid PedidoDTO dto) {
        dto = pedidoService.inserir(dto);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id); 
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }
}
