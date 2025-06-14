package com.delivernow.back1_creacion_pedidos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.delivernow.back1_creacion_pedidos.entities.Usuario;
import com.delivernow.back1_creacion_pedidos.repositories.UsuarioRepository;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (username == null || password == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("success", false, "message", "Faltan credenciales", "usuarioId", null));
        }

        Optional<Usuario> usuario = usuarioRepository.findByUsernameAndPassword(username, password);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(Map.of("success", true, "message", "Usuario autenticado", "usuarioId", usuario.get().getId()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false, "message", "Credenciales incorrectas", "usuarioId", null));
        }
    }
}
