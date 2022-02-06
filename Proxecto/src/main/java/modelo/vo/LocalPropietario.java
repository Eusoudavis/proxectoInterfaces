package modelo.vo;

import lombok.Data;
import modelo.vo.Local.Local;
import modelo.vo.Usuario.Propietario;

/**
 * Clase que representa a relación entre Local e Propietario
 */
@Data
public class LocalPropietario {
    /**
     * Atributos de clase
     */
    private Local idLocal;
    private Propietario idPropietario;
}
