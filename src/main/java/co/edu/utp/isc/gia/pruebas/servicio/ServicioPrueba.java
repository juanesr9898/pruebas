package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import co.edu.utp.isc.gia.pruebas.data.entity.usuarios.Docente;
//import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
//import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPrueba;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioUsuario;
import co.edu.utp.isc.gia.pruebas.web.dto.PruebaDto;
import java.util.ArrayList;
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
    private RepositorioUsuario repositorioUsuario;
    
    public PruebaDto crearPrueba(PruebaDto pruebaDto) {
        Optional <Usuario> usuarioOpt = repositorioUsuario.findById(pruebaDto.getDocenteID()); 
        Usuario usuario = usuarioOpt.get();
        Docente docente = modelMapper.map(usuario, Docente.class);
        Prueba prueba = modelMapper.map(pruebaDto, Prueba.class); 
        prueba.setDocente(docente);
        pruebaDto = modelMapper.map(prueba, PruebaDto.class);
        prueba = repositorioPrueba.save(prueba);
        return pruebaDto;
    }
    
    public List<PruebaDto> listarTodos(){         
        List<Prueba> pruebas = (List<Prueba>) repositorioPrueba.findAll();
        List<PruebaDto> pruebaDto = new ArrayList<PruebaDto>();        
        pruebas.forEach((prueba) -> {pruebaDto.add(modelMapper.map(prueba, PruebaDto.class));});
        return pruebaDto;
     }
    
    public PruebaDto findOne(Long id){        
        Optional<Prueba> prueba = repositorioPrueba.findById(id);         
        return modelMapper.map(prueba.get(), PruebaDto.class);
    }    
    
    public PruebaDto updateOne(Long id, PruebaDto PruebaDto){
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
