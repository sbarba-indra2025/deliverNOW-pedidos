package com.delivernow.back1_creacion_pedidos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.delivernow.back1_creacion_pedidos.entities.Pedido;
import com.delivernow.back1_creacion_pedidos.entities.Producto;
import com.delivernow.back1_creacion_pedidos.entities.Proveedor;
import com.delivernow.back1_creacion_pedidos.repositories.PedidoRepository;
import com.delivernow.back1_creacion_pedidos.repositories.ProductoRepository;
import com.delivernow.back1_creacion_pedidos.repositories.ProveedorRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/proveedores/{categoria}")
    public ResponseEntity<List<Proveedor>> getProveedores(@PathVariable String categoria) {
        List<Proveedor> proveedores = proveedorRepository.findByCategoria(categoria);

        if (proveedores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/productos/{proveedorId}")
    public ResponseEntity<List<Producto>> getProductos(@PathVariable Long proveedorId) {
        List<Producto> productos = productoRepository.findByProveedorId(proveedorId);

        if (productos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(productos);
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        if (
            pedido == null || pedido.getCategoria() == null || pedido.getProveedorId() == null || 
            pedido.getProductosIds() == null || pedido.getUsuarioId() == null
        ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Pedido savedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPedido);
    }

    @PatchMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> actualizarRepartidor(@PathVariable Long id, @RequestBody Map<String, Long> body) {
        Long repartidorId = body.get("repartidorId");

        // buscar el pedido
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        
        // actualiza el pedido con el repartidor
        pedido.setRepartidorId(repartidorId);

        // guarda el pedido actualizado
        Pedido updatedPedido = pedidoRepository.save(pedido);

        return ResponseEntity.ok(updatedPedido);
    }
}
