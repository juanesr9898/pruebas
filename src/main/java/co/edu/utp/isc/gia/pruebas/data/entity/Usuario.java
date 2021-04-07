package co.edu.utp.isc.gia.pruebas.data.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
@Table(name = "Usuario")
public class Usuario implements Serializable{    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String nombre;
    public String email;
    private String contraseña;
    public int tipo_usuario;
    
}
