package co.edu.utp.isc.gia.pruebas.data.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
@Table(name = "Usuarios")
public class Usuario implements Serializable{    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;            //Tanto la id, como el username deben ser valores unicos
    @Column(unique = true)
    private String username;
    public String nombre;
    public String email;
    private String contraseña;
    public int tipoUsuario;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Docente_id")
    private List<Prueba> pruebas;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Estudiante_id")
    private List<Respuesta> respuestas;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Estudiante_id")
    private List<Nota> nota;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Authorities_users", joinColumns = @JoinColumn(name = "Usuario_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authority;
}
