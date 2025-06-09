package com.delivernow.back1_creacion_pedidos.repositories-creacion-pedidos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivernow.back1_creacion_pedidos.entities.Producto;
import com.delivernow.back1_creacion_pedidos.entities.Proveedor;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByProveedor(Proveedor proveedor);
}
