package co.edu.utp.isc.gia.pruebas.data.repositorio;

import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
    @Override
    Optional<Usuario> findById (Long id);
    
    @Override
    Iterable<Usuario> findAll ();

    @Override
    void deleteById (Long id);
    
    public Optional<Usuario> findByUsername(String username);
    
}

