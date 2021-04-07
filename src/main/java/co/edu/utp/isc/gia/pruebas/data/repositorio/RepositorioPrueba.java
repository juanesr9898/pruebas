package co.edu.utp.isc.gia.pruebas.data.repositorio;

import co.edu.utp.isc.gia.pruebas.data.entity.Prueba;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPrueba extends CrudRepository<Prueba, Long>{
    @Override
    Optional<Prueba> findById (Long id);
    
    @Override
    Iterable<Prueba> findAll ();

    @Override
    void deleteById (Long id);
}
