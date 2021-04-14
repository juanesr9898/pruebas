package co.edu.utp.isc.gia.pruebas.data.entity.usuarios;

import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Docente")
public class Docente extends Usuario{
    public String materias;
    public String grupos;
}
