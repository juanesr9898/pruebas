package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import co.edu.utp.isc.gia.pruebas.data.entity.usuarios.Docente;
import co.edu.utp.isc.gia.pruebas.data.entity.usuarios.Estudiante;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioUsuario;
import co.edu.utp.isc.gia.pruebas.exceptions.MensajeException;
import co.edu.utp.isc.gia.pruebas.web.dto.UsuarioDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@AllArgsConstructor 
@Service
@Slf4j
public class ServicioUsuario {
    private ModelMapper modelMapper = new ModelMapper();
    private RepositorioUsuario repositorioUsuario;
     
    public UsuarioDto guardar(UsuarioDto usuarioDto){
        log.warn("Dto: " + usuarioDto);
        if (usuarioDto.getTipoUsuario() == 1){
            Estudiante estudiante = modelMapper.map(usuarioDto, Estudiante.class);
            usuarioDto = modelMapper.map(estudiante, UsuarioDto.class);
            estudiante = repositorioUsuario.save(estudiante);             
        }else if(usuarioDto.getTipoUsuario() == 0){
            Docente docente = modelMapper.map(usuarioDto, Docente.class);
            usuarioDto = modelMapper.map(docente, UsuarioDto.class);
            docente = repositorioUsuario.save(docente); 
        }
        return usuarioDto;
    }
     
    public List<UsuarioDto> listarTodos(){         
        List<Usuario> usuarios = (List<Usuario>) repositorioUsuario.findAll();
        List<UsuarioDto> usuarioDto = new ArrayList<UsuarioDto>();        
        usuarios.forEach((usuario) -> {usuarioDto.add(modelMapper.map(usuario, UsuarioDto.class));});
        return usuarioDto;
     }
    
    public UsuarioDto findOne(Long id)throws MensajeException{        
        return modelMapper.map(findUsuario(id), UsuarioDto.class);
    }
    
    protected Usuario findUsuario(Long id)throws MensajeException{        
        Optional<Usuario> user = repositorioUsuario.findById(id);
        log.warn("user"+user);
        if(!user.isPresent()){
            throw new MensajeException("ERROR! El usuario no existe.");
        }
        return user.get();
    }
    
    public UsuarioDto updateOne(Long id, UsuarioDto usuarioDto){
        if (usuarioDto.getTipoUsuario() == 1){
            Estudiante estudiante = modelMapper.map(usuarioDto, Estudiante.class);
            usuarioDto = modelMapper.map(estudiante, UsuarioDto.class);
            estudiante.setId(id);
            estudiante = repositorioUsuario.save(estudiante);             
        }
        else if(usuarioDto.getTipoUsuario() == 0){
            Docente docente = modelMapper.map(usuarioDto, Docente.class);
            usuarioDto = modelMapper.map(docente, UsuarioDto.class);
            docente.setId(id);
            docente = repositorioUsuario.save(docente);    
        }
        return usuarioDto;
    }
    
    public UsuarioDto removeOne(Long id){
        Optional<Usuario> user = repositorioUsuario.findById(id);    
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto = modelMapper.map(user.get(), UsuarioDto.class);
        repositorioUsuario.deleteById(id);
        return usuarioDto;        
    }
}
