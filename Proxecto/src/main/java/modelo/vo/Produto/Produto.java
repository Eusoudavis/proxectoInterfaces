package modelo.vo.Produto;

import lombok.Data;

@Data
public abstract class Produto {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int id;
	private String nome;


	public Produto() {
	}

	public Produto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Produto(int id) {
		this.id = id;
	}
}