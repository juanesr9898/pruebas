package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPregunta;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPrueba;
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
    private RepositorioPrueba repositorioPrueba;

    public PreguntaDto guardar(PreguntaDto preguntaDto) throws MensajeException {    
        
        if(preguntaDto == null){
            throw new MensajeException("ERROR! Datos de la pregunta invalidos.");
        }
        else if(preguntaDto.getPregunta() == null || preguntaDto.getPregunta().isEmpty()){
            throw new MensajeException("ERROR! Una pregunta debe preguntar algo.");
        }
        else if(preguntaDto.getPeso() <= 0){
            throw new MensajeException("ERROR! Responder esta pregunta debe valer algo.");
        }
        else if(preguntaDto.getPruebaID() == null){
            throw new MensajeException("ERROR! La ID de la prueba es nula.");
        }        
        Optional <Prueba> pruebaOpt = repositorioPrueba.findById(preguntaDto.getPruebaID());        
        if(pruebaOpt == null || !pruebaOpt.isPresent()){
            throw new MensajeException("ERROR! La ID de la prueba no existe.");
        }           
        Prueba prueba = pruebaOpt.get();        
        Pregunta pregunta = modelMapper.map(preguntaDto, Pregunta.class);
        log.warn("Pregunta : " + pregunta);
        pregunta.setPrueba(prueba); //Asigno la prueba despues de obtenerla con la ID
        preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
        log.warn("PreguntaDto : " + preguntaDto);
        pregunta = repositorioPregunta.save(pregunta); 
        
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