package com.example.createuser.mapper;

import com.example.createuser.dto.UsuarioDTO;
import com.example.createuser.model.Usuario;

public class UsuarioMapper {
    public static Usuario toUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
        usuario.setContrasenia(usuarioDTO.getContrasenia());
        usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
        usuario.setFechaModificacion(usuarioDTO.getFechaModificacion());
        usuario.setIsActivo(usuarioDTO.getActivo());
        usuario.setTelefonos(usuarioDTO.getTelefonos());
        usuario.setUltimoAcceso(usuarioDTO.getUltimoAcceso());
        usuario.setToken(usuarioDTO.getToken());

        return usuario;
    }

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setCorreoElectronico(usuario.getCorreoElectronico());
        usuarioDTO.setContrasenia(usuario.getContrasenia());
        usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
        usuarioDTO.setFechaModificacion(usuario.getFechaModificacion());
        usuarioDTO.setActivo(usuario.getIsActivo());
        usuarioDTO.setTelefonos(usuario.getTelefonos());
        usuarioDTO.setUltimoAcceso(usuario.getUltimoAcceso());
        usuarioDTO.setToken(usuario.getToken());

        return usuarioDTO;
    }
}
