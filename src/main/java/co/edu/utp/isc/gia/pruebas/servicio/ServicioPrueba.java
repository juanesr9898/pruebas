package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import co.edu.utp.isc.gia.pruebas.data.entity.usuarios.Docente;
import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioPrueba;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioUsuario;
import co.edu.utp.isc.gia.pruebas.exceptions.MensajeException;
import co.edu.utp.isc.gia.pruebas.web.dto.PruebaDto;
import co.edu.utp.isc.gia.pruebas.web.dto.UsuarioDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor //constructor para model mapper y el repositorio Prueba
@Service
@Slf4j
public class ServicioPrueba {
    private ModelMapper modelMapper = new ModelMapper();
    private RepositorioPrueba repositorioPrueba;
    private ServicioUsuario servicioUsuario;
    private RepositorioUsuario repositorioUsuario;
    
    public PruebaDto crearPrueba(PruebaDto pruebaDto) throws MensajeException{
        Usuario usuario = repositorioUsuario.findById(pruebaDto.getDocenteID()).get();
        if(usuario == null){
            throw new MensajeException("ERROR! La ID del docente no existe.");
        }
        if(usuario.getTipoUsuario() == 1){
            throw new MensajeException("ERROR! Debe la prueba debe ser creada por un docente.");
        }
        Prueba prueba = modelMapper.map(pruebaDto, Prueba.class);  
        pruebaDto = modelMapper.map(prueba, PruebaDto.class);
        prueba.setDocente(usuario);
        prueba = repositorioPrueba.save(prueba);
        return pruebaDto;
    }
    
    public List<PruebaDto> FindAllByUser(Long id) throws MensajeException{   
        log.info("ID : " + id);
        if( id == null ){
            throw new MensajeException("ERROR! ID = null .");
        }
        List<PruebaDto> pruebasDto = listarTodos();   //Todas las pruebas 
        List<PruebaDto> pruebasDtoByID = new ArrayList<PruebaDto>(); 
        for (PruebaDto prueba : pruebasDto){
            log.info("Prueba for: " + prueba);
            
            if(prueba.getDocenteID() == id){
                pruebasDtoByID.add(prueba);
                log.info("Prueba if: " + prueba);
            }
        }
        log.warn("Prueba: " + pruebasDtoByID);
        if( pruebasDtoByID == null ){
            throw new MensajeException("ERROR! No hay pruebas asociadas al docente especificado .");
        }
        return pruebasDtoByID;
    }  
    
    public List<PruebaDto> listarTodos(){         
        List<Prueba> pruebas = (List<Prueba>) repositorioPrueba.findAll();
        List<PruebaDto> pruebaDto = new ArrayList<PruebaDto>();        
        pruebas.forEach((prueba) -> {pruebaDto.add(modelMapper.map(prueba, PruebaDto.class));});
        return pruebaDto;
     }
    
    public PruebaDto findOne(Long id) throws MensajeException{        
        Optional<Prueba> prueba = repositorioPrueba.findById(id);  
        if(!prueba.isPresent()){
            throw new MensajeException("ERROR! La prueba no existe.");
        }
        return modelMapper.map(prueba.get(), PruebaDto.class);
    }   
    
    public PruebaDto updateOne(Long id, PruebaDto pruebaDto) throws MensajeException{
        findOne(id); //Llamo a findOne si no hay error es que la prueba ID existe
        Prueba prueba = modelMapper.map(pruebaDto, Prueba.class);
        pruebaDto = modelMapper.map(prueba, PruebaDto.class);
        prueba.setId(id);
        prueba = repositorioPrueba.save(prueba);    
        return pruebaDto;
    }
    
    public PruebaDto removeOne(Long id){
        Optional<Prueba> prueba = repositorioPrueba.findById(id);    
        PruebaDto PruebaDto = new PruebaDto();
        PruebaDto = modelMapper.map(prueba.get(), PruebaDto.class);
        repositorioPrueba.deleteById(id);
        return PruebaDto;        
    }

}
