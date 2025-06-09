package com.delivernow.back1_creacion_pedidos.repositories-creacion-pedidos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivernow.back1_creacion_pedidos.entities.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuarioId(Long usuarioId);
}
