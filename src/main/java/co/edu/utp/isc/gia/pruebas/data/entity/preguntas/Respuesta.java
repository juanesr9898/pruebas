package co.edu.utp.isc.gia.pruebas.data.entity.preguntas;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Respuesta{
    public String respuesta;  
//    public boolean correcta;
//    
//    public boolean isCorrecta(List<Pregunta> pregunta) {
//        if(respuesta.toLowerCase().equals(pregunta.getRespuesta_correcta().toLowerCase())){//Minuscalas las respuestas
//            correcta = true;
//        }else{
//            correcta = false;
//        }
//        return correcta;
//    }
}
