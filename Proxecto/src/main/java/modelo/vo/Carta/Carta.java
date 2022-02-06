package modelo.vo.Carta;

import lombok.Data;

/**
 * Clase que representa as cartas na nosa aplicación.
 */
@Data
public class Carta {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int idCarta;
	private String epocaAno;
	private String nome;
	private TipoCarta idTipoCarta;

}