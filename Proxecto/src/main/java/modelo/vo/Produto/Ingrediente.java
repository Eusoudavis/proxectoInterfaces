package modelo.vo.Produto;

import lombok.Data;

/**
 * Clase que representa os ingredientes na nosa aplicación.
 */
@Data
public class Ingrediente {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int idIngrediente;
	private String nomeIngrediente;
}