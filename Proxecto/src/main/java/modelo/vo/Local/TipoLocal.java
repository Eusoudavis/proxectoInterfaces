package modelo.vo.Local;

import lombok.Data;

/**
 * Clase que representa o tipo de local na nosa aplicación
 */
@Data
public class TipoLocal {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int idTipoLocal;
	private String nomeTipo;
}