package modelo.vo.Local;

import lombok.Data;

/**
 * Clase que representa a relación entre Local e Tipo_Local na nosa aplicación.
 */
@Data
public class LocalTipoLocal {
    /**
     * Atributos de clase que representan os campos para a táboa na bbdd
     */
    private Local local;
    private TipoLocal tipoLocal;
}
