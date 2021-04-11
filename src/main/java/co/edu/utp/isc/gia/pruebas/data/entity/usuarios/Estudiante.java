package co.edu.utp.isc.gia.pruebas.data.entity.usuarios;

import co.edu.utp.isc.gia.pruebas.data.entity.Usuario;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Entity
@Table(name = "Estudiantes")
public class Estudiante extends Usuario{
    public String curso;
}
