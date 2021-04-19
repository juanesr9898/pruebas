package co.edu.utp.isc.gia.pruebas.data.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Preguntas")
public class Pregunta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;    
    public String pregunta;
    public String respuesta;
    public double peso;
    @Column(nullable = true) //Puede o no terner una imagen la pregunta
    public String imagen;   
    // Que columna en la tabla Preguntas tiene la FK (Llave foranea)
    // Varias preguntas estan en una prueba
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Prueba_id")
    private Prueba prueba;
     
}
