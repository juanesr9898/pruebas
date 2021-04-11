package co.edu.utp.isc.gia.pruebas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
        
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MensajeException extends Exception{
    public MensajeException(String rason) {
        super(rason);
    }
}

