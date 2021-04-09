
package co.edu.utp.isc.gia.pruebas.data.entity.respuestas;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Respuestas_Unica")
public class RespuestaMultiple1Opcion extends Pregunta{
    private int respuesta_opcion_unica;
//    
//    public boolean VerificarRespuestaCorrecta(RespuestaAbierta respuesta){
//        if(respuesta.getRespuesta().toLowerCase() ==  respuesta_correcta.toLowerCase()){
//            correcta = true;
//        }else{
//            correcta = false;
//        }
//        return correcta;
//    }
}
