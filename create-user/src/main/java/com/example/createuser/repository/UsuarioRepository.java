package com.example.createuser.repository;

import com.example.createuser.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByCorreoElectronico(String correoElectronico);
}
