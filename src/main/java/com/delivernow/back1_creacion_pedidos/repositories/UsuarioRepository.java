package com.delivernow.back1_creacion_pedidos.repositories-creacion-pedidos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivernow.back1_creacion_pedidos.entities.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuarioAndContrasena(String username, String password);
}
