package com.delivernow.back1_creacion_pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivernow.back1_creacion_pedidos.entities.Proveedor;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    List<Proveedor> findByNombre(String nombre);
    List<Proveedor> findByCategoria(String categoria);
}
