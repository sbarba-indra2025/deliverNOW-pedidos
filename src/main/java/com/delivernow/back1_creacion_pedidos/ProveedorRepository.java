package com.delivernow.back1-creacion-pedidos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    List<Proveedor> findByNombre(String nombre);

    List<Proveedor> findByCategoria(String categoria);
}
