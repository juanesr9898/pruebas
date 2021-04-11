package co.edu.utp.isc.gia.pruebas.web.controller;

import co.edu.utp.isc.gia.pruebas.servicio.ServicioPregunta;
import co.edu.utp.isc.gia.pruebas.web.dto.PreguntaDto;
import co.edu.utp.isc.gia.pruebas.exceptions.MensajeException;
import static java.rmi.server.LogStream.log;
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
@Slf4j
@RequestMapping("preguntas")
public class ControladorPregunta {
    private ServicioPregunta servicioPregunta;
    
    @PostMapping()
    public PreguntaDto guardar(@RequestBody PreguntaDto preguntaDto) throws MensajeException{
        return servicioPregunta.guardar(preguntaDto); 
    }
    
    @GetMapping()
    public List<PreguntaDto> listarPreguntas() throws MensajeException{      
        log.info("PreguntaDto: " + servicioPregunta.listarPreguntas());
        return servicioPregunta.listarPreguntas();
    }
    
    @GetMapping("/{id}")
    public PreguntaDto findOne(@PathVariable("id") Long id){
        return servicioPregunta.findOne(id);
    }
    
    @PutMapping("/{id}")
    public PreguntaDto updateOne(@PathVariable("id") Long id, @RequestBody PreguntaDto pruebaDto){
        return servicioPregunta.updateOne(id, pruebaDto);
    }
    
    @DeleteMapping("/{id}")
    public PreguntaDto removeOne(@PathVariable("id") Long id){
        return servicioPregunta.removeOne(id);
    }
}
