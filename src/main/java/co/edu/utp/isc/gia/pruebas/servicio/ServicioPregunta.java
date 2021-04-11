package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import co.edu.utp.isc.gia.pruebas.data.entity.respuestas.RespuestaAbierta;
import co.edu.utp.isc.gia.pruebas.data.entity.respuestas.RespuestaMultiple;
import co.edu.utp.isc.gia.pruebas.data.entity.respuestas.RespuestaMultiple1Opcion;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPregunta;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPrueba;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioUsuario;
import co.edu.utp.isc.gia.pruebas.web.dto.PreguntaDto;
import co.edu.utp.isc.gia.pruebas.exceptions.MensajeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j

public class ServicioPregunta {
    private ModelMapper modelMapper = new ModelMapper();
    private RepositorioPregunta repositorioPregunta;
//    private RepositorioUsuario repositorioUsuario;
//    private RepositorioPrueba repositorioPrueba;

    public PreguntaDto guardar(PreguntaDto preguntaDto)
    throws MensajeException{
                
        if(preguntaDto == null){
            throw new MensajeException("ERROR! Datos de la pregunta invalidos.");
        }else if(preguntaDto.getPregunta() == null || preguntaDto.getPregunta().isEmpty()){
            throw new MensajeException("ERROR! Una pregunta debe preguntar algo.");
        }else if(preguntaDto.getPeso() <= 0){
            throw new MensajeException("ERROR! Responder esta pregunta debe valer algo.");
        }
//        else if(preguntaDto.getTipo_pregunta() > 3 || preguntaDto.getTipo_pregunta() < 0){
//            throw new MensajeException("ERROR! La pregunta debe tener un tipo.");
//        }
//        else if(preguntaDto.getUsuario_id() == null){
//            throw new MensajeException("ERROR! El Usuario_id de la pregunta es " + preguntaDto.getUsuario_id());
//        }
//        else if(preguntaDto.getPrueba_id() == null){
//            throw new MensajeException("ERROR! La Prueba_id de la pregunta es " + preguntaDto.getPrueba_id());
//        }
//        
//        Optional <Usuario> usuarioOpt = repositorioUsuario.findById(preguntaDto.getUsuario_id());
//        if(usuarioOpt == null){
//            throw new MensajeException("ERROR! La ID del usuario no existe.");
//        }
//        Usuario usuario = usuarioOpt.get();
//        Optional <Prueba> pruebaOpt = repositorioPrueba.findById(preguntaDto.getPrueba_id());
//        if(pruebaOpt == null){
//            throw new MensajeException("ERROR! La ID del usuario no existe.");
//        }
//        Prueba prueba = pruebaOpt.get();
//        if(preguntaDto.getTipo_pregunta() == 0){
//            RespuestaAbierta pregunta = modelMapper.map(preguntaDto, RespuestaAbierta.class);
////            preguntaDto.setUsuario(usuario);
////            preguntaDto.setPrueba(prueba);
//            preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
//            pregunta = repositorioPregunta.save(pregunta);  
//        }else if(preguntaDto.getTipo_pregunta() == 1){
//            RespuestaMultiple pregunta = modelMapper.map(preguntaDto, RespuestaMultiple.class);
////            preguntaDto.setUsuario(usuario);
////            preguntaDto.setPrueba(prueba);
//            preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
//            pregunta = repositorioPregunta.save(pregunta); 
//        }else if(preguntaDto.getTipo_pregunta() == 2){
//            RespuestaMultiple1Opcion pregunta = modelMapper.map(preguntaDto, RespuestaMultiple1Opcion.class);
////            preguntaDto.setUsuario(usuario);
////            preguntaDto.setPrueba(prueba);
//            preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
//            log.warn("preguntaDto " + preguntaDto);
////            pregunta.setUsuario(usuario);
////            pregunta.setPrueba(prueba);
//            pregunta = repositorioPregunta.save(pregunta); 
//            log.warn("pregunta " + pregunta);
//        }   
        
        //log.warn("preguntaDto " + preguntaDto);
        return preguntaDto;
    }

    public List<PreguntaDto> listarPreguntas() throws MensajeException{
         if (repositorioPregunta.findAll() == null){
            throw new MensajeException("No hay preguntas creadas todavia.");
        }    
         
        List<Pregunta> preguntas = (List<Pregunta>) repositorioPregunta.findAll();
        List<PreguntaDto> preguntaDto = new ArrayList<PreguntaDto>(); 
        
        if (preguntas == null || preguntas.isEmpty()){
            throw new MensajeException("No hay preguntas creadas todavia.");
        }else{
            preguntas.forEach((pregunta) -> {preguntaDto.add(modelMapper.map(pregunta, PreguntaDto.class));});
        }
        if(preguntaDto == null || preguntaDto.isEmpty() || preguntaDto.getClass() == null){
            throw new MensajeException("No hay preguntas creadas todavia.");
        }
        return preguntaDto;
     }

    public PreguntaDto findOne(Long id){        
        Optional<Pregunta> preguntaDto = repositorioPregunta.findById(id);         
        return modelMapper.map(preguntaDto.get(), PreguntaDto.class);
    }    

    public PreguntaDto updateOne(Long id, PreguntaDto PreguntaDto){
        repositorioPregunta.save(modelMapper.map(PreguntaDto, Pregunta.class));    
        return findOne(id);
    }

    public PreguntaDto removeOne(Long id){
        Optional<Pregunta> preguntaDto = repositorioPregunta.findById(id);    
        PreguntaDto PreguntaDto = new PreguntaDto();
        PreguntaDto = modelMapper.map(preguntaDto.get(), PreguntaDto.class);
        repositorioPregunta.deleteById(id);
        return PreguntaDto;        
    }
}