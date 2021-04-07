package co.edu.utp.isc.gia.pruebas.web.dto;

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
public class UsuarioDto implements Serializable {
    private Long id;
    public String nombre;
    public String email;
    private String contraseña;
    public int tipo_usuario;

}