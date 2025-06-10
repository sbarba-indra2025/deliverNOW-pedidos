package com.delivernow.back1_creacion_pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivernow.back1_creacion_pedidos.entities.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByProveedorId(Long proveedorId);
}
