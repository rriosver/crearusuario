package com.example.createuser.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Telefonos")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    @Column(name = "codigo_ciudad", nullable = false)
    private String codigoCiudad;

    @Column(name = "codigo_pais", nullable = false)
    private String codigoPais;

    public Telefono(Long id, Usuario usuario, String numero, String codigoCiudad, String codigoPais) {
        this.id = id;
        this.usuario = usuario;
        this.numero = numero;
        this.codigoCiudad = codigoCiudad;
        this.codigoPais = codigoPais;
    }

    public Telefono() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCodigoCiudad() {
        return codigoCiudad;
    }
    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }
    public String getCodigoPais() {
        return codigoPais;
    }
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                ", numero='" + numero + '\'' +
                ", codigoCiudad='" + codigoCiudad + '\'' +
                ", codigoPais='" + codigoPais + '\'' +
                '}';
    }
}