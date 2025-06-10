package com.delivernow.back1_creacion_pedidos.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoria")
    private String categoria; // categoría: comida o supermercado

    @Column(name = "proveedor_id")
    private Long proveedorId;

    @Column(name = "productos")    
    private List<Long> productosIds;  // lista de ids de productos seleccionados

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "repartidor_id")
    private Long repartidorId;

    @Column(name = "estado")
    private String estado;  // estado del pedido: pendiente, pagado, entregando, completado

    // Constructor vacío
    public Pedido() {
    }

    // Constructor con parámetros
    public Pedido(String categoria, Long proveedorId, List<Long> productosIds, Long usuarioId) {
        this.categoria = categoria;
        this.proveedorId = proveedorId;
        this.productosIds = productosIds;
        this.usuarioId = usuarioId;
        this.estado = "pendiente";  // el pedido comienza como "pendiente"
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getRepartidorId() {
        return repartidorId;
    }

    public void setRepartidorId(Long repartidorId) {
        this.repartidorId = repartidorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
