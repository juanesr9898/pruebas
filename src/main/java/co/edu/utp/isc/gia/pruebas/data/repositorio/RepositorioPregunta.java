package co.edu.utp.isc.gia.pruebas.data.repositorio;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPregunta extends CrudRepository<Pregunta, Long>{
    @Override
    Optional<Pregunta> findById (Long id);
    
    @Override
    Iterable<Pregunta> findAll ();

    @Override
    void deleteById (Long id);
}
