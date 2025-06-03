package com.delivernow.back1-creacion-pedidos;


import javax.persistence.*;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;
    private Long proveedorId;

    @OneToMany(mappedBy = "pedido")
    private List<Producto> productos;  // lista de productos seleccionados en el pedido

    private Long usuarioId;

    private boolean completado;  // estado del pedido (completado o pendiente)

    // Constructor vacío
    public Pedido() {
    }

    // Constructor con parámetros
    public Pedido(String categoria, Long proveedorId, List<Producto> productos, Long usuarioId) {
        this.categoria = categoria;
        this.proveedorId = proveedorId;
        this.productos = productos;
        this.usuarioId = usuarioId;
        this.completado = false;  // el pedido comienza como no completado
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
