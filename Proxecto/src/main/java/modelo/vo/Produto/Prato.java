package modelo.vo.Produto;

import lombok.Data;

/**
 * Clase que representa o prato na nosa aplicación. Extende de produto
 */
@Data
public class Prato extends Produto {

	public Prato() {
	}

	public Prato(int id) {
		super(id);
	}
}