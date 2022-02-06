package modelo.vo.Concello;

import lombok.Data;

/**
 * Clase que representa os concellos na nosa aplicación.
 */
@Data
public class Concello {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int idConcello;
	private String nomeConcello;
	private int codigoPostal;


}