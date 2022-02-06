package modelo.vo.Produto;

import lombok.Data;

/**
 * Clase que representa a Bebida na nosa aplicación. Extende de produto
 */
@Data
public class Bebida extends Produto {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private TipoBebida tipo;
	private String fabricante;

	public Bebida() {
	}

	public Bebida(int id, String nome) {
		super(id, nome);
		this.tipo = tipo;
		this.fabricante = fabricante;
	}
}