package co.edu.utp.isc.gia.pruebas.web.dto;

import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL) //No muestra valores nulos
public class PreguntaDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    public String pregunta;
    public String respuesta;
    private double peso;
    @Column(nullable = true) //Puede o no terner una imagen la pregunta
    public String imagen; 
//    private int respuesta_opcion_unica;
//    private int respuesta_opcion_multiple;
//    private String respuesta_abierta;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Cuando se liste, no mostrar el tipo de pregunta
//    public int tipo_pregunta;
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "Prueba_id")
//    private Long prueba_id;
//    //private Prueba prueba;
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "Usuario_id")
//    //private Usuario usuario;
//    private Long usuario_id;
}