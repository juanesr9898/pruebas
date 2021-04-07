package co.edu.utp.isc.gia.pruebas.data.entity.usuarios;

import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Estudiante extends Usuario{
    public String curso;
    public String grupo;
}
