package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import co.edu.utp.isc.gia.pruebas.data.entity.preguntas.Respuesta;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPrueba;
import co.edu.utp.isc.gia.pruebas.web.dto.PruebaDto;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor //constructor para model mapper y el repositorio Prueba
@Service
public class ServicioPrueba {
    private ModelMapper modelMapper = new ModelMapper();
    private RepositorioPrueba repositorioPrueba;
    
    public PruebaDto crearPrueba(PruebaDto pruebaDto) {
        Prueba prueba = modelMapper.map(pruebaDto, Prueba.class);
        prueba = repositorioPrueba.save(prueba);
        pruebaDto = modelMapper.map(prueba, PruebaDto.class);
        return pruebaDto;
    }
    
    public PruebaDto guardar(List<Respuesta> respuestas, Usuario usuario, Long id_prueba) {
        PruebaDto pruebaDto = findOne(id_prueba); //busco la prueba al usuario
        List<Pregunta> preguntas = (List<Pregunta>) pruebaDto.getPregunta();
        float valor_preguntas = preguntas.size() / 5; //Número de preguntas / 5
        for(int i = 0; i < respuestas.size(); ++i) //recorro lista de respuestas
            //comparo la lista de respuesta con la ista de respuestas correctas
            if(respuestas.get(i).respuesta == preguntas.get(i).respuesta_correcta) {
                pruebaDto.setNota(pruebaDto.getNota() + valor_preguntas);
         }     
        return pruebaDto;
    }
    
    public PruebaDto listarTodos(){        
        Iterable<Prueba> Pruebas = repositorioPrueba.findAll();
        return modelMapper.map(Pruebas.iterator(), PruebaDto.class);
     }
    
    public PruebaDto findOne(Long id){        
        Optional<Prueba> prueba = repositorioPrueba.findById(id);         
        return modelMapper.map(prueba.get(), PruebaDto.class);
    }    
    
    public PruebaDto updateOne(Long id, PruebaDto PruebaDto){
        PruebaDto.setId(id);
        repositorioPrueba.save(modelMapper.map(PruebaDto, Prueba.class));    
        return findOne(id);
    }
    
    public PruebaDto removeOne(Long id){
        Optional<Prueba> prueba = repositorioPrueba.findById(id);    
        PruebaDto PruebaDto = new PruebaDto();
        PruebaDto = modelMapper.map(prueba.get(), PruebaDto.class);
        repositorioPrueba.deleteById(id);
        return PruebaDto;        
    }

}
