package co.edu.utp.isc.gia.pruebas.data.entity;

import co.edu.utp.isc.gia.pruebas.data.entity.usuarios.Docente;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Data
@Table(name = "Pruebas")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Prueba implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Column(nullable = true)
    public String descripcion;
    public String enlace;
    public String materia;
    //Una prueba puede ser creada por varios docentes
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Docente_id") 
    private Docente docente;
    // Una prueba tiene varias preguntas
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Prueba_id")
    private List<Pregunta> preguntas;
    // Una prueba tiene varias respuestas
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Prueba_id")
    private List<Respuesta> Respuestas;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Prueba_id")
    private List<Nota> Notas;
}
