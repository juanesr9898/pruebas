package co.edu.utp.isc.gia.pruebas.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    public String respuestaCorrecta;
    public String respuesta;
    @Column(nullable = true) //Puede o no terner una imagen la pregunta
    public String respuesta2;
    @Column(nullable = true) //Puede o no terner una imagen la pregunta
    public String respuesta3;
    @Column(nullable = true) //Puede o no terner una imagen la pregunta
    public String respuesta4;
    private double peso;
    @Column(nullable = true) //Puede o no terner una imagen la pregunta
    public String imagen; 
    private Long pruebaID;    
}