package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPregunta;
import co.edu.utp.isc.gia.pruebas.web.dto.PreguntaDto;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ServicioPregunta {
    private ModelMapper modelMapper = new ModelMapper();
    private RepositorioPregunta repositorioPregunta;
    
    public PreguntaDto guardar(PreguntaDto preguntaDto){        
        Pregunta pregunta = modelMapper.map(preguntaDto, Pregunta.class);
        pregunta.setRespuesta_correcta(pregunta.respuesta_correcta.toLowerCase()); //Pasamos respuesta_correcta a minuscula
        pregunta = repositorioPregunta.save(pregunta);         
        preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
        return preguntaDto;
    }
    
    public PreguntaDto listarTodos(){        
        Iterable<Pregunta> pregunta = repositorioPregunta.findAll();
        return modelMapper.map(pregunta.iterator(), PreguntaDto.class);
     }
    
    public String listarPregunta(){        
        PreguntaDto preguntasDto = listarTodos();
        String preguntas = preguntasDto.getDescripcion();
        return preguntas;
     }
    
    public PreguntaDto findOne(Long id){        
        Optional<Pregunta> user = repositorioPregunta.findById(id);         
        return modelMapper.map(user.get(), PreguntaDto.class);
    }    
    
    public PreguntaDto updateOne(Long id, PreguntaDto PreguntaDto){
        PreguntaDto.setId(id);
        repositorioPregunta.save(modelMapper.map(PreguntaDto, Pregunta.class));    
        return findOne(id);
    }
    
    public PreguntaDto removeOne(Long id){
        Optional<Pregunta> user = repositorioPregunta.findById(id);    
        PreguntaDto PreguntaDto = new PreguntaDto();
        PreguntaDto = modelMapper.map(user.get(), PreguntaDto.class);
        repositorioPregunta.deleteById(id);
        return PreguntaDto;        
    }
}
