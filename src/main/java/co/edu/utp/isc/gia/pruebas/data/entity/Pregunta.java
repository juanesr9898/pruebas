package co.edu.utp.isc.gia.pruebas.data.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
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
@Table(name = "Preguntas")
public class Pregunta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    public String pregunta;
    public String respuesta_correcta;
    private float peso;
    public int tipo_pregunta;
    @Column(nullable = true) //Puede o no terner una imagen la pregunta
    public String imagen;    
    // Que columna en la tabla Preguntas tiene la FK (Llave foranea)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Prueba_id")
    private Prueba prueba;
    
}