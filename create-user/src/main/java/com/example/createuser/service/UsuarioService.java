package com.example.createuser.service;

import com.example.createuser.dto.UsuarioDTO;
import com.example.createuser.excepcion.ContraseniaInvalidaException;
import com.example.createuser.excepcion.CorreoElectronicoInvalidoException;
import com.example.createuser.excepcion.CorreoElectronicoYaRegistradoException;
import com.example.createuser.excepcion.NombreInvalidoException;
import com.example.createuser.mapper.UsuarioMapper;
import com.example.createuser.model.Usuario;
import com.example.createuser.repository.TelefonoRepository;
import com.example.createuser.repository.UsuarioRepository;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = UsuarioMapper.toUsuario(usuarioDTO);

        validarDatosUsuario(usuario);

        Usuario usuarioExistente = usuarioRepository.findByCorreoElectronico(usuario.getCorreoElectronico());
        if (usuarioExistente != null) {
            throw new CorreoElectronicoYaRegistradoException("El correo electrónico ya está registrado");
        }

        usuario.setFechaCreacion(new Date());
        usuario.setFechaModificacion(new Date());
        usuario.setUltimoAcceso(new Date());
        usuario.setToken(UUID.randomUUID());
        usuario.setIsActivo(true);
        usuario.setId(UUID.randomUUID());
        usuario.setContrasenia(usuario.getContrasenia());

        return usuarioRepository.save(usuario);
    }

    private void validarDatosUsuario(Usuario usuario) {
        if (usuario.getNombre().length() < 3) {
            throw new NombreInvalidoException("El nombre debe tener al menos 3 caracteres");
        }

        if (!validarCorreoElectronico(usuario.getCorreoElectronico())) {
            throw new CorreoElectronicoInvalidoException("El correo electrónico no es válido");
        }

        if (!validarContrasenia(usuario.getContrasenia())) {
            throw new ContraseniaInvalidaException("La contraseña debe tener al menos 8 caracteres, incluyendo una letra mayúscula, una letra minúscula y dos números");
        }
    }

    private boolean validarCorreoElectronico(String correoElectronico) {
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return correoElectronico.matches(regex);
    }

    private boolean validarContrasenia(String contrasenia) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d)[A-Za-z\\d]{8,}$";
        return contrasenia.matches(regex);
    }

    public Usuario getUsuarioByCorreoElectronico(String correoElectronico) {
        return usuarioRepository.findByCorreoElectronico(correoElectronico);
    }

    public Usuario getUsuarioById(UUID id) {
        return usuarioRepository.getReferenceById(id);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
