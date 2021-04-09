package co.edu.utp.isc.gia.pruebas.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) //No muestra valores nulos 
public class UsuarioDto implements Serializable {
    private Long id;
    public String nombre;
    private String userID;
    public String email;
    private String contraseña;
    @JsonProperty(access = Access.WRITE_ONLY) //Cuando se liste, no mostrar el tipo de usuario
    public int tipo_usuario;
    //Datos Docente
    public String materias;
    public String grupos;
    //Datos Estudiante
    public String curso;   
}