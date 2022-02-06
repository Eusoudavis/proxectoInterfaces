package modelo.vo.Carta;

import lombok.Data;

/**
 * Clase que representa os Tipos de Carta na nosa aplicación.
 */
@Data
public class TipoCarta {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int idTipoCarta;
	private String nomeTipoCarta;
}