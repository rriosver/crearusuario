package com.example.createuser.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false, unique = true, length = 100)
    private String correoElectronico;

    @Column(name = "contrasenia", nullable = false, length = 255)
    private String contrasenia;

    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "ultimo_acceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoAcceso;

    @Column(name = "token", nullable = false, length = 255)
    private UUID token;

    @Column(name = "is_activo", nullable = false)
    private Boolean isActivo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefono> telefonos = new ArrayList<>();

    public Usuario(UUID id, String nombre, String correoElectronico, String contrasenia, List<Telefono> telefonos, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.telefonos = telefonos;
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario() {}

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }
    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
    public UUID getToken() {
        return token;
    }
    public void setToken(UUID token) {
        this.token = token;
    }
    public Boolean getIsActivo() {
        return isActivo;
    }
    public void setIsActivo(Boolean isActivo) {
        this.isActivo = isActivo;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }
    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", telefonos=" + telefonos.toString() +
                '}';
    }
}