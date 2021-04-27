package co.edu.utp.isc.gia.pruebas.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private String userID;
    public String nombre;
    public String email;
    @Column(name="tipoUsuario")
    public int tipoUsuario;
    private String password;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Docente_id")
    private List<Prueba> pruebas;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Estudiante_id")
    private List<Respuesta> respuestas;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Estudiante_id")
    private List<Nota> nota;
}
