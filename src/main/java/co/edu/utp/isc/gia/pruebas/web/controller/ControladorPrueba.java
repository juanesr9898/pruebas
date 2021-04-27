package co.edu.utp.isc.gia.pruebas.web.controller;

import co.edu.utp.isc.gia.pruebas.exceptions.MensajeException;
import co.edu.utp.isc.gia.pruebas.servicio.ServicioPrueba;
import co.edu.utp.isc.gia.pruebas.web.dto.PruebaDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("prueba")
@Slf4j
public class ControladorPrueba {
    private ServicioPrueba servicioPrueba;
    
    @PostMapping()
    public PruebaDto guardar(@RequestBody PruebaDto pruebaDto) throws MensajeException{
        return servicioPrueba.crearPrueba(pruebaDto); 
    }
    
    @GetMapping()
    public List<PruebaDto> listarTodos(){
        return servicioPrueba.listarTodos();
    }
    
    @GetMapping("list/{id}")
    public List<PruebaDto> FindAllByUser(@PathVariable("id") Long id) throws MensajeException{
        log.info("ID GetMapping: " + id);
        return servicioPrueba.FindAllByUser(id);
    }
    
    @GetMapping("/{id}")
    public PruebaDto findOne(@PathVariable("id") Long id) throws MensajeException{
        return servicioPrueba.findOne(id);
    }
    
    @GetMapping("presentar/{id}")
    public PruebaDto presentarPrueba(@PathVariable("id") Long id) throws MensajeException{
        return servicioPrueba.findOne(id);
    }
    
    @PutMapping("/{id}")
    public PruebaDto updateOne(@PathVariable("id") Long id, @RequestBody PruebaDto pruebaDto) throws MensajeException{
        return servicioPrueba.updateOne(id, pruebaDto);
    }
    
    @DeleteMapping("/{id}")
    public PruebaDto removeOne(@PathVariable("id") Long id){
        return servicioPrueba.removeOne(id);
    }
}
