package com.example.createuser.controller;


import com.example.createuser.dto.UsuarioDTO;
import com.example.createuser.mapper.UsuarioMapper;
import com.example.createuser.model.Telefono;
import com.example.createuser.model.Usuario;
import com.example.createuser.service.TelefonoService;
import com.example.createuser.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private static final Logger log = LogManager.getLogger(UsuarioController.class);
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TelefonoService telefonoService;

    @PostMapping("/registrar-usuario")
    public UsuarioDTO registrarUsuario(@RequestBody UsuarioDTO usuario) {
        Usuario  usuarioRegistrado = usuarioService.registrarUsuario(usuario);

        for (Telefono telefono : usuarioRegistrado.getTelefonos()) {
            telefonoService.addTelefono(usuarioRegistrado, telefono);
        }

        return UsuarioMapper.toUsuarioDTO(usuarioRegistrado);
    }
}
