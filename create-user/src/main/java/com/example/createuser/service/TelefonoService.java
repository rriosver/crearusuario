package com.example.createuser.service;

import com.example.createuser.model.Telefono;
import com.example.createuser.model.Usuario;
import com.example.createuser.repository.TelefonoRepository;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class TelefonoService {

    @Autowired
    private TelefonoRepository telefonoRepository;

    public void addTelefono(Usuario usuario, Telefono telefono) {
        telefono.setUsuario(usuario);
        telefonoRepository.save(telefono);
    }
}