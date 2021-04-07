package co.edu.utp.isc.gia.pruebas.servicio;

import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import co.edu.utp.isc.gia.pruebas.data.repositorio.RepositorioUsuario;
import co.edu.utp.isc.gia.pruebas.web.dto.UsuarioDto;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@AllArgsConstructor //constructor para model mapper y el repositorio usuario
@Service
public class ServicioUsuario {
    private ModelMapper modelMapper = new ModelMapper();
    private RepositorioUsuario repositorioUsuario;
     
    public UsuarioDto guardar(UsuarioDto usuarioDto){        
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario = repositorioUsuario.save(usuario);         
        usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        return usuarioDto;
    }
     
    public UsuarioDto listarTodos(){        
        Iterable<Usuario> usuarios = repositorioUsuario.findAll();
        return modelMapper.map(usuarios.iterator(), UsuarioDto.class);
     }
    
    public UsuarioDto findOne(Long id){        
        Optional<Usuario> user = repositorioUsuario.findById(id);         
        return modelMapper.map(user.get(), UsuarioDto.class);
    }    
    
    public UsuarioDto updateOne(Long id, int tipo_usuario, UsuarioDto usuarioDto){
        usuarioDto.setId(id);
        usuarioDto.setTipo_usuario(tipo_usuario);
        repositorioUsuario.save(modelMapper.map(usuarioDto, Usuario.class));    
        return findOne(id);
    }
    
    public UsuarioDto removeOne(Long id){
        Optional<Usuario> user = repositorioUsuario.findById(id);    
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto = modelMapper.map(user.get(), UsuarioDto.class);
        repositorioUsuario.deleteById(id);
        return usuarioDto;        
    }
    
//    public Prueba verPrueba(Long id){
//        
//    }
}
