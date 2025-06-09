package com.delivernow.back1_creacion_pedidos.controllers-creacion-pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        if (pedido == null || pedido.getProveedor() == null || pedido.getProductos() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Pedido savedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPedido);
    }
}
