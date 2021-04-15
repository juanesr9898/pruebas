package co.edu.utp.isc.gia.pruebas.data.entity;

import co.edu.utp.isc.gia.pruebas.data.entity.usuarios.Estudiante;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Respuestas")
public class Respuesta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
   // Que columna en la tabla Preguntas tiene la FK (Llave foranea)
    // Varias respuestas estan en una prueba
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Prueba_id")
    private Prueba prueba;
    // Varios usuarios responden 
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Estudiante_id")
    private Estudiante estudiante;
    
}
